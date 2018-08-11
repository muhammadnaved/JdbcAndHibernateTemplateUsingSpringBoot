package com.boot.configuration;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * @author Naved Khan
 *
 */
@Configuration
public class HibernateConfiguration {

	 private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   @Bean("sessionFactory")	
	   public SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {
	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
	            Map<String, String> settings = new HashMap<>();
	            settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
	            settings.put(Environment.URL, "jdbc:oracle:thin:@hostName:portNo:schemaName");
	            settings.put(Environment.USER, "username");
	            settings.put(Environment.PASS, "password");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
	            settings.put(Environment.SHOW_SQL, "true");
	            
	            registryBuilder.applySettings(settings);

	            registry = registryBuilder.build();

	            MetadataSources sources = new MetadataSources(registry);

	            Metadata metadata = sources.getMetadataBuilder().build();

	            sessionFactory = metadata.getSessionFactoryBuilder().build();

	         } catch (Exception e) {
	            e.printStackTrace();
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	@Bean
	public HibernateTemplate getHibernateTemplate(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		HibernateTemplate template = new HibernateTemplate(sessionFactory);
		return template;
	}
	
}

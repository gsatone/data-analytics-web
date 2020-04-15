package main.java.rgf.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hibernate.properties" })
@ComponentScan({ "main.java.rgf" })
public class PersistenceConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		System.out.println("ENV :   driverClassName : " + env.getProperty("jdbc.driverClassName"));
		System.out.println("ENV :               url : " + env.getProperty("jdbc.url"));
		System.out.println("ENV :          username : " + env.getProperty("jdbc.username"));
		System.out.println("ENV :          password : " + env.getProperty("jdbc.password"));
		System.out.println("ENV :hibernate.ddl-auto : " + env.getProperty("hibernate.ddl-auto"));
		System.out.println("ENV : hibernate.dialect : " + env.getProperty("hibernate.dialect"));
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(
				new String[] { "main.java.rgf.data.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		
//		System.out.println("In PersistenceConfig");
//		Properties sesprop = sessionFactory.getHibernateProperties();
//		System.out.println("In PersistenceConfig HibernateProperties"+ sesprop.toString());

		return sessionFactory;
	}

	@Bean
	public DataSource restDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {

		HibernateTransactionManager txManager
		= new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}
}
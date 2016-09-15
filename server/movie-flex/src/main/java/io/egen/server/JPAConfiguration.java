package io.egen.server;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfiguration {
	
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerBeanFactory (){
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("io.egen.server.entity");
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		
		return emf;
		
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/new_schema?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("uday");
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
		
		JpaTransactionManager txnManager = new JpaTransactionManager(emf);
		
		return txnManager;
		
	}
	
	public Properties jpaProperties() {
		Properties prop = new Properties();
		prop.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
		prop.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		prop.setProperty(PersistenceUnitProperties.WEAVING, "false");
		return prop;
	}

}

package br.com.kemedico.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
public class JPAConfiguration {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(adapter);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("sistema");
		dataSource.setPassword("springhealth");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/db_site");
		dataSource.setDriverClassName("org.postgresql.Driver");
		factoryBean.setDataSource(dataSource);
		
		Properties props = new Properties();		
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		factoryBean.setJpaProperties(props);
		factoryBean.setPackagesToScan("org.kemedico.model");
		
		return factoryBean;
	}
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}	
}

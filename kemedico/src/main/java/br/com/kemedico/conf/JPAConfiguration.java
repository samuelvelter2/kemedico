package br.com.kemedico.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.hibernate.ogm.jpa.HibernateOgmPersistence;
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
		/*dataSource.setUsername("sistema");
		dataSource.setPassword("springhealth");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/db_site");
		dataSource.setDriverClassName("org.postgresql.Driver");*/
		factoryBean.setDataSource(dataSource);
		
		
		Properties props = new Properties();
		props.setProperty("javax.persistence.transactionType", "resource_local");
		props.setProperty("hibernate.ogm.datastore.provider","mongodb");
		props.setProperty("hibernate.ogm.datastore.host","localhost");
		props.setProperty("hibernate.ogm.datastore.port","27017");
		props.setProperty("hibernate.ogm.datastore.database", "db_site");
		props.setProperty("hibernate.ogm.datastore.create_database", "true");
		/*props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");*/
		factoryBean.setJpaProperties(props);
		factoryBean.setPackagesToScan("br.com.kemedico.model");
		factoryBean.setPersistenceProviderClass(HibernateOgmPersistence.class);
		
		return factoryBean;
	}
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}	
}

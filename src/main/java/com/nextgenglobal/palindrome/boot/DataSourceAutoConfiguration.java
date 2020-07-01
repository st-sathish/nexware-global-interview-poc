package com.nextgenglobal.palindrome.boot;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class DataSourceAutoConfiguration {

	@Autowired
    private Environment environment;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JpaVendorAdapter vendorAdapter;
	
	@Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(vendorAdapter);
        lcemfb.setDataSource(dataSource);
        lcemfb.setPersistenceUnitName("nextware_global");
        lcemfb.setPackagesToScan("com.nextgenglobal");
        lcemfb.setJpaProperties(hibernateProperties());
        return lcemfb;
    }
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
}

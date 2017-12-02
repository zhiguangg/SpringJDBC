package com.java.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.java.spring.*")
@EnableTransactionManagement
@PropertySources({@PropertySource("classpath:ds/datasource-cfg.properties")})
public class AppConfiguration {

	//The Environment class serves as the property holder
	//and stores all the properties loaded by teh @PropertySource
	@Autowired
	private Environment env;
	
	//Spring Bean
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		//BasicDataSource dataSource = new BasicDataSource();\
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));
		
		System.out.println("## getDataSource: " + dataSource);
		
		return dataSource;
	}
}

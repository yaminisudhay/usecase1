package com.yubi.geographycolumns;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class GeographyColumnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeographyColumnsApplication.class, args);
	}
	
	@Autowired
	Environment env;
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	DataSource getDataSource() {
		//System.out.println(env.getProperty("spring.datasource.driver-class-name"));
		//System.out.println(env.getProperty("spring.datasource.url"));
		//System.out.println(env.getProperty("spring.datasource.username"));
		//System.out.println(env.getProperty("spring.datasource.password"));
		DataSourceBuilder dsb = DataSourceBuilder.create();
		dsb.driverClassName(env.getProperty("spring.datasource.driver-class-name"))
			.url(env.getProperty("spring.datasource.url"))
			.username(env.getProperty("spring.datasource.username"))
			.password(env.getProperty("spring.datasource.password"));
		return dsb.build();
	}

}

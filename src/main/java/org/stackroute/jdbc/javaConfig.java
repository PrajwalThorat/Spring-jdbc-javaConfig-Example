package org.stackroute.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.stackroute.jdbc.Doa.StudentDao;
import org.stackroute.jdbc.Doa.StudentDaoImpl;

@Configuration
public class javaConfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jdbcDemo");
		ds.setUsername("root");
		ds.setPassword("Pass@123");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
	
	@Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDaoImpl student = new StudentDaoImpl();
		student.setJdbcTemplate(getTemplate());
		return student;
	}

}

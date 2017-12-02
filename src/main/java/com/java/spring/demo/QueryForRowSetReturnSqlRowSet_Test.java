package com.java.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.java.spring.config.AppConfiguration;
import com.java.spring.dao.QueryForRowSetReturnSqlRowSetDAO;

public class QueryForRowSetReturnSqlRowSet_Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		QueryForRowSetReturnSqlRowSetDAO dao = context.getBean(QueryForRowSetReturnSqlRowSetDAO.class);
		
		SqlRowSet rowSet = dao.queryForRowSet();
	
		while(rowSet.next()) {
			System.out.println("----------");
			System.out.println("Emp_Id: " + rowSet.getLong("Emp_Id") + " Emp_No: "+rowSet.getString(2) + " Emp_name: "+ rowSet.getString("Emp_Name"));
		}
		
		((ConfigurableApplicationContext)context).close();
	}
}

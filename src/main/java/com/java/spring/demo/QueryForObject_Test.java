package com.java.spring.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.spring.config.AppConfiguration;
import com.java.spring.dao.QueryForListReturnListDAO;

public class QueryForObject_Test {

	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		QueryForListReturnListDAO dao = context.getBean(QueryForListReturnListDAO.class);
		
		List<String> names = dao.getDeptNames("C");
		
		for (String name : names) {
			System.out.println("Dept Name: " + name);
		}
		((ConfigurableApplicationContext)context).close();
	}
}

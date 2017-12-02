package com.java.spring.demo;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.spring.config.AppConfiguration;
import com.java.spring.dao.QueryForListReturnListMapDAO;

public class QueryForListReturnListMap_Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		QueryForListReturnListMapDAO dao = context.getBean(QueryForListReturnListMapDAO.class);
		List<Map<String, Object>> list1 = dao.QueryForList_ListMap();
		
		System.out.println("-------------------QueryForList_ListMap()");
		for(Map<String, Object> map : list1) {
			for(String key : map.keySet()) {
				System.out.println("Key: "+key + " value:" + map.get(key));
			}
		}
		
		List<Map<String, Object>> list2 = dao.QueryForLit_ListMap2();
		System.out.println("-------------------QueryForList_ListMap2()");
		for (Map<String, Object> map : list2) {
			for (String key : map.keySet()) {
				System.out.println("Key: "+ key + " value: "+ map.get(key));
			}
		}
		((ConfigurableApplicationContext)context).close();
	}
}

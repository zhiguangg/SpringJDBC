package com.java.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class QueryForListReturnListDAO extends JdbcDaoSupport{

	@Autowired
	public void QueryforListReturnListDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<String> getDeptNames(){
		String sql = "Select d.dept_name from Depertment d ";
		
		//
		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		
		return list;
	}
	
	public List<String> getDeptNames(String searchName) {
		String sql = "select d.dept_name from Department d where d.dept_name like ? ";
		
		List<String> list = this.getJdbcTemplate().queryForList(sql,String.class, "%" + searchName + "%");
		
		return list;
	}
}

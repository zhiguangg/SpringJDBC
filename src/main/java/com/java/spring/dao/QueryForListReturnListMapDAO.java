package com.java.spring.dao;

import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.java.spring.util.DateUtils;

@Repository
public class QueryForListReturnListMapDAO extends JdbcDaoSupport {

	@Autowired
	public QueryForListReturnListMapDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	//List<Map<String columnName, Object value>> 
	public List<Map<String, Object>> QueryForList_ListMap() {
		String sql = "Select e.EMP_ID, e.EMP_NO, e.EMP_NAME from Employee e";
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql);
		
		return result;
	}
	
	//List<Map<String, Object>>
	//queryForList(String, sql, Object args, int[] artTypes)
	public List<Map<String, Object>> QueryForLit_ListMap2() {
		String sql = "Select e.EMP_ID, e.EMP_NO, e.EMP_NAME from Employee e where e.Hire_Date > ? and e.salary > ? ";
		Date hireDate = DateUtils.getDateByYear(1981);
		int[] argTypes = {Types.DATE, Type.DOUBLE};
		Object[] args = new Object[]{hireDate, 2800};
		List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql, args, argTypes);
		return list;
	}

}

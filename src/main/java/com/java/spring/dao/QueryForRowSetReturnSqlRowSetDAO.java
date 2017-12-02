package com.java.spring.dao;

import java.util.Date;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.java.spring.util.DateUtils;

@Repository
public class QueryForRowSetReturnSqlRowSetDAO extends JdbcDaoSupport {

	@Autowired
	public QueryForRowSetReturnSqlRowSetDAO(DataSource datasource) {
		this.setDataSource(datasource);
	}
	
	//SqlRowSet queryForRowSet(String sql, Object[] args, int[] argTypes)
	public SqlRowSet queryForRowSet() {
		String sql = "Select e.EMP_ID, e.EMP_No, e.EMP_Name from Employee e where e.Hire_date > ? and e.salary > ? ";
		Date hireDate = DateUtils.getDateByYear(1981);
		Object[] args = new Object[] {hireDate, 2800};
		int[] argTypes = new int[]{Types.DATE, Types.DOUBLE};
		
		SqlRowSet rowSet = this.getJdbcTemplate().queryForRowSet(sql, args, argTypes);
		
		return rowSet;
	}
	
	
}

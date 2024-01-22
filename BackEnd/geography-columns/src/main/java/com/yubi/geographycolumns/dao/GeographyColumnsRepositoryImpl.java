package com.yubi.geographycolumns.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentTypePreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.yubi.geographycolumns.entity.OldNewMap;


@Repository
public class GeographyColumnsRepositoryImpl implements GeographyColumnsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	@Override
	public List<String> getDistinctList(String tableName, String columnName) {
		
		String sql="select distinct "+columnName+" from "+tableName;
		List<String> result = jdbcTemplate.queryForList(sql, String.class);
		return result;
	}

	@Override
	public int updateCols(String tabName, String colName, List<OldNewMap> newList) {
		
		String sql="update "+tabName+" set "+colName+"= ? where "+colName+"= ?";
		int[] types = new int[2];
		types[0]=Types.VARCHAR;
		types[1]=Types.VARCHAR;
		int rowsAffected=0;
		
		for(OldNewMap ele:newList) {
		
			Object[] obj = new Object[2];
			obj[0]=ele.getNewNm();
			obj[1]=ele.getOldNm();
			PreparedStatementSetter ps=new ArgumentTypePreparedStatementSetter(obj, types); 
			rowsAffected+=jdbcTemplate.update(sql, ps);
		}
		
		return rowsAffected;
	}

}

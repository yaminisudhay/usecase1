package com.yubi.geographycolumns.dao;

import java.util.List;

import com.yubi.geographycolumns.entity.OldNewMap;

public interface GeographyColumnsRepository{
	
	List<String> getDistinctList(String tableName,String columnName);

	int updateCols(String tabName, String colName, List<OldNewMap> newList);
}

package com.netsky.base.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @description:
 * ����JDBC������Դ
 * @class name:com.netsky.base.baseDao.JdbcSupport
 * @author wind Feb 25, 2010
 */
public interface JdbcSupport {
	/**
	 * �����������
	 * @return Connection
	 * @throws SQLException 
	 */
	public Connection getConnection() throws SQLException;
	
	/**
	 * ���jdbcģ����
	 * @return JdbcTemplate
	 */
	public JdbcTemplate   getJdbcTemplate();
	
	/**
	 * ����������������
	 * @return DataSourceTransactionManager
	 */
	public PlatformTransactionManager getTransManager();
	
}

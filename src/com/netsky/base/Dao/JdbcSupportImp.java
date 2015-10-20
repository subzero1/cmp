package com.netsky.base.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

public class JdbcSupportImp implements JdbcSupport {

	/**
	 * ����Դ
	 */
	DataSource dataSource;
	
	/**
	 * @param dataSource The dataSource to set.
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 *�����ط�����getConnection
	 * (non-Javadoc)
	 * @throws SQLException 
	 * @see com.netsky.base.baseDao.JdbcSupport#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 *�����ط�����getJdbcTemplate
	 * (non-Javadoc)
	 * @see com.netsky.base.baseDao.JdbcSupport#getJdbcTemplate()
	 */
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	/**
	 *�����ط�����getTransManager
	 * (non-Javadoc)
	 * @see com.netsky.base.baseDao.JdbcSupport#getTransManager()
	 */
	public PlatformTransactionManager getTransManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}

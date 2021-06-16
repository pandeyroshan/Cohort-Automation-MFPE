package com.cohortautomation.dao;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnection {
    private static BasicDataSource dataSource = null;
    
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/cohort_automation?autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("rootjuet");
 
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(25);
 
    }
    
    public static Connection getConnection() {
    	try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
}
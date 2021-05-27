package com.cohortautomation.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnection {
	private static HikariDataSource dataSource = null;
	 
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://31.170.167.102/u322094628_ca?autoReconnect=true");
        config.setUsername("u322094628_root");
        config.setPassword("1ED;2?^f+4");
        config.addDataSourceProperty("minimumIdle", "5");
        config.addDataSourceProperty("maximumPoolSize", "25");
 
        dataSource = new HikariDataSource(config);
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
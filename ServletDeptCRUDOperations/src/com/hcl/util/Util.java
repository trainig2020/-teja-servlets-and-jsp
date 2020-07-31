
package com.hcl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    Connection Connection;
    String jdbcURL;
	String jdbcUsername;
    String jdbcPassword;
	protected void connect() throws SQLException {
 
		if (Connection == null || Connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            
			Connection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (Connection != null && !Connection.isClosed()) {
            Connection.close();
        }
    }

	public static PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}

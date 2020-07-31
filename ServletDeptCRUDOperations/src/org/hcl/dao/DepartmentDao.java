package org.hcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hcl.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hcl.util.Util;

public class DepartmentDao {
	
	private static final String insert_dept = "insert into Department" + "(deptName, deptEmail) values" + " (?, ?);";

	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection jdbcConnection;
	     
	    public DepartmentDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	        this.jdbcURL = jdbcURL;
	        this.jdbcUsername = jdbcUsername;
	        this.jdbcPassword = jdbcPassword;
	    }
	     
	    protected void connect() throws SQLException {
	        if (jdbcConnection == null || jdbcConnection.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	         
	            }}
	    }
	     
	    protected void disconnect() throws SQLException {
	        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
	            jdbcConnection.close();
	        }
	    }
	
	  public boolean insertDepartment(Department department) throws SQLException {
	        String sql = "INSERT INTO Department (deptId,deptName, deptEmail) VALUES (?,?, ?)";
	        connect();
	        
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, department.getDeptId());
	        statement.setString(2, department.getDeptName());
	        statement.setString(3, department.getDeptEmail());
	         
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	      
	        return rowInserted;
	    }
	     
	  public List<Department> listAllDepartments() throws SQLException {
	        List<Department> listDepartment = new ArrayList<>();
	         
	        String sql = "SELECT * FROM department";
	         
	        connect();
	         
	        Statement statement = jdbcConnection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        
			while (resultSet.next()) {
	            int deptId = resultSet.getInt("deptId");
	            String deptName = resultSet.getString("deptName");
	            String deptEmail = resultSet.getString("deptEmail");
	            float price = resultSet.getFloat("price");
	             
	            Department department = new Department(deptName, deptEmail);
	            listDepartment.add(department);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        disconnect();
	         
	        return listDepartment;
	    }
	     
	    public boolean deleteDepartment(Department department) throws SQLException {
	        String sql = "DELETE FROM department where department_deptId = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, department.getDeptId());
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowDeleted;     
	    }
	     
	    public boolean updateDepartment(Department department) throws SQLException {
	        String sql = "UPDATE book SET deptName = ?, deptEmail = ?";
	        sql += " WHERE department_deptId = ?";
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setString(1, department.getDeptName());
	        statement.setString(2, department.getDeptEmail());
	        
	        statement.setInt(3, department.getDeptId());
	         
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect();
	        return rowUpdated;     
	    }
	     
	    public Department getDepartment(int deptId) throws SQLException {
	    	Department department = null;
	        String sql = "SELECT * FROM book WHERE department_deptId = ?";
	         
	        connect();
	         
	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	        statement.setInt(1, deptId);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	            String deptName = resultSet.getString("deptName");
	            String deptEmail = resultSet.getString("deptEmail");
	            
	             
	            department = new Department(deptName, deptEmail);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return department;
	    }

		
	}

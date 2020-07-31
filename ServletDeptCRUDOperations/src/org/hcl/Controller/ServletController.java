package org.hcl.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hcl.dao.DepartmentDao;

import org.hcl.model.Department;


/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private DepartmentDao departmentDao;
	 public void init() {
		    String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		    String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		    String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		 
		    departmentDao = new DepartmentDao(jdbcURL, jdbcUsername, jdbcPassword);
		 
		}
    
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 
		 try {
	            switch (action) {
	            case "/new":
	                showNewForm(request, response);
	                break;
	            case "/insert":
	                insertDepartment(request, response);
	                break;
	            case "/delete":
	                deleteDepartment(request, response);
	                break;
	            case "/edit":
	                showEditForm(request, response);
	                break;
	            case "/update":
	                updateDepartment(request, response);
	                break;
	            default:
	                listDepartment(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
		
	
		
		 private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
		            throws SQLException, IOException {
		        String deptName = request.getParameter("deptName");
		        String deptEmail = request.getParameter("deptEmail");
		        
		 
		        Department newdepartment = new Department(deptName, deptEmail);
		        departmentDao.insertDepartment(newdepartment);
		        response.sendRedirect("list");
		    }
	        
		 private void listDepartment(HttpServletRequest request, HttpServletResponse response)
		            throws SQLException, IOException, ServletException {
		        List<Department> listDepartment = departmentDao.listAllDepartments();
		        request.setAttribute("listDepartment", listDepartment);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("DepartmentList.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("DeptForm.jsp");
        dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        Department existingDepartment = departmentDao.getDepartment(deptId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("DeptForm.jsp");
        request.setAttribute("department", existingDepartment);
        dispatcher.forward(request, response);
 
    }
 
    
 
    private void updateDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        String deptName = request.getParameter("deptName");
        String deptEmail = request.getParameter("deptEmail");
        
        Department department = new Department(deptId, deptName, deptEmail);
        departmentDao.updateDepartment(department);
        response.sendRedirect("list");
    }
 
    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int deptId = Integer.parseInt(request.getParameter("deptId"));
 
        Department department = new Department(deptId, null, null);
        departmentDao.deleteDepartment(department);
        response.sendRedirect("list");
 
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DepartmentDao;
import com.dao.impl.DepartmentDaoImpl;
import com.model.Department;

@WebServlet("/department/register")
public class DepartmentSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();

	public DepartmentSaveController() {
		// Do Nothing
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptId = request.getParameter("id");
        String deptName = request.getParameter("deptName");
        
        String deptEmail = request.getParameter("deptEmail");
 
        Department department = new Department(deptName, deptEmail);
 
        if (deptId == null || deptId == "")
            departmentDao.saveDepartment(department);
        else {
            Long id = Long.parseLong(deptId);
            department.setId(id);
            departmentDao.updateDepartment(department);
        }

		response.sendRedirect(request.getContextPath() + "/");
	}

}

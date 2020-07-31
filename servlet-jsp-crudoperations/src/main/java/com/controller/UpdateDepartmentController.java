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

@WebServlet("/department/update")
public class UpdateDepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateDepartmentController() {
		// Do Nothing
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptId = request.getParameter("deptId");
		System.out.println(deptId );
		 
        if (deptId == "" || deptId == null)
            request.getRequestDispatcher("/").forward(request, response);
        else {
            Long id = Long.parseLong(deptId);
            DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();
            Department department = departmentDao.findDepartmentById(id);
 
            request.setAttribute("department", department);
 
            request.getRequestDispatcher("/").forward(request, response);
        }
   }
}

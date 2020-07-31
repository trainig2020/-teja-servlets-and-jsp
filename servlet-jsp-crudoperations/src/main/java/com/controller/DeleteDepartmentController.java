package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DepartmentDao;
import com.dao.impl.DepartmentDaoImpl;




@WebServlet("/department/delete")
public class DeleteDepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteDepartmentController() {
		// Do Nothing
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptId = request.getParameter("deptId");

		if (deptId == "" || deptId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			 Long id = Long.parseLong(deptId);
			DepartmentDao departmentDao = DepartmentDaoImpl.getInstance();

			departmentDao.deleteDepartment(id);

			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}

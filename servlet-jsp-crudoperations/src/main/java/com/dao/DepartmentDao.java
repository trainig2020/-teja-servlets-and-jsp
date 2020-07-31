package com.dao;

import java.util.List;

import com.model.Department;

public interface DepartmentDao {
Long saveDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(Long id);

	Department findDepartmentById(Long id);

	List<Department> findAllDepartments();
}

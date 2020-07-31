package com.dao.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.DepartmentDao;
import com.model.Department;
import com.util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	private static DepartmentDaoImpl departmentDaoImpl = null;
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public Long saveDepartment(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(department);
		transaction.commit();
		session.close();
		
		return id;		
	}

	public void updateDepartment(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(department);
		transaction.commit();
		session.close();
	}

	public void deleteDepartment(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Department department = (Department) session.get(Department.class, id);
		session.delete(department);
		transaction.commit();
		session.close();
	}

	
	 @SuppressWarnings("unchecked")
	    public List<Department> findAllDepartments() {
	        Session session = this.sessionFactory.openSession();
	        List<Department> departmentList = session.createCriteria(Department.class).list();
	        session.close();
	         
	        return departmentList;
	    }
	public static DepartmentDao getInstance() {
		if(departmentDaoImpl == null)
			departmentDaoImpl = new DepartmentDaoImpl();
		
		return departmentDaoImpl;
	}

	@Override
	public Department findDepartmentById(Long id) {
		Session session = this.sessionFactory.openSession();
		Department department = (Department) session.get(Department.class, id);
		session.close();
		
		return department;
	}
}

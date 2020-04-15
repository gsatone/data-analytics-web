package main.java.rgf.data.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import main.java.rgf.data.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
		Session session =  sessionFactory.openSession();
		List<Employee> empList = null;
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		empList = query.list();
		logger.info("Person List::" + empList);
		return empList;
	}

}

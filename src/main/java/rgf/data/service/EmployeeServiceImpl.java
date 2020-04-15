package main.java.rgf.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.rgf.data.dao.EmployeeDAO;
import main.java.rgf.data.dao.EmployeeDaoImpl;
import main.java.rgf.data.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public List<Employee> listEmployee() {
		return this.employeeDao.listEmployee();
	}

}

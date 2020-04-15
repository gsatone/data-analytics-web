package main.java.rgf.data.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import main.java.rgf.data.model.Employee;

//@Component
public interface EmployeeDAO {
	
	public List<Employee> listEmployee();
}

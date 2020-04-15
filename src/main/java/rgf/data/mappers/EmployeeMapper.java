package main.java.rgf.data.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import main.java.rgf.data.dao.Employee;
import main.java.rgf.data.dao.EmployeeDAO;


public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		
		emp.setEmpNo(rs.getInt("emp_no"));
		emp.setBirthDate(rs.getDate("birth_date"));
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setGender(rs.getString("gender"));
		emp.setHireDate(rs.getDate("hire_date"));
		emp.setRowNum(rowNum);
		return emp;
	}

}
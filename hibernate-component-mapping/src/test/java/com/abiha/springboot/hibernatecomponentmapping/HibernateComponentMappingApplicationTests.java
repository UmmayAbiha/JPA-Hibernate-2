package com.abiha.springboot.hibernatecomponentmapping;

import com.abiha.springboot.hibernatecomponentmapping.entities.Employee;
import com.abiha.springboot.hibernatecomponentmapping.entities.Salary;
import com.abiha.springboot.hibernatecomponentmapping.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateComponentMappingApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	public void testCreate(){

		Employee employee = new Employee();
		Salary salary = new Salary();

		employee.setId(123);
		employee.setFirstName("Ruskin");
		employee.setLastName("Bond");
		employee.setAge(43);

		salary.setBasicSalary(56789.0);
		salary.setBonusSalary(1234.50);
		salary.setTaxAmount(4000);
		salary.setSpecialAllowanceSalary(3800);

		employee.setSalary(salary);

		repository.save(employee);
	}

}

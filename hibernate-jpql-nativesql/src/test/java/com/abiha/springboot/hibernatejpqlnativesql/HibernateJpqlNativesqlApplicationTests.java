package com.abiha.springboot.hibernatejpqlnativesql;

import com.abiha.springboot.hibernatejpqlnativesql.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class HibernateJpqlNativesqlApplicationTests {

	@Autowired
	EmployeeRepo repo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee employee = new Employee();

		employee.setAge(24);
		employee.setFirstName("Ashtyn");
		employee.setLastName("Hill");
		employee.setSalary(23468.90);

		repo.save(employee);

		Employee employee2=new Employee();
		employee2.setAge(65);
		employee2.setFirstName("Ria");
		employee2.setLastName("Singh");
		employee2.setSalary(15478.2d);

		repo.save(employee2);
	}

	@Test
	public void testFindAllEmployee(){
		System.out.println(repo.findAllEmployees());
	}

	@Test
	public void testEmployeeGreaterThanAVGSalary() {
		List<Object[]> partialData = repo.findEmployeeSalaryGreaterThanAVGSalary();
		for (Object[] objects : partialData) {
			System.out.println("First Name: "+objects[0]+" Last Name: "+objects[1]);
		}
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateSalaryEmployee(){
		double avgSalary=repo.getAVGSalary();
		repo.updateSalaryLessThanAVGSalary(85993.56d,avgSalary);

	}


	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteEmployee(){
		double minSalary=repo.getMinSalary();
		repo.deleteEmployeeWithMinimumSalary(minSalary);
	}

	//Native Query


	@Test
	public void testFindAllStudentsNQ(){
		System.out.println(repo.findAllStudentNQ());
	}

	@Test
	public void testFindByLastNameNQ(){
		System.out.println(repo.findAllEmployeeByLastNameNQ());
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteEmployeeGreaterThan45NQ(){
		repo.DeleteEmployeeGreaterThan45NQ(45);
	}



}

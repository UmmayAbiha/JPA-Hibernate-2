package com.abiha.springboot.hibernatecomponentmapping.repos;

import com.abiha.springboot.hibernatecomponentmapping.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}

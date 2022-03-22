package com.abiha.springboot.hibernatejpqlnativesql;

import com.abiha.springboot.hibernatejpqlnativesql.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

    //JPQL

    @Query("from Employee")
    List<Employee> findAllEmployees();


    @Query("select firstName,lastName from Employee where salary>(select AVG(salary) from Employee) ORDER BY age ASC,salary DESC")
    List<Object[]> findEmployeeSalaryGreaterThanAVGSalary();


    @Query("select AVG(salary) from Employee")
    double getAVGSalary();

    @Modifying
    @Query("UPDATE Employee e SET e.salary=:salary WHERE e.salary<:avgSalary")
    void updateSalaryLessThanAVGSalary(@Param("salary") double salary, @Param("avgSalary") double avgSalary );


    @Query("select MIN(salary) from Employee")
    double getMinSalary();

    @Modifying  //modifying and not select query
    @Query("DELETE from Employee where salary=:minSalary")
    void deleteEmployeeWithMinimumSalary(@Param("minSalary") double minSalary);



    //Native SQLQuery

    @Query(value = "select * from employeeTable", nativeQuery = true)
    List<Employee> findAllStudentNQ();

    @Query(value = "select * from employeeTable where empLastName like '%singh'", nativeQuery = true)
    List<Employee> findAllEmployeeByLastNameNQ();

    @Modifying
    @Query(value = "delete from employeeTable where empAge>:age", nativeQuery = true)
    void DeleteEmployeeGreaterThan45NQ(@Param("age") Integer age);

}

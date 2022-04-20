package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}

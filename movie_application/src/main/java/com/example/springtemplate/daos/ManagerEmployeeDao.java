package com.example.springtemplate.daos;

import com.example.springtemplate.models.Employee;
import com.example.springtemplate.models.Manager;
import com.example.springtemplate.repositories.EmployeeRepository;
import com.example.springtemplate.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ManagerEmployeeDao {
  @Autowired
  ManagerRepository managerRepository;
  @Autowired
  EmployeeRepository employeeRepository;

  @GetMapping("girlspower/addEmployee/{employee_id}/toManager/{manager_id}")
  public Manager addEmployeeToManager(@PathVariable("employee_id") int employeeID, @PathVariable("manager_id") int managerID){
    Employee employee = employeeRepository.findById(employeeID).get();
    Manager manager = managerRepository.findById(managerID).get();
    employee.setManager(manager);
    manager.getEmployees().add(employee);
    employeeRepository.save(employee);
    return manager;
  }

  @GetMapping("/girlspower/removeEmployee/{employee_id}/fromManager/{manager_id}")
  public Manager removeEmployeeFromManager(@PathVariable("employee_id") int employeeID, @PathVariable("manager_id") int managerID){
    Employee employee = employeeRepository.findById(employeeID).get();
    Manager manager = managerRepository.findById(managerID).get();
    employee.setManager(null);
    manager.getEmployees().remove(employee);
    employeeRepository.save(employee);
    return manager;
  }
}

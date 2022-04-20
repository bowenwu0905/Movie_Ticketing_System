package com.example.springtemplate.daos;

import com.example.springtemplate.models.Employee;
import com.example.springtemplate.models.Manager;
import com.example.springtemplate.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeOrmDao {

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  ManagerEmployeeDao managerEmployeeDao;

  @PostMapping("girlspower/employees")
  public Employee createEmployee(@RequestBody Employee employee){
    employeeRepository.save(employee);
    int managerID = employee.getManager_id();
    int employeeID = employee.getPersonID();
    managerEmployeeDao.addEmployeeToManager(employeeID, managerID);
    return employeeRepository.save(employee);
  }

  @GetMapping("girlspower/employees")
  public List<Employee> findAllEmployees(){
    return (List<Employee>) employeeRepository.findAll();
  }

  @GetMapping("girlspower/employees/{employee_id}")
  public Employee findEmployeeById(@PathVariable("employee_id") int employeeID){
    return employeeRepository.findById(employeeID).get();
  }

  @PutMapping("girlspower/employees/{employee_id}")
  public Employee updateEmployee(@PathVariable("employee_id") int employeeID,
      @RequestBody Employee newEmployee){
    Employee employee = this.findEmployeeById(employeeID);
    employee.setFirstName(newEmployee.getFirstName());
    employee.setLastName(newEmployee.getLastName());
    employee.setUserName(newEmployee.getUserName());
    employee.setPassword(newEmployee.getPassword());
    employee.setEmail(newEmployee.getEmail());
    employee.setDateOfBirth(newEmployee.getDateOfBirth());
    managerEmployeeDao.removeEmployeeFromManager(employeeID, employee.getManager_id());
    employee.setManager_id(newEmployee.getManager_id());
    managerEmployeeDao.addEmployeeToManager(employeeID, employee.getManager_id());
    employee.setHourly_rate(newEmployee.getHourly_rate());
    return employeeRepository.save(employee);
  }

  @DeleteMapping("girlspower/employees/{employee_id}")
  public void deleteEmployee(@PathVariable("employee_id") int employeeID){
    Employee employee = this.findEmployeeById(employeeID);
    managerEmployeeDao.removeEmployeeFromManager(employeeID, employee.getManager_id());
    employeeRepository.deleteById(employeeID);
  }
}

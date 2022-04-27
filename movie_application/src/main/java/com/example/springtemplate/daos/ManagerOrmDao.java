package com.example.springtemplate.daos;

import com.example.springtemplate.models.Audience;
import com.example.springtemplate.models.Employee;
import com.example.springtemplate.models.Manager;
import com.example.springtemplate.models.Theater;
import com.example.springtemplate.models.Ticket;
import com.example.springtemplate.repositories.ManagerRepository;
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
public class ManagerOrmDao {
  @Autowired
  ManagerRepository managerRepository;

  @Autowired
  ManagerEmployeeDao managerEmployeeDao;

  @Autowired
  ManagerTheaterDao managerTheaterDao;

  @PostMapping("girlspower/managers")
  public Manager createManager(@RequestBody Manager manager){
    return managerRepository.save(manager);
  }

  @GetMapping("/girlspower/managers")
  public List<Manager> findAllManagers(){
    return (List<Manager>)managerRepository.findAll();
  }

  @GetMapping("girlspower/managers/{manager_id}")
  public Manager findManagerById(@PathVariable("manager_id") int managerID){
    return managerRepository.findById(managerID).get();
  }

  @PutMapping("girlspower/managers/{managerId}")
  public Manager updateManager(@PathVariable("managerId") int managerID,
      @RequestBody Manager newManager){
    Manager manager = this.findManagerById(managerID);
    manager.setFirstName(newManager.getFirstName());
    manager.setLastName(newManager.getLastName());
    manager.setUserName(newManager.getUserName());
    manager.setPassword(newManager.getPassword());
    manager.setEmail(newManager.getEmail());
    manager.setDateOfBirth(newManager.getDateOfBirth());
    manager.setLevel(newManager.getLevel());
    manager.setSalary(newManager.getSalary());
    manager.setDate_joined((newManager.getDate_joined()));
    return managerRepository.save(manager);
  }

  @DeleteMapping("/girlspower/managers/{managerId}")
  public void deleteManager(@PathVariable("managerId") int managerID){
    Manager manager = this.findManagerById(managerID);
    List<Employee> employees = manager.getEmployees();
    List<Theater> theaters = manager.getTheaters();
    for(Employee employee : employees){
      employee.setManager(null);
    }
    for(Theater theater : theaters){
      theater.setManager(null);
    }
    managerRepository.delete(manager);
  }
}

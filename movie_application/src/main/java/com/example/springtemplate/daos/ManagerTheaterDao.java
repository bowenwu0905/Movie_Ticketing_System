package com.example.springtemplate.daos;

import com.example.springtemplate.models.Employee;
import com.example.springtemplate.models.Manager;
import com.example.springtemplate.models.Theater;
import com.example.springtemplate.repositories.EmployeeRepository;
import com.example.springtemplate.repositories.ManagerRepository;
import com.example.springtemplate.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ManagerTheaterDao {
  @Autowired
  ManagerRepository managerRepository;
  @Autowired
  TheaterRepository theaterRepository;

  @GetMapping("girlspower/addTheater/{theater_id}/toManager/{manager_id}")
  public Manager addTheaterToManager(@PathVariable("theater_id") int theaterID, @PathVariable("manager_id") int managerID){
    Theater theater = theaterRepository.findById(theaterID).get();
    Manager manager = managerRepository.findById(managerID).get();
    theater.setManager(manager);
    manager.getTheaters().add(theater);
    theaterRepository.save(theater);
    return manager;
  }

  @GetMapping("/girlspower/removeTheater/{theater_id}/fromManager/{manager_id}")
  public Manager removeTheaterFromManager(@PathVariable("theater_id") int theaterID, @PathVariable("manager_id") int managerID){
    Theater theater = theaterRepository.findById(theaterID).get();
    Manager manager = managerRepository.findById(managerID).get();
    theater.setManager(null);
    manager.getTheaters().remove(theater);
    theaterRepository.save(theater);
    return manager;
  }

}

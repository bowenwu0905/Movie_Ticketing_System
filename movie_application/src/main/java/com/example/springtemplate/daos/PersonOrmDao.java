package com.example.springtemplate.daos;

import com.example.springtemplate.models.Person;
import com.example.springtemplate.repositories.PersonRepository;
import java.sql.Date;
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
public class PersonOrmDao {
  @Autowired
  PersonRepository personRepository;

  @PostMapping("/girlspower/create/person")
  public Person createPerson(@RequestBody Person person){
    return personRepository.save(person);
  }

  @GetMapping("/girlspower/persons")
  public List<Person> findAllPersons(){
    return (List<Person>) personRepository.findAll();
  }


  @GetMapping("/girlspower/persons/{person_id}")
  public Person findPersonById(@PathVariable("person_id") int personID){
    return personRepository.findById(personID).get();
  }

  @PutMapping("girlspower/persons/{person_id}")
  public void updatePerson(@PathVariable("person_id") int personID, @RequestBody Person newPerson){
    Person person = this.findPersonById(personID);
    person.setFirstName(newPerson.getFirstName());
    person.setLastName(newPerson.getLastName());
    person.setUserName(newPerson.getUserName());
    person.setPassword(newPerson.getPassword());
    person.setEmail(newPerson.getEmail());
    person.setDateOfBirth(newPerson.getDateOfBirth());
    personRepository.save(person);
  }

  @DeleteMapping("/girlspower/person/{person_id}")
  public void deletePerson(@PathVariable("person_id") int personID){
    personRepository.deleteById(personID);
  }
}

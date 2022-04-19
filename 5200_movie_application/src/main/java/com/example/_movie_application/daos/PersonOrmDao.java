package com.example._movie_application.daos;

import com.example._movie_application.Repositories.PersonRepository;
import com.example._movie_application.models.Person;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonOrmDao {
  @Autowired
  PersonRepository personRepository;

  public Person createPerson(int personID, String firstName, String lastName, String userName,
      String password, String email, Date dateOfBirth){
    Person person = new Person(personID, firstName, lastName, userName, password, email, dateOfBirth);
    return personRepository.save(person);
  }

  public List<Person> findAllPersons(){
    return (List<Person>) personRepository.findAll();
  }

  public Person findPersonById(int personID){
    return personRepository.findById(personID).get();
  }

  public void updatePerson(int personID, String firstName, String lastName, String userName,
      String password, String email, Date dateOfBirth){
    Person person = this.findPersonById(personID);
    person.setFirstName(firstName);
    person.setLastName(lastName);
    person.setUserName(userName);
    person.setPassword(password);
    person.setEmail(email);
    person.setDateOfBirth(dateOfBirth);
    personRepository.save(person);
  }

  public void deletePerson(int personID){
    personRepository.deleteById(personID);
  }
}

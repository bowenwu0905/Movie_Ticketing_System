package daos;

import Repositories.PersonRepository;
import java.sql.Date;
import java.util.List;
import models.Person;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonOrmDao {
  @Autowired
  PersonRepository personRepository;

  public Person createPerson(int personID, String firstName, String lastName, String userName,
      String password, String email, Date dateOfBirth){
    Person person = new Person(personID, firstName, lastName, userName, password, email, dateOfBirth);
    return personRepository.save(person);
  }

  public List<Person> findAllPersons(){
    return personRepository.findAllPersons();
  }

  public Person findPersonById(int personID){
    return personRepository.findPersonById(personID);
  }

  public void updatePerson(int personID, String firstName, String lastName, String userName,
      String password, String email, Date dateOfBirth){
    Person person = personRepository.findPersonById(personID);
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

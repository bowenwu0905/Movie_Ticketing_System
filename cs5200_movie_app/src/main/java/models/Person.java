package models;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="persons")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int personID;
  protected String firstName;
  protected String lastName;
  protected String userName;
  protected String password;
  protected String email;
  protected Date dateOfBirth;

  public Person(int personID) {
    this.personID = personID;
  }

  public Person() {
  }

  public Person(int personID, String firstName, String lastName, String userName,
      String password, String email, Date dateOfBirth) {
    this.personID = personID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  public int getPersonID() {
    return personID;
  }

  public void setPersonID(int personID) {
    this.personID = personID;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}

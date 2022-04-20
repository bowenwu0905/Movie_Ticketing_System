package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name="managers")
public class Manager extends Person{
  protected int level;
  protected int salary;
  @JsonFormat(pattern = "yyyy-MM-dd")
  protected Date date_joined;

  @OneToMany(mappedBy = "manager")
  protected List<Employee> employees;

  @OneToMany(mappedBy = "manager")
  protected List<Theater> theaters;

  public List<Theater> getTheaters() {
    return theaters;
  }

  public void setTheaters(List<Theater> theaters) {
    this.theaters = theaters;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public Date getDate_joined() {
    return date_joined;
  }

  public void setDate_joined(Date date_joined) {
    this.date_joined = date_joined;
  }
}

package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name="employees")
public class Employee extends Person{

  protected int manager_id;
  protected int hourly_rate;

  @ManyToOne
  @JsonIgnore
  protected Manager manager;

  public int getManager_id() {
    return manager_id;
  }

  public void setManager_id(int manager_id) {
    this.manager_id = manager_id;
  }

  public int getHourly_rate() {
    return hourly_rate;
  }

  public void setHourly_rate(int hourly_rate) {
    this.hourly_rate = hourly_rate;
  }

  public Manager getManager() {
    return manager;
  }

  public void setManager(Manager manager) {
    this.manager = manager;
  }
}

package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="theaters")
public class Theater {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer theater_id;
  private Integer manager_id;
  private String theater_name;
  private String address;
  private Integer capacity;

  @OneToMany(mappedBy = "theater")
  private List<Section> sections;

  @ManyToOne
  @JsonIgnore
  private Manager manager;

  public Manager getManager() {
    return manager;
  }

  public void setManager(Manager manager) {
    this.manager = manager;
  }

  public Integer getTheater_id() {
    return theater_id;
  }

  public void setTheater_id(Integer theater_id) {
    this.theater_id = theater_id;
  }

  public Integer getManager_id() {
    return manager_id;
  }

  public void setManager_id(Integer manager_id) {
    this.manager_id = manager_id;
  }

  public String getTheater_name() {
    return theater_name;
  }

  public void setTheater_name(String theater_name) {
    this.theater_name = theater_name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public List<Section> getSections() {
    return sections;
  }

  public void setSections(List<Section> sections) {
    this.sections = sections;
  }
}

package com.example._movie_application.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="theaters")
public class Theater {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer theater_id;
  private Integer manager_id;
  private String name;
  private String address;
  private Integer capacity;

  @OneToMany(mappedBy = "theater")
  @JsonIgnore
  private List<Section> sections;

  public List<Section> getSections() {
    return sections;
  }

  public void setSections(List<Section> sections) {
    this.sections = sections;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
}

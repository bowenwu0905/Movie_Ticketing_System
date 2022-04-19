package com.example._movie_application.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int movie_id;
  private String movie_name;
  @Enumerated(EnumType.STRING)
  private Type movie_type;

  @OneToMany(mappedBy = "movie")
  @JsonIgnore
  private List<Section> sections;

  public List<Section> getSections() {
    return sections;
  }

  public void setSections(List<Section> sections) {
    this.sections = sections;
  }

  public int getMovie_id() {
    return movie_id;
  }

  public void setMovie_id(int movie_id) {
    this.movie_id = movie_id;
  }

  public String getMovie_name() {
    return movie_name;
  }

  public void setMovie_name(String movie_name) {
    this.movie_name = movie_name;
  }

  public Type getType() {
    return movie_type;
  }

  public void setType(Type type) {
    this.movie_type = type;
  }

}

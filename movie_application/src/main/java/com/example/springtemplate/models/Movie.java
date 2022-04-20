package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
  private Movie_type movie_type;

  @OneToMany(mappedBy = "movie")
  private List<Section> sections;

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

  public Movie_type getMovie_type() {
    return movie_type;
  }

  public void setMovie_type(Movie_type movie_type) {
    this.movie_type = movie_type;
  }

  public List<Section> getSections() {
    return sections;
  }

  public void setSections(List<Section> sections) {
    this.sections = sections;
  }
}

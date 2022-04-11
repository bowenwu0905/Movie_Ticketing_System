package models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import models.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Movies")
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int movie_id;
  private String movie_name;
  private Type type;

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
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

}

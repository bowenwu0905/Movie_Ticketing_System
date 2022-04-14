package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.Calendar;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="Sections")
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer section_id;
  private Integer movie_id;
  private Integer theater_id;
  private Timestamp showtime;
  private Integer room_number;

  @ManyToOne
  @JsonIgnore
  private Movie movie;

  @ManyToOne
  @JsonIgnore
  private Theater theater;

  @OneToMany(mappedBy = "section")
  @JsonIgnore
  private Ticket ticket;

  public Theater getTheater() {
    return theater;
  }

  public void setTheater(Theater theater) {
    this.theater = theater;
  }

  public Integer getSection_id() {
    return section_id;
  }

  public void setSection_id(Integer section_id) {
    this.section_id = section_id;
  }

  public Integer getMovie_id() {
    return movie_id;
  }

  public void setMovie_id(Integer movie_id) {
    this.movie_id = movie_id;
  }

  public Integer getTheater_id() {
    return theater_id;
  }

  public void setTheater_id(Integer theater_id) {
    this.theater_id = theater_id;
  }

  public Timestamp getShowtime() {
    return showtime;
  }

  public void setShowtime(Timestamp showtime) {
    this.showtime = showtime;
  }

  public Integer getRoom_number() {
    return room_number;
  }

  public void setRoom_number(Integer room_number) {
    this.room_number = room_number;
  }

}

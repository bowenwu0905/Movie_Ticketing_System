package com.example.springtemplate.models;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sections")
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer section_id;
  private Integer movie_id;
  private Integer theater_id;
  private Timestamp showtime;
  private Integer room_number;

  public Section(Integer section_id, Integer movie_id, Integer theater_id,
      Timestamp showtime, Integer room_number) {
    this.section_id = section_id;
    this.movie_id = movie_id;
    this.theater_id = theater_id;
    this.showtime = showtime;
    this.room_number = room_number;
  }

  public Section() {
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

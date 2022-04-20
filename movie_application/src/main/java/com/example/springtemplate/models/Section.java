package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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



  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  @ManyToOne
  @JsonIgnore
  private Movie movie;

  @ManyToOne
  @JsonIgnore
  private Theater theater;

  @OneToMany(mappedBy = "section")
  @JsonIgnore
  private List<Ticket> tickets;

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

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

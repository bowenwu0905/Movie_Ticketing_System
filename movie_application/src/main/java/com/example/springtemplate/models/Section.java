package com.example.springtemplate.models;

import com.example.springtemplate.models.Movie;
import com.example.springtemplate.models.Theater;
import com.example.springtemplate.models.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.*;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="sections")
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer section_id;
  private Integer movie_id;
  private Integer theater_id;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Timestamp show_time;
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
  private List<Ticket> tickets;

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

  public Timestamp getShow_time() {
    return show_time;
  }

  public void setShow_time(Timestamp show_time) {
    this.show_time = show_time;
  }

  public Integer getRoom_number() {
    return room_number;
  }

  public void setRoom_number(Integer room_number) {
    this.room_number = room_number;
  }

  public Theater getTheater() {
    return theater;
  }

  public void setTheater(Theater theater) {
    this.theater = theater;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}


package com.example._movie_application.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name="audiences")
public class Audience extends Person{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "audience_id")
  protected int audienceID;
  @Column(name = "card_number")
  protected int cardNumber;
  protected int points;

  @OneToMany(mappedBy = "audience")
  protected List<Ticket> tickets;

//  public Audience(int personID, int audienceID, int cardNumber, int points) {
//    super(personID);
//    this.audienceID = audienceID;
//    this.cardNumber = cardNumber;
//    this.points = points;
//    this.tickets = new ArrayList<>();
//  }

  public Audience(int personID, String firstName, String lastName, String userName,
      String password, String email, Date dateOfBirth, int audienceID, int cardNumber, int points) {
    super(personID, firstName, lastName, userName, password, email, dateOfBirth);
    this.audienceID = audienceID;
    this.cardNumber = cardNumber;
    this.points = points;
    this.tickets = new ArrayList<>();
  }

  public Audience() {

  }

  public int getAudienceID() {
    return audienceID;
  }

  public void setAudienceID(int audienceID) {
    this.audienceID = audienceID;
  }

  public int getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(int cardNumber) {
    this.cardNumber = cardNumber;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}

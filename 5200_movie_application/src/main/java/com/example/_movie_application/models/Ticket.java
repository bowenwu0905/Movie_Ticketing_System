package com.example._movie_application.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ticket_id")
  protected int ticketID;
  @ManyToOne
  @JsonIgnore
  protected Section section;
  @ManyToOne
  @JsonIgnore
  protected Audience audience;
  protected double price;
  protected boolean refundable;

  public Ticket() {
  }

  public Ticket(int ticketID, double price, boolean refundable) {
    this.ticketID = ticketID;
    this.section = null;
    this.audience = null;
    this.price = price;
    this.refundable = refundable;
  }

  public int getTicketID() {
    return ticketID;
  }

  public void setTicketID(int ticketID) {
    this.ticketID = ticketID;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  public Audience getAudience() {
    return audience;
  }

  public void setAudience(Audience audience) {
    this.audience = audience;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isRefundable() {
    return refundable;
  }

  public void setRefundable(boolean refundable) {
    this.refundable = refundable;
  }
}

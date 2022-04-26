package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ticket_id")
  protected int ticketID;
  @Column(name = "section_id")
  protected int sectionID;
  @Column(name = "audience_id", nullable = true)
  protected Integer audienceID;
  protected double price;
  protected boolean refundable;
  @ManyToOne
  @JsonIgnore
  protected Section section;
  @ManyToOne
  @JsonIgnore
  protected Audience audience;

  public int getTicketID() {
    return ticketID;
  }

  public void setTicketID(int ticketID) {
    this.ticketID = ticketID;
  }

  public int getSectionID() {
    return sectionID;
  }

  public void setSectionID(Integer sectionID) {
    this.sectionID = sectionID;
  }

  public int getAudienceID() {
    return audienceID;
  }

  public void setAudienceID(int audienceID) {
    this.audienceID = audienceID;
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

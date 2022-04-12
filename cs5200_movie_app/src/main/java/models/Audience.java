package models;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="audiences")
public class Audience extends Person{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int audienceID;
  protected int cardNumber;
  protected int points;

  @OneToMany(mappedBy = "audience")
  protected List<Ticket> tickets;

  public Audience() {
  }

  public Audience(int personID) {
    super(personID);
  }

  public Audience(int personID, String firstName, String lastName, String userName,
      String password, String email, Date dateOfBirth, int audienceID, int cardNumber,
      int points) {
    super(personID, firstName, lastName, userName, password, email, dateOfBirth);
    this.audienceID = audienceID;
    this.cardNumber = cardNumber;
    this.points = points;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
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
}

package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Type")
public enum Type {
  Romance,
  Comedy,
  Thriller,
  Documentary,
  Drama;

  @Id
  @Column(name = "id")
  private Long id;

  public Long getId() {
    return id;
  }
}

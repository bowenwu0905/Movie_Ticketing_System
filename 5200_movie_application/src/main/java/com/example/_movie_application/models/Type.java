package com.example._movie_application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public enum Type {
  Romance,
  Comedy,
  Thriller,
  Documentary,
  Drama;
}

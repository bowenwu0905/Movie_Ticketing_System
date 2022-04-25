CREATE SCHEMA IF NOT EXISTS movie_application;
USE movie_application;

DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS sections;
DROP TABLE IF EXISTS theaters;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS theaters;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS managers;
DROP TABLE IF EXISTS audiences;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS movie_types;

CREATE TABLE persons (
  person_id INT AUTO_INCREMENT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  user_name VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  date_of_birth Date,
  CONSTRAINT pk_persons_id PRIMARY KEY (person_id)
);

insert into persons(first_name, last_name, user_name, password, email, date_of_birth)
values("Yibo", "Wang", "wyb", "0805", "wyb@gmail.com", "19970805"),
("Zhan", "Xiao", "xz", "1005", "xz@gmail.com", "19911005"),
("kk", "wu", "kkw", "0826", "wbw@gmail.com", "19980826"),
("mj", "chen", "cmj", "0209", "cmj@gmail.com", "20000209");

insert into persons(first_name, last_name, user_name, password, email, date_of_birth)
values("ran", "quan", "qr", "1025", "qr@gmail.com", "19931025"),
("a", "b", "c", "d", "e@gmail.com", "20000101"),
("t", "e", "s", "t", "test@gmail.com", "20000101");



CREATE TABLE managers (
  person_id INT,
  level INT,
  salary INT,
  date_joined Date,
  CONSTRAINT pk_managers_person_id
    PRIMARY KEY (person_id),
  CONSTRAINT fk_managers_person_id
    FOREIGN KEY (person_id)
    REFERENCES persons(person_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

insert into managers(person_id, level, salary, date_joined)
values(1, 5, 3000, 20000809);

CREATE TABLE employees (
  person_id INT,
  manager_id INT,
  hourly_rate INT,
  CONSTRAINT pk_employees_person_id
    PRIMARY KEY (person_id),
  CONSTRAINT fk_employees_person_id
    FOREIGN KEY (person_id)
    REFERENCES persons(person_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_employees_manager_id
    FOREIGN KEY (manager_id)
    REFERENCES managers(person_id)
    ON UPDATE CASCADE ON DELETE SET NULL
);

insert into employees (person_id, manager_id, hourly_rate)
values(2, 1, 20),
(3, 1, 21);

CREATE TABLE audiences (
  person_id INT,
  card_number INT,
  points INT,
  CONSTRAINT pk_audiences_person_id
    PRIMARY KEY (person_id),
  CONSTRAINT fk_audiences_person_id
    FOREIGN KEY (person_id)
    REFERENCES persons(person_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

insert into audiences (person_id, card_number, points)
values(4, 123, 20),
(5, 456, 21),
(6, 789, 100);

CREATE TABLE theaters (
  theater_id INT AUTO_INCREMENT,
  manager_id INT,
  theater_name VARCHAR(255),
  address VARCHAR(255),
  capacity INT,
  CONSTRAINT pk_theaters_theater_id PRIMARY KEY (theater_id),
  CONSTRAINT fk_theaters_manager_id
    FOREIGN KEY (manager_id)
    REFERENCES managers(person_id)
    ON UPDATE CASCADE ON DELETE SET NULL
);

insert into theaters(manager_id, theater_name, address, capacity)
values(1, "bjyx", "111 Avenue", 2000),
(1, "abcd", "222 Avenue", 3000);

CREATE TABLE movie_types (
movie_type VARCHAR(25) NOT NULL,
CONSTRAINT pk_movie_types_movie_type
    PRIMARY KEY (movie_type)
);

INSERT INTO movie_types (movie_type) VALUES('ROMANCE');
INSERT INTO movie_types (movie_type) VALUES('COMEDY');
INSERT INTO movie_types (movie_type) VALUES('THRILLER');
INSERT INTO movie_types (movie_type) VALUES('DOCUMENTARY');
INSERT INTO movie_types (movie_type) VALUES('DRAMA');

CREATE TABLE movies (
  movie_id INT AUTO_INCREMENT,
  movie_name VARCHAR(255) NOT NULL,
  movie_type VARCHAR(25),
  CONSTRAINT pk_movies_movie_id PRIMARY KEY (movie_id),
  CONSTRAINT fk_movies_movie_type
    FOREIGN KEY (movie_type)
    REFERENCES movie_types(movie_type)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

insert into movies(movie_id, movie_name, movie_type)
values(1, "cql", 'ROMANCE'),
(2, "ys", 'THRILLER'),
(3, "abc", 'DOCUMENTARY'),
(4, "cde", 'COMEDY'),
(5, "fgh", 'DRAMA');



CREATE TABLE sections (
  section_id INT AUTO_INCREMENT,
  movie_id INT,
  theater_id INT,
  show_time TIMESTAMP,
  room_number INT,
  CONSTRAINT pk_sections_section_id
    PRIMARY KEY (section_id),
  CONSTRAINT fk_sections_movie_id
    FOREIGN KEY (movie_id)
    REFERENCES movies(movie_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_sections_theater_id FOREIGN KEY (theater_id)
    REFERENCES theaters(theater_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);


insert into sections(movie_id, theater_id, show_time, room_number)
values(1, 1, "2021-01-01 00:00:01", 1823),
(2, 1, "2021-01-01 00:00:01", 1824),
(3, 2, "2021-01-01 00:00:01", 1823),
(4, 2, "2021-01-01 00:00:01", 1824),
(5, 2, "2021-01-01 00:00:01", 1825);


CREATE TABLE tickets (
  ticket_id INT AUTO_INCREMENT,
  price DOUBLE,
  section_id INT,
  audience_id INT,
  refundable BOOL,
  CONSTRAINT pk_tickets_ticket_id
    PRIMARY KEY (ticket_id),
  CONSTRAINT fk_tickets_section_id
    FOREIGN KEY (section_id)
    REFERENCES sections(section_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_tickets_audience_id FOREIGN KEY (audience_id)
    REFERENCES audiences(person_id)
	ON UPDATE CASCADE ON DELETE SET NULL
    );
    
insert into tickets(price, section_id, audience_id, refundable)
values(20, 1, 4, true),
(15, 2, 4, true),
(15, 3, 5, true),
(15, 4, 6, true),
(15, 5, 6, true);
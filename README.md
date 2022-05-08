## project_name: 
Movie_app

## problem_statement
This project creates a database for a theater ticketing system that records information about theaters, movies, tickets, etc., and the relationships among them. It is comprised of 4 domain objects, 3 end-users that inherit from people objects, and one enum object.
The aim of the project is to build a movie ticket booking system for users. So that the audience could book tickets from the app, managers, and employees could create/review/edit/delete all movies. A manager manages multiple employees and an employee only has one manager.

## solution_statement
The solution we implemented to solve the problem is to use React.js as the frontend tool.
JPA and Spring for the server-side, we applied DAO to encapsulate the details of the persistence layer and provide a CRUD interface for a single entity.
MySQL is our tool to manage the database.

## user_data_models_description:
There are 3 human end users: **audience, manager and employee**.
The audience can search for and review all the theaters and movies, choose a section associated with a theater, a movie, a showTime, and roomNumber and buy a ticket for that section, and can also choose to review/edit/cancel the tickets they have bought.
Managers and employees can review/edit all theaters, and create/review/edit/delete all movies, all sections, and all tickets.

## user_to_user_object_relationship decsription:
There are 3 human end users: **audience, manager and employee**, and they all inherits from people object. manager and employment has one-to-many relationship, a manager manages multiple employees and an employee only has one manager.

## user_to_domain_object_relationship decsription:
There are 2 relationships between end users and domain objects. **audience to ticket** and **manager to theater**. The relationship between audience and ticket is one-to-many, an audience can buy a lot of tickets but a ticket is only related to one audience. The relationship between manager and theater is also one-to-many, one manager can manage multiple theaters and one theater can only be managed by one manager.

## domain_object_to_domain_object_relationship decsription:
In this project, there are 4 domain objets: **theater, section, movie and ticket**. There are multiple relationships among domain objects. For theater and movie, they are many-to-many relationship and is combined by section. In each section, is uses theater_id and movie_id as foreign key, so it is one-to-many relationship to movie and theater. Section and ticket is one-to-many relationship, each section is related to multiple tickets.

## enumeration_description:
there is one enum in this project: **Type**, which refers to the movie types, including **drama, romance, thriller, comedy, documentary**.

## user_interface_requirements:
**For audiences:**
- Theater List: displays all the theaters and their info.
- Movie List: displays all the movies that are **currently online**.
- My Ticket List: displays all the **ticket history of this audience**.
- Ticket Editor: display the **current ticket**, and options to **cancel, change** this ticket.

**For managers:**
- Theater List: displays all the theaters and their info.
- Theater Editor: displays all the theaters and their info and options to add, delete and edit theaters.
- Movie List: displays all the **movies including history**.
- Movie Editor: displays all the **movies including history** and options to add, delete and edit movies.
- Section List: displays all the section info.
- Section Editor: displays all the section info and options to add, delete and edit section info like showtime, rooms etc.
- Ticket List: displays all the **ticket history**.
- Ticket Editor: display the **current tickets**, and options to **add, cancel, change** tickets.

**For employees:**
- Section List: displays all the theaters and their info.
- Section Editor: displays all the section info and options to add, delete and edit section info like showtime, rooms etc.
- Ticket List: displays all the **ticket history**.
- Ticket Editor: display the **current tickets**, and options to **add, cancel, change** tickets.

## instructions:

**API Docs**
API Docs can be found here: https://docs.google.com/document/d/1JSG1NxHEDDasLTgxNwou5Y-4Szg7bAmiJfF7S8qxLiQ/edit?usp=sharing

**For frontend**
cd to the frontend folder, then run **npm start**, the client could be found in http://localhost:3000/
for the frontend we only implement some of the audience's usecases. (The audienceID we use here is 4, if it does not work, please try other audienceID. the code should be in Sections.js and Top.js) the APIs that have been called in the client are:
- findAllMovies()
- findSectionsByMovieId()
- createTicket()

**For server**
download the MovieApp-CreateTables.sql file and execute it, make sure the movieApp schema is present.
cd to the movie_application folder, find resources/application.properties, edit the datasourse url, username and password.
then click on start DemoApplication, the server is running on http://localhost:8080/
All other tests in the API doc could be done using **postman**

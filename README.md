# project-SP22-bowenwu0826-liqingzhao-yihan
project-SP22-bowenwu0826-liqingzhao-yihan


## project_name: 
Movie_app

## team_name:
Girl's power

## team_members:
- Qingzhao Li
- Bowen Wu
- Yihan Xu

## project_description:
This project creates a database for theater ticketing system that records information about theaters, movies, tickets etc. and the relationships among them. It is comprised of 4 domain objects, and 3 end users that inherits from people object and one enum object.

## user_data_models_description:
In this project, there are 3 human end users: **audience, manager and employee**, and they all inherits from people object. manager and employment has one to manager relationship, a manager manages multiple employees and an employee only has one manager.

## domain_object_data_models_description:
In this project, there are 4 domain objets: **theater, section, movie and ticket**.

## user_to_domain_object_relationship decsription:
There are 2 relationships between end users and domain objects. **audience to ticket** and **manager to theater**. The relationship between audience and ticket is one-to-many, an audience can buy a lot of tickets but a ticket is only related to one audience. The relationship between manager and theater is also one-to-many, one manager can manage multiple theaters and one theater can only be managed by one manager.

## domain_object_to_domain_object_relationship decsription:
there are multiple relationships among domain objects. For theater and movie, they are many-to-many relationship and is combined by section. In each section, is uses theater_id and movie_id as foreign key, so it is one-to-many relationship to movie and theater. Section and ticket is one-to-one relationship, each section is related to a ticket and each ticket is related to a section.

## enumeration_description:
there is one enum in this project: Type, which refers to the movie types, including **drama, romance, thriller, comedy, documentary**.

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

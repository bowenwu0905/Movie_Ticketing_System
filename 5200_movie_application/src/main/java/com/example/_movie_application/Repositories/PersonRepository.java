package com.example._movie_application.Repositories;
import com.example._movie_application.models.Person;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends CrudRepository<Person, Integer> {

}

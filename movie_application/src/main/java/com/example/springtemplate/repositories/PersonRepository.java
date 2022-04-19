package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}

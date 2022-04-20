package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository  extends CrudRepository<Theater, Integer> {


}

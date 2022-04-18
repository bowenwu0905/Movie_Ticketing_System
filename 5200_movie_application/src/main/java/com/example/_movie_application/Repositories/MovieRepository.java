package com.example._movie_application.Repositories;

import com.example._movie_application.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer>{

}

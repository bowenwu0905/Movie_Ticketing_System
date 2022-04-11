package Repositories;

import models.Movie;
import models.Theater;
import org.springframework.data.repository.CrudRepository;

public interface TheaterRepository  extends CrudRepository<Theater, Integer> {

}


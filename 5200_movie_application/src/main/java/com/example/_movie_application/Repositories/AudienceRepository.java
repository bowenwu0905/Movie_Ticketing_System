package com.example._movie_application.Repositories;

import com.example._movie_application.models.Audience;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AudienceRepository extends CrudRepository<Audience, Integer> {

}

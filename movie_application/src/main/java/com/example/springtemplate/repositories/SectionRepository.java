package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Section;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SectionRepository extends CrudRepository<Section, Integer> {

  @Query(value = "SELECT * FROM sections WHERE theater_id = :id", nativeQuery = true)
  public List<Section> getSectionsByTheater_id(@Param("id") Integer id);
}

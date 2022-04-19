package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Section;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<Section, Integer> {

  @Query(value = "SELECT * FROM sections",
      nativeQuery = true)
  public List<Section> findAllSections();
}

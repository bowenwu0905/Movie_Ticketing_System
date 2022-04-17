package Repositories;

import java.util.List;
import models.Section;
import models.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface SectionRepository extends CrudRepository<Section, Integer>{

  @Query(value = "SELECT * FROM sections WHERE theater_id = :id", nativeQuery = true)
  public List<Section> getSectionsByTheater_id(@Param("id") Integer id);



}

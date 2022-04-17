package final_proj.Repositories;

import java.util.List;
import final_proj.models.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SectionRepository extends CrudRepository<Section, Integer>{

  @Query(value = "SELECT * FROM sections WHERE theater_id = :id", nativeQuery = true)
  public List<Section> getSectionsByTheater_id(@Param("id") Integer id);



}

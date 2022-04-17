package final_proj.Repositories;

import java.util.List;
import final_proj.models.Audience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AudienceRepository extends CrudRepository<Audience, Integer> {
  @Query(value = "SELECT * FROM audiences", nativeQuery = true)
  public List<Audience> findAllAudiences();

  @Query(value = "SELECT * FROM audiences WHERE audience_id = :id", nativeQuery = true)
  public Audience findAudienceById(@Param("id") Integer id);
}
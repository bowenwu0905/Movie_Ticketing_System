package final_proj.Repositories;

import java.util.List;
import final_proj.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  @Query(value = "SELECT * FROM persons", nativeQuery = true)
  public List<Person> findAllPersons();

  @Query(value = "SELECT * FROM persons WHERE person_id = :id", nativeQuery = true)
  public Person findPersonById(@Param("id") Integer id);
}

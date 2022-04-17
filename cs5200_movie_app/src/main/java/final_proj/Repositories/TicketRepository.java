package final_proj.Repositories;

import java.util.List;
import final_proj.models.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
  @Query(value = "SELECT * FROM tickets", nativeQuery = true)
  public List<Ticket> findAllTickets();

  @Query(value = "SELECT * FROM tickets WHERE ticket_id = :id", nativeQuery = true)
  public Ticket findTicketByTicketId(@Param("id") Integer id);

  @Query(value = "SELECT * FROM tickets WHERE section_id = :id", nativeQuery = true)
  public List<Ticket> findTicketsBySectionId(@Param("id") Integer id);

  @Query(value = "SELECT * FROM tickets WHERE audience_id = :id", nativeQuery = true)
  public List<Ticket> findTicketsByAudienceId(@Param("id") Integer id);
}

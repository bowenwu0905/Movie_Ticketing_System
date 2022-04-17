package daos;

import Repositories.AudienceRepository;
import Repositories.TicketRepository;
import models.Audience;
import models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AudienceTicketDao {
  @Autowired
  AudienceRepository audienceRepository;
  TicketRepository ticketRepository;

  @GetMapping("/girlspower/addTicket/{ticket_id}/toAudience/{audience_id}")
  public Audience addTicketToAudience(@PathVariable("ticket_id") int ticketID,
      @PathVariable("audience_id") int audienceID){
    Ticket ticket = ticketRepository.findTicketByTicketId(ticketID);
    Audience audience = audienceRepository.findAudienceById(audienceID);
    ticket.setAudience(audience);
    audience.getTickets().add(ticket);
    ticketRepository.save(ticket);
    return audience;
  }

  @GetMapping("/girlspower/removeTicket/{ticket_id}/fromAudience/{audience_id}")
  public Audience removeTicketFromAudience(@PathVariable("ticket_id") int ticketID,
      @PathVariable("audience_id") int audienceID){
    Ticket ticket = ticketRepository.findTicketByTicketId(ticketID);
    Audience audience = audienceRepository.findAudienceById(audienceID);
    ticket.setAudience(null);
    audience.getTickets().remove(ticket);
    ticketRepository.save(ticket);
    return audience;
  }

}

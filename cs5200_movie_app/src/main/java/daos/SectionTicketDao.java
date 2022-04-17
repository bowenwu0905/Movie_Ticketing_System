package daos;

import Repositories.SectionRepository;
import Repositories.TicketRepository;
import models.Section;
import models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionTicketDao {

  @Autowired
  SectionRepository sectionRepository;
  TicketRepository ticketRepository;

  @GetMapping("/girlspower/addTicket/{ticket_id}/toSection/{section_id}")
  public Section addTicketToSection(@PathVariable("ticket_id") int ticketID,
      @PathVariable("section_id") int sectionID){
    Ticket ticket = ticketRepository.findTicketByTicketId(ticketID);
    Section section = sectionRepository.findById(sectionID).get();
    ticket.setSection(section);
    section.getTickets().add(ticket);
    ticketRepository.save(ticket);
    return section;
  }

  @GetMapping("/girlspower/removeTicket/{ticket_id}/fromSection/{section_id}")
  public Section removeTicketFromSection(@PathVariable("ticket_id") int ticketID,
      @PathVariable("section_id") int sectionID){
    Ticket ticket = ticketRepository.findTicketByTicketId(ticketID);
    Section section = sectionRepository.findById(sectionID).get();
    ticket.setSection(null);
    section.getTickets().remove(ticket);
    ticketRepository.save(ticket);
    return section;
  }

}

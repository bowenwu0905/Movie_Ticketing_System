package com.example._movie_application.daos;

import com.example._movie_application.Repositories.TicketRepository;
import java.util.List;
import com.example._movie_application.models.Audience;
import com.example._movie_application.models.Section;
import com.example._movie_application.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketOrmDao {
  TicketRepository ticketRepository;
  AudienceTicketDao audienceTicketDao;
  SectionTicketDao sectionTicketDao;

  @PostMapping("/girlspower/tickets/{section_id}/{audience_id}")
  public Ticket createTicket(@PathVariable("section_id") int sectionID,
      @PathVariable("audience_id") int audienceID,
      @RequestBody Ticket ticket){
    ticketRepository.save(ticket);
    int ticketID = ticket.getTicketID();
    audienceTicketDao.addTicketToAudience(ticketID, audienceID);
    sectionTicketDao.addTicketToSection(ticketID, sectionID);
    return ticketRepository.save(ticket);
  }

  @GetMapping("/girlspower/tickets")
  public List<Ticket> findAllTickets(){
    return ticketRepository.findAllTickets();
  }

  @GetMapping("/girlspower/tickets/{ticketId}")
  public Ticket findTicketByTicketId(@PathVariable("ticketId") int ticketID){
    return ticketRepository.findTicketByTicketId(ticketID);
  }

  @GetMapping("/girlspower/ticketsByAudience/{audienceId}")
  public List<Ticket> findTicketsByAudienceId(@PathVariable("audienceId") int audienceID){
    return ticketRepository.findTicketsByAudienceId(audienceID);
  }

  @GetMapping("/girlspower/ticketsBySection/{sectionId}")
  public List<Ticket> findTicketsBySectionId(@PathVariable("sectionId") int sectionID){
    return ticketRepository.findTicketsBySectionId(sectionID);
  }

  @PutMapping("/girlspower/tickets/{ticketId}")
  public void updateTicket(@PathVariable("ticketId") int ticketID,
      @RequestBody Ticket newTicket) {
    Ticket ticket = ticketRepository.findTicketByTicketId(ticketID);
    ticket.setAudience(newTicket.getAudience());
    ticket.setPrice(newTicket.getPrice());
    ticket.setRefundable(newTicket.isRefundable());
    ticket.setSection(newTicket.getSection());
    ticketRepository.save(ticket);
  }

  @DeleteMapping("/girlspower/tickets/{ticketId}")
  public void deleteTicket(@PathVariable("ticketId") int ticketID){
    Ticket ticket = ticketRepository.findTicketByTicketId(ticketID);
    Section section = ticket.getSection();
    Audience audience = ticket.getAudience();
    sectionTicketDao.removeTicketFromSection(ticketID, section.getSection_id());
    audienceTicketDao.removeTicketFromAudience(ticketID, audience.getAudienceID());
    ticketRepository.deleteById(ticketID);
  }
}

package com.example.springtemplate.daos;

import com.example.springtemplate.models.Audience;
import com.example.springtemplate.models.Section;
import com.example.springtemplate.models.Ticket;
import com.example.springtemplate.repositories.TicketRepository;
import java.util.List;
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
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  AudienceTicketDao audienceTicketDao;
  @Autowired
  SectionTicketDao sectionTicketDao;

  @PostMapping("/girlspower/tickets")
  public Ticket createTicket(@RequestBody Ticket ticket){
    ticketRepository.save(ticket);
    int ticketID = ticket.getTicketID();
    audienceTicketDao.addTicketToAudience(ticketID, ticket.getAudienceID());
    sectionTicketDao.addTicketToSection(ticketID, ticket.getSectionID());
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
    audienceTicketDao.removeTicketFromAudience(ticketID, ticket.getAudienceID());
    ticket.setAudienceID(newTicket.getAudienceID());
    audienceTicketDao.addTicketToAudience(ticketID, ticket.getAudienceID());
    ticket.setPrice(newTicket.getPrice());
    ticket.setRefundable(newTicket.isRefundable());
    sectionTicketDao.removeTicketFromSection(ticketID, ticket.getSectionID());
    ticket.setSectionID(newTicket.getSectionID());
    sectionTicketDao.addTicketToSection(ticketID, ticket.getSectionID());
    ticketRepository.save(ticket);
  }

  @DeleteMapping("/girlspower/tickets/{ticketId}")
  public void deleteTicket(@PathVariable("ticketId") int ticketID){
    Ticket ticket = ticketRepository.findTicketByTicketId(ticketID);
    Section section = ticket.getSection();
    Audience audience = ticket.getAudience();
    sectionTicketDao.removeTicketFromSection(ticketID, section.getSection_id());
    audienceTicketDao.removeTicketFromAudience(ticketID, audience.getPersonID());
    ticketRepository.deleteById(ticketID);
  }
}

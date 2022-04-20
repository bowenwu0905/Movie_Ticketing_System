package com.example.springtemplate.daos;

import com.example.springtemplate.models.Section;
import com.example.springtemplate.models.Ticket;
import com.example.springtemplate.repositories.SectionRepository;
import com.example.springtemplate.repositories.TicketRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionTicketDao {

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


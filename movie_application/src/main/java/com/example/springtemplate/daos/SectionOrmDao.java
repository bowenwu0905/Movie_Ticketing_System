package com.example.springtemplate.daos;

import com.example.springtemplate.models.Section;
import com.example.springtemplate.repositories.SectionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SectionOrmDao {

  @Autowired
  SectionRepository sectionRepository;

  @PostMapping("/girlspower/sections")
  public Section createSection(@RequestBody Section section) {
    return sectionRepository.save(section);
  }

  @GetMapping("/girlspower/sections")
  public List<Section> findAllSections() {
    return (List<Section>) sectionRepository.findAll();
  }

  @GetMapping("/girlspower/sections/{sectionId}")
  public Section findSectionBySectionId(@PathVariable("sectionId") Integer id) {
    return sectionRepository.findById(id).get();
  }

  @PutMapping("/girlspower/sections/{sectionId}")
  public Section updateSection(
      @PathVariable("sectionId") Integer id,
      @RequestBody() Section newSection) {
    Section section = this.findSectionBySectionId(id);
    section.setMovie_id(newSection.getMovie_id());
    section.setTheater_id(newSection.getTheater_id());
    section.setShowtime(newSection.getShowtime());
    section.setRoom_number(newSection.getRoom_number());
    return sectionRepository.save(section);
  }

/*  @DeleteMapping("/girlspower/sections/{sectionId}")
  public void deleteSection(@PathVariable("sectionId") Integer id) {
    List<Ticket> tickets = ticketRepository.findTicketsBySectionId(id);
    for (Ticket ticket : tickets) {
      ticketRepository.deleteById(ticket.getTicketID());
    }
    sectionRepository.deleteById(id);


  }*/
}

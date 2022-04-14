package DAO;


import Repositories.MovieRepository;
import Repositories.SectionRepository;
import Repositories.TheaterRepository;
import Repositories.TicketRepository;
import javax.persistence.criteria.CriteriaBuilder.In;
import models.Movie;
import models.Section;
import models.Theater;
import models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SectionOrmDAO {
  @Autowired
  SectionRepository sectionRepository;

  @Autowired
  MovieRepository movieRepository;

  @Autowired
  TheaterRepository theaterRepository;

  @Autowired
  TicketRepository ticketRepository;

  @PostMapping("/girlspower/sections")
  public Section createSection(@RequestBody Section section){
    return sectionRepository.save(section);
  }

  @GetMapping("/girlspower/sections")
  public List<Section> findAllSections(){
    return (List<Section>) sectionRepository.findAll();
  }

  @GetMapping("/girlspower/sections/{sectionId}")
  public Section findSectionBySectionId(@PathVariable("sectionId") Integer id){
    return sectionRepository.findById(id).get();
  }

  @GetMapping("/girlspower/sectionsByTheater/{theaterId}")
  public List<Section> findSectionsByTheaterId(@PathVariable("theaterId") Integer id){
    Theater theater = theaterRepository.findById(id).get();
    return theater.getSections();
  }


  @GetMapping("/girlspower/sectionsByMovie/{movieId}")
  public List<Section> findSectionsByMovieId(@PathVariable("movieId") Integer id){
    Movie movie = movieRepository.findById(id).get();
    return movie.getSections();
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

  @DeleteMapping("/girlspower/sections/{sectionId}")
  public void deleteSection(@PathVariable("sectionId") Integer id){
    List<Ticket> tickets = ticketRepository.findTicketsBySectionId(id);
    for(Ticket ticket: tickets){
      ticketRepository.deleteById(ticket.getTicketID());
    }
    sectionRepository.deleteById(id);
  }






}

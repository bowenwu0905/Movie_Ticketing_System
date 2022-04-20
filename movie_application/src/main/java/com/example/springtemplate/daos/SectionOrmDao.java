package com.example.springtemplate.daos;

import com.example.springtemplate.models.Movie;
import com.example.springtemplate.models.Section;
import com.example.springtemplate.models.Theater;
import com.example.springtemplate.models.Ticket;
import com.example.springtemplate.repositories.MovieRepository;
import com.example.springtemplate.repositories.SectionRepository;
import com.example.springtemplate.repositories.TheaterRepository;
import com.example.springtemplate.repositories.TicketRepository;
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

  @Autowired
  TheaterRepository theaterRepository;

  @Autowired
  MovieRepository movieRepository;

  @Autowired
  TicketRepository ticketRepository;

  @PostMapping("/girlspower/sections")
  public Section createSection(@RequestBody Section section) {
    SectionMovieDao sectionMovieDao = new SectionMovieDao();
    sectionMovieDao.addSectionToMovie(section.getSection_id(), section.getMovie_id());
    SectionTheaterDao sectionTheaterDao = new SectionTheaterDao();
    sectionTheaterDao.addSectionToTheater(section.getSection_id(), section.getTheater_id());
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
  public void deleteSection(@PathVariable("sectionId") Integer id) {
    List<Ticket> tickets = ticketRepository.findTicketsBySectionId(id);
    for (Ticket ticket : tickets) {
      ticketRepository.deleteById(ticket.getTicketID());
    }
    sectionRepository.deleteById(id);


  }
}

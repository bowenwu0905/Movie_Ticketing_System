package com.example._movie_application.daos;

import com.example._movie_application.Repositories.MovieRepository;
import com.example._movie_application.Repositories.TheaterRepository;
import com.example._movie_application.Repositories.TicketRepository;
import com.example._movie_application.models.Movie;
import com.example._movie_application.models.Theater;
import com.example._movie_application.models.Ticket;
import com.example._movie_application.Repositories.SectionRepository;
import com.example._movie_application.models.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SectionOrmDao {
  SectionRepository sectionRepository;

  MovieRepository movieRepository;

  TheaterRepository theaterRepository;

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
  }}

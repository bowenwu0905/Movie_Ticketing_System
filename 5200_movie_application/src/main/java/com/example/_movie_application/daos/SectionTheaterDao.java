package com.example._movie_application.daos;

import com.example._movie_application.Repositories.SectionRepository;
import com.example._movie_application.Repositories.TheaterRepository;
import com.example._movie_application.models.Section;
import com.example._movie_application.models.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SectionTheaterDao {

  SectionRepository sectionRepository;
  TheaterRepository theaterRepository;

  @GetMapping("/girlspower/addSection/{sectionId}/toTheater/{theaterId}")
  public Theater addSectionToTheater(
      @PathVariable("sectionId") Integer sectionId,
      @PathVariable("theaterId") Integer theaterId
  ){
    Theater theater = theaterRepository.findById(theaterId).get();
    Section section = sectionRepository.findById(sectionId).get();
    theater.getSections().add(section);
    section.setTheater(theater);
    sectionRepository.save(section);
    return theater;
  }

  @GetMapping("/girlspower/removeSection/{sectionId}/toTheater/{theaterId}")
  public Theater removeSectionFromTheater(
      @PathVariable("sectionId") Integer sectionId,
      @PathVariable("theaterId") Integer theaterId
  ){
    Theater theater = theaterRepository.findById(theaterId).get();
    Section section = sectionRepository.findById(sectionId).get();
    theater.getSections().remove(section);
    section.setTheater(null);
    sectionRepository.save(section);
    return theater;

  }

}

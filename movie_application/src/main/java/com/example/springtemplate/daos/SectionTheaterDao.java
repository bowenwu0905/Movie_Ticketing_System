package com.example.springtemplate.daos;

import com.example.springtemplate.models.Section;
import com.example.springtemplate.models.Theater;
import com.example.springtemplate.repositories.SectionRepository;
import com.example.springtemplate.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SectionTheaterDao {
  @Autowired
  SectionRepository sectionRepository;
  @Autowired
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

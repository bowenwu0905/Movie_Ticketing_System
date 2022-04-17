package final_proj.daos;

import final_proj.Repositories.SectionRepository;
import final_proj.Repositories.TheaterRepository;
import final_proj.models.Section;
import final_proj.models.Theater;
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
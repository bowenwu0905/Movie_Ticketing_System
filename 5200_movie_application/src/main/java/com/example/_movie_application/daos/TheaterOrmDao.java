package com.example._movie_application.daos;

import com.example._movie_application.Repositories.SectionRepository;
import com.example._movie_application.Repositories.TheaterRepository;
import java.util.List;
import com.example._movie_application.models.Section;
import com.example._movie_application.models.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TheaterOrmDao {
  TheaterRepository theaterRepository;

  SectionRepository sectionRepository;

  @PostMapping("/girlspower/theaters")
  public Theater createTheater(@RequestBody Theater theater){
    return theaterRepository.save(theater);
  }

  @GetMapping("/girlspower/theaters")
  public List<Theater> findAllTheaters(){
    return (List<Theater>) theaterRepository.findAll();
  }

  @GetMapping("/girlspower/theaters/{theaterId}")
  public Theater findTheaterById(@PathVariable("theaterId") Integer id){
    return theaterRepository.findById(id).get();
  }

  @PutMapping("/girlspower/theaters/{theaterId}")
  public Theater updateTheater(@PathVariable("theaterId") Integer id,
      @RequestBody() Theater newTheater){
    Theater theater = this.findTheaterById(id);
    theater.setName(newTheater.getName());
    theater.setAddress(newTheater.getAddress());
    theater.setCapacity(newTheater.getCapacity());
    return theaterRepository.save(theater);
  }

  @DeleteMapping("/girlspower/theaters/{theaterId}")
  public void deleteTheater(
      @PathVariable("theaterId") Integer id) {
    List<Section> sections = sectionRepository.getSectionsByTheater_id(id);
    for(Section section: sections){
      sectionRepository.deleteById(section.getSection_id());
    }
    theaterRepository.deleteById(id);
  }


}

package com.example.springtemplate.daos;

import com.example.springtemplate.models.Section;
import com.example.springtemplate.models.Theater;
import com.example.springtemplate.repositories.SectionRepository;
import com.example.springtemplate.repositories.TheaterRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TheaterOrmDao {
  @Autowired
  TheaterRepository theaterRepository;
  @Autowired
  SectionRepository sectionRepository;
  @Autowired
  SectionOrmDao sectionOrmDao;

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
    theater.setTheater_name(newTheater.getTheater_name());
    theater.setAddress(newTheater.getAddress());
    theater.setCapacity(newTheater.getCapacity());
    return theaterRepository.save(theater);
  }

  @DeleteMapping("/girlspower/theaters/{theaterId}")
  public void deleteTheater(
      @PathVariable("theaterId") Integer id) {
    List<Section> sections = this.findTheaterById(id).getSections();
    List<Integer> sectionsID = new ArrayList<>();
    for(Section section: sections){
      sectionsID.add(section.getSection_id());
    }
    for(Integer i : sectionsID) {
      sectionOrmDao.deleteSection(i);
    }
    theaterRepository.deleteById(id);
  }


}

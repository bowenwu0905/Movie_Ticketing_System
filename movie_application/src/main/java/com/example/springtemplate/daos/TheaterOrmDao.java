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
  @Autowired
  ManagerTheaterDao managerTheaterDao;

  @PostMapping("/girlspower/theaters")
  public Theater createTheater(@RequestBody Theater theater){
    theaterRepository.save(theater);
    int theaterID = theater.getTheater_id();
    managerTheaterDao.addTheaterToManager(theaterID, theater.getManager_id());
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
  public void updateTheater(@PathVariable("theaterId") Integer id,
      @RequestBody() Theater newTheater){
    Theater theater = this.findTheaterById(id);
    theater.setTheater_name(newTheater.getTheater_name());
    theater.setAddress(newTheater.getAddress());
    theater.setCapacity(newTheater.getCapacity());
    managerTheaterDao.removeTheaterFromManager(id, theater.getManager_id());
    theater.setManager_id(newTheater.getManager_id());
    managerTheaterDao.addTheaterToManager(id, theater.getManager_id());
    theaterRepository.save(theater);
  }

  @DeleteMapping("/girlspower/theaters/{theaterId}")
  public void deleteTheater(
      @PathVariable("theaterId") Integer id) {
    Theater theater = this.findTheaterById(id);
    List<Section> sections = theater.getSections();
    List<Integer> sectionsID = new ArrayList<>();
    if(sections != null){
      for(Section section: sections){
        sectionsID.add(section.getSection_id());
      }
      for(Integer i : sectionsID) {
        sectionOrmDao.deleteSection(i);
      }
    }
    managerTheaterDao.removeTheaterFromManager(id, theater.getManager_id());
    theaterRepository.deleteById(id);
  }


}

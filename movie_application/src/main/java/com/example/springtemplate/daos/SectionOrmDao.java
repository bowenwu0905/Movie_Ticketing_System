package com.example.springtemplate.daos;

import com.example.springtemplate.models.Section;
import com.example.springtemplate.repositories.SectionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SectionOrmDao {
  @Autowired
  SectionRepository sectionRepository;

  @GetMapping("/girlspower/sections")
  public List<Section> findAllSections(){
    return sectionRepository.findAllSections();
  }

}

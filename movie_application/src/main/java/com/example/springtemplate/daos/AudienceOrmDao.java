package com.example.springtemplate.daos;

import com.example.springtemplate.models.Audience;
import com.example.springtemplate.models.Ticket;
import com.example.springtemplate.repositories.AudienceRepository;
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
public class AudienceOrmDao {
  @Autowired
  AudienceRepository audienceRepository;
  AudienceTicketDao audienceTicketDao;

  @PostMapping("/girlspower/audiences")
  public Audience createAudience(@RequestBody Audience audience){
    return audienceRepository.save(audience);
  }

  @GetMapping("/girlspower/audiences")
  public List<Audience> findAllAudiences(){
    return (List<Audience>)audienceRepository.findAll();
  }

  @GetMapping("girlspower/audiences/{audience_id}")
  public Audience findAudienceById(@PathVariable("audience_id") int audienceID){
    return audienceRepository.findById(audienceID).get();
  }

  @PutMapping("girlspower/audiences/{audienceId}")
  public Audience updateAudience(@PathVariable("audienceId") int audienceID,
      @RequestBody Audience newAudience){
    Audience audience = this.findAudienceById(audienceID);
    audience.setFirstName(newAudience.getFirstName());
    audience.setLastName(newAudience.getLastName());
    audience.setUserName(newAudience.getUserName());
    audience.setPassword(newAudience.getPassword());
    audience.setEmail(newAudience.getEmail());
    audience.setDateOfBirth(newAudience.getDateOfBirth());
    audience.setCardNumber(newAudience.getCardNumber());
    audience.setPoints(newAudience.getPoints());
    return audienceRepository.save(audience);
  }

  @DeleteMapping("/girlspower/audiences/{audienceId}")
  public void deleteAudience(@PathVariable("audienceId") int audienceID){
    Audience audience = this.findAudienceById(audienceID);
    List<Ticket> tickets = audience.getTickets();
    for(Ticket t : tickets){
      audienceTicketDao.removeTicketFromAudience(t.getTicketID(), audienceID);
    }
    audienceRepository.deleteById(audienceID);
  }

}

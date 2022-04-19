package com.example._movie_application.daos;

import com.example._movie_application.models.Audience;
import com.example._movie_application.Repositories.AudienceRepository;
import java.util.List;
import com.example._movie_application.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("girlspower/audiences/{audienceId}")
  public Audience findAudienceById(@PathVariable("audienceId") int audienceID){
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

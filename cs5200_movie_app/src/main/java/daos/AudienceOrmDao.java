package daos;

import Repositories.AudienceRepository;
import java.util.List;
import models.Audience;
import models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    return audienceRepository.findAllAudiences();
  }

  @GetMapping("girlspower/audiences/{audienceId}")
  public Audience findAudienceById(@PathVariable("audienceId") int audienceID){
    return audienceRepository.findAudienceById(audienceID);
  }

  @PutMapping("girlspower/audiences/{audienceId}")
  public void updateAudience(@PathVariable("audienceId") int audienceID,
      @RequestBody Audience newAudience){
    Audience audience = audienceRepository.findAudienceById(audienceID);
    audience.setFirstName(newAudience.getFirstName());
    audience.setLastName(newAudience.getLastName());
    audience.setUserName(newAudience.getUserName());
    audience.setPassword(newAudience.getPassword());
    audience.setEmail(newAudience.getEmail());
    audience.setDateOfBirth(newAudience.getDateOfBirth());
    audience.setCardNumber(newAudience.getCardNumber());
    audience.setPoints(newAudience.getPoints());
    audienceRepository.save(audience);
  }

  @DeleteMapping("/girlspower/audiences/{audienceId}")
  public void deleteAudience(@PathVariable("audienceId") int audienceID){
    Audience audience = audienceRepository.findAudienceById(audienceID);
    List<Ticket> tickets = audience.getTickets();
    for(Ticket t : tickets){
      audienceTicketDao.removeTicketFromAudience(t.getTicketID(), audienceID);
    }
    audienceRepository.deleteById(audienceID);
  }

}

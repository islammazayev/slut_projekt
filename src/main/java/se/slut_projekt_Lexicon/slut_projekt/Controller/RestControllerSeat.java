package se.slut_projekt_Lexicon.slut_projekt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.martin.airplane_company.data_access.SeatDao;
import se.martin.airplane_company.models.Seat;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class RestControllerSeat {

	
	@Autowired
	SeatDao seatdao;

	

	@GetMapping("/seat")
    public ResponseEntity<List<Seat>> getAllSeats() {       
        
        return ResponseEntity.status(200).body(seatdao.findAll());
         
    }
     
     
    @PostMapping("/seat")
    public ResponseEntity<Seat> create(@RequestBody Seat seat) {
        
        return ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(seatdao.save(seat));
                 
    }
     
    @PutMapping("/seat")
    public ResponseEntity<Seat> update(@RequestBody Seat seat) {
        
        return ResponseEntity.status(200).body(seatdao.update(seat));
     
         
    }
     
    @DeleteMapping("/seat")
    public ResponseEntity<Seat> delete(@RequestBody Seat seat) {
         
       
    	seatdao.delete(seat.getId());
        return ResponseEntity.status(200).build();      
    }
     
    @GetMapping("/seat/{id}")
    public ResponseEntity<Seat> getId(@PathVariable(value="id") int id){
         
        return ResponseEntity.status(200).body(seatdao.find(id));
    }


}

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

import se.martin.airplane_company.data_access.FlightDao;
import se.martin.airplane_company.data_access.PassengerDao;
import se.martin.airplane_company.models.Passenger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class RestControllerPassenger {

	@Autowired
	PassengerDao passengerDao;
	@Autowired
	FlightDao flightDao;
	
	
	@GetMapping("/passenger")
    public ResponseEntity<List<Passenger>> getAllPassengers() {       
         
        return ResponseEntity.status(200).body(passengerDao.findAll());
         
    }
     
     
    @PostMapping("/passenger")
    public ResponseEntity<Passenger> create(@RequestBody Passenger passenger) {
    	//passenger.setFlight(flightDao.find(passenger.getFlight().getId()));
    
        return ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(passengerDao.save(passenger));
                 
    }
     
    @PutMapping("/passenger")
    public ResponseEntity<Passenger> update(@RequestBody Passenger passenger) {
        
    	passenger.setFlight(flightDao.find(passenger.getFlight().getId()));
        return ResponseEntity.status(200).body(passengerDao.update(passenger));
     
         
    }
     
    @DeleteMapping("/passenger")
    public ResponseEntity<Passenger> delete(@RequestBody Passenger passenger) {
         
       
    	passengerDao.delete(passenger.getId());
        return ResponseEntity.status(200).build();      
    }
     
    @GetMapping("/passenger/{id}")
    public ResponseEntity<Passenger> getId(@PathVariable(value="id") int id){
         
        return ResponseEntity.status(200).body(passengerDao.find(id));
    }

}

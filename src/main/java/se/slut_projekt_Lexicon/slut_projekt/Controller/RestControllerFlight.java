package se.slut_projekt_Lexicon.slut_projekt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import se.martin.airplane_company.models.Flight;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class RestControllerFlight {
	
	@Autowired
	FlightDao flightDao;
	
	
	@GetMapping("/flight")
    public ResponseEntity<List<Flight>> getAllFlights() {       
         
        return ResponseEntity.status(200).body(flightDao.findAll());
         
    }
     
     
    @PostMapping("/flight")
    public ResponseEntity<Flight> create(@RequestBody Flight flight) {
         
        return ResponseEntity.status(201).body(flightDao.save(flight));
                 
    }
     
    @PutMapping("/flight")
    public ResponseEntity<Flight> update(@RequestBody Flight flight) {
         
        return ResponseEntity.status(200).body(flightDao.update(flight));
     
         
    }
     
    @DeleteMapping("/flight")
    public ResponseEntity<Flight> delete(@RequestBody Flight flight) {
         
       
		flightDao.delete(flight.getId());
        return ResponseEntity.status(200).build();      
    }
     
    @GetMapping("/flight/{id}")
    public ResponseEntity<Flight> getId(@PathVariable(value="id") int id){
         
        return ResponseEntity.status(200).body(flightDao.find(id));
    }
	

}

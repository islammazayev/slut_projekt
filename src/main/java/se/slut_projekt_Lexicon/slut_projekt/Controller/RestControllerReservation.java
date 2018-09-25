package se.slut_projekt_Lexicon.slut_projekt.Controller;

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

import se.martin.airplane_company.data_access.ReservationDao;
import se.martin.airplane_company.models.Reservation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class RestControllerReservation {
	
	@Autowired
	ReservationDao reservationDao;

	
	@GetMapping("/reservation")
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {        
        return ResponseEntity.status(200).body(reservationDao.findAll());
    }
	
     
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        reservation.TotalPriceCalculate();
        return ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(reservationDao.save(reservation));
                 
    }
     
    @PutMapping("/reservation")
    public ResponseEntity<Reservation> update(@RequestBody Reservation reservation) {
    	reservation.TotalPriceCalculate();
        return ResponseEntity.status(200).body(reservationDao.update(reservation));
     
         
    }
     
    @DeleteMapping("/reservation")
    public ResponseEntity<Reservation> delete(@RequestBody Reservation reservation) {
         
       
    	reservationDao.delete(reservation.getId());
        return ResponseEntity.status(200).build();      
    }
     
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getId(@PathVariable(value="id") int id){
         
        return ResponseEntity.status(200).body(reservationDao.find(id));
    }


}

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
import se.martin.airplane_company.data_access.FoodDao;
import se.martin.airplane_company.models.Food;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class RestControllerFood {
	
	@Autowired
	FoodDao foodDao;
	@Autowired
	FlightDao flightDao;

	
	@GetMapping("/food")
    public ResponseEntity<List<Food>> getAllFoods() {       
         
        return ResponseEntity.status(200).body(foodDao.findAll());
         
    }
     
     
    @PostMapping("/food")
    public ResponseEntity<Food> create(@RequestBody Food food) {
        
        return ResponseEntity.status(201).contentType(MediaType.APPLICATION_JSON).body(foodDao.save(food));
                 
    }
     
    @PutMapping("/food")
    public ResponseEntity<Food> update(@RequestBody Food food) {
    	
        return ResponseEntity.status(200).body(foodDao.update(food));
     
         
    }
     
    @DeleteMapping("/food")
    public ResponseEntity<Food> delete(@RequestBody Food food) {
         
       
    	foodDao.delete(food.getId());
        return ResponseEntity.status(200).build();      
    }
     
    @GetMapping("/food/{id}")
    public ResponseEntity<Food> getId(@PathVariable(value="id") int id){
         
        return ResponseEntity.status(200).body(foodDao.find(id));
    }

}

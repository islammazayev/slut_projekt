package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import se.martin.airplane_company.models.Seat;

public interface SeatDao {
	
	Seat save(Seat seat);      //C
	Seat find(int id);         //R
	Seat update(Seat seat);    //U
	void delete(int id);      // D
	List<Seat> findAll();

}

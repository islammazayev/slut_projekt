package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import se.martin.airplane_company.models.Reservation;

public interface ReservationDao {
	
	Reservation save(Reservation reservation);       //C
	Reservation find(int id);         			     //R
	Reservation update(Reservation reservation);     //U
	void delete(int id);      				        // D
	List<Reservation> findAll();

}

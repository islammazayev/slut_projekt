package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import se.martin.airplane_company.models.Passenger;

public interface PassengerDao {
	Passenger save(Passenger passengers);       //C
	Passenger find(int id);         			//R
	Passenger update(Passenger passengers);     //U
	void delete(int id);      				   // D
	List<Passenger> findAll();

}

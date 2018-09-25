package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import se.martin.airplane_company.models.Flight;

public interface FlightDao {
	Flight save(Flight flight);   	// C
	Flight find(int id);            // R
	Flight update(Flight flight); 	// U
	void delete(int id);            // D
	List<Flight> findAll();

}

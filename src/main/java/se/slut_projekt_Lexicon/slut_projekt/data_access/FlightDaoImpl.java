package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import se.martin.airplane_company.models.Flight;

@Repository
@Transactional
public class FlightDaoImpl implements FlightDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Flight save(Flight flight) {
		entityManager.persist(flight);
		return flight;
	}

	@Override
	public Flight find(int id) {
		Flight flights = entityManager.find(Flight.class, id);
		return flights;
	}

	@Override
	public Flight update(Flight flight) {
		entityManager.merge(flight);
		return flight;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(find(id));
		System.out.println("Deleted: " + id);

	}

	@Override
	public List<Flight> findAll() {
		Query sqlQuery = entityManager.createQuery("SELECT f FROM Flight f");
		@SuppressWarnings("unchecked")
		List<Flight> allFlights = sqlQuery.getResultList();
		return allFlights;
	}

}

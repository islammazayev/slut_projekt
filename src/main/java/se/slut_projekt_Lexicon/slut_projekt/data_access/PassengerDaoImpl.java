package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import se.martin.airplane_company.models.Passenger;


@Repository
@Transactional
public class PassengerDaoImpl implements PassengerDao {

	

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Passenger save(Passenger passenger) {
		entityManager.persist(passenger);
		return passenger;
	}

	@Override
	public Passenger find(int id) {
		Passenger passenger = entityManager.find(Passenger.class, id);
		return passenger;
	}

	@Override
	public Passenger update(Passenger passenger) {
		entityManager.merge(passenger);
		return passenger;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(find(id));
		System.out.println("Deleted: " + id);

	}

	@Override
	public List<Passenger> findAll() {
		 Query query = entityManager.createQuery("SELECT p FROM Passenger p");
	        @SuppressWarnings("unchecked")
			List<Passenger> allPassengers = query.getResultList();
	  
		return allPassengers;

	}

}

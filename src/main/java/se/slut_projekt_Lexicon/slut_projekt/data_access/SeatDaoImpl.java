package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import se.martin.airplane_company.models.Seat;


@Repository
@Transactional
public class SeatDaoImpl implements SeatDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Seat save(Seat seat) {
		entityManager.persist(seat);
		return seat;
	}

	@Override
	public Seat find(int id) {
		Seat seat = entityManager.find(Seat.class, id);
		return seat;
	}

	@Override
	public Seat update(Seat seat) {
		entityManager.merge(seat);
		return seat;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(find(id));
		System.out.println("Deleted: " + id);


	}

	@Override
	public List<Seat> findAll() {
		Query sqlQuery = entityManager.createQuery("SELECT a FROM Seat a");
		@SuppressWarnings("unchecked")
		List<Seat> allSeats = (List<Seat>) sqlQuery.getResultList();
		return allSeats;
	}

}

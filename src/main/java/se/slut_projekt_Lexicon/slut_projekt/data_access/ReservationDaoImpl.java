package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import se.martin.airplane_company.models.Reservation;


@Repository
@Transactional
public class ReservationDaoImpl implements ReservationDao {


	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Reservation save(Reservation reservation) {
		entityManager.persist(reservation);
		return reservation;
	}

	@Override
	public Reservation find(int id) {
		Reservation reservation = entityManager.find(Reservation.class, id);
		return reservation;
	}

	@Override
	public Reservation update(Reservation reservation) {
		entityManager.merge(reservation);
		return reservation;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(find(id));
		System.out.println("Deleted: " + id);


	}

	@Override
	public List<Reservation> findAll() {
		Query sqlQuery = entityManager.createQuery("SELECT r FROM Reservation r");
		@SuppressWarnings("unchecked")
		List<Reservation> allReservations = (List<Reservation>) sqlQuery.getResultList();
		return allReservations;
	}

}

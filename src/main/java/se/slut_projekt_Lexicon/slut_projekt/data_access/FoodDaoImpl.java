package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.martin.airplane_company.models.Food;

@Repository
@Transactional
public class FoodDaoImpl implements FoodDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Food save(Food food) {
		entityManager.persist(food);
		return food;
	}

	@Override
	public Food find(int id) {
		Food food = entityManager.find(Food.class, id);
		return food;
	}

	@Override
	public Food update(Food food) {
		entityManager.merge(food);
		return food;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(find(id));
		System.out.println("Deleted: " + id);
	}

	@Override
	public List<Food> findAll() {
		Query sqlQuery = entityManager.createQuery("SELECT q FROM Food q");
		@SuppressWarnings("unchecked")
		List<Food> allFoods = (List<Food>) sqlQuery.getResultList();
		return allFoods;
	}

}

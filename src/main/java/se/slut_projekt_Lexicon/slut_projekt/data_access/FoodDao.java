package se.slut_projekt_Lexicon.slut_projekt.data_access;

import java.util.List;

import se.martin.airplane_company.models.Food;

public interface FoodDao {

	Food save(Food foods);     //C
	Food find(int id);         //R
	Food update(Food foods);   //U
	void delete(int id);      // D
	List<Food> findAll();
}

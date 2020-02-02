package model.dao;

import org.springframework.data.repository.CrudRepository;

import model.domain.Ingredients;

public interface IngredientsRepository extends CrudRepository<Ingredients, String> {

}

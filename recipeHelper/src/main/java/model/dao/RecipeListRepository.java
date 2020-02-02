package model.dao;

import org.springframework.data.repository.CrudRepository;

import model.domain.RecipeList;

public interface RecipeListRepository extends CrudRepository<RecipeList, String> {

}

package model.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import model.domain.FirstCategory;
import model.domain.SecondCategory;

public interface SecondCategoryRepository  extends CrudRepository<SecondCategory, String> {

	Optional<SecondCategory> findByName(String name);
	Iterable<SecondCategory> findAllByFirstCategory(FirstCategory firstCategory);
}

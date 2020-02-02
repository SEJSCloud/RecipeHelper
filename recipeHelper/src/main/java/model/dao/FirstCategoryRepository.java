package model.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import model.domain.FirstCategory;

public interface FirstCategoryRepository  extends CrudRepository<FirstCategory, String> {

	Optional<FirstCategory> findByName(String name);
}

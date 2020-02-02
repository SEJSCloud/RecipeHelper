package model.dao;

import org.springframework.data.repository.CrudRepository;

import model.domain.ThirdCategory;

public interface ThirdCategoryRepository extends CrudRepository<ThirdCategory, String> {
	long count();
}

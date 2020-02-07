package model.dao;

import org.springframework.data.repository.CrudRepository;

import model.domain.FirstCategory;
import model.domain.SecondCategory;
import model.domain.ThirdCategory;

public interface ThirdCategoryRepository extends CrudRepository<ThirdCategory, String> {
	long count();
	Iterable<ThirdCategory> findAllBySecondCategory(SecondCategory secondCategory);
	Iterable<ThirdCategory> findAllByFirstCategory(FirstCategory firstCategory);
}

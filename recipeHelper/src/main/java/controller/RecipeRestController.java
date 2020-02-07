package controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.domain.FirstCategory;
import model.domain.SecondCategory;
import model.domain.ThirdCategory;
import service.RecipeService;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class RecipeRestController {
	
	@Autowired
	private RecipeService service;
	
//	@GetMapping("/getRecipeCategory")
//	public void getRecipeCategory() {
//		service.getRecipeName();
//	}
//	
//	@GetMapping("/getRecipe")
//	public void getRecipe() {
//		service.saveRecipe();
//	}

	@GetMapping("/getFirstCategory")
	public Iterable<FirstCategory> getFirstCategory() {
		return service.getFirstCategory();
	}
	
	@GetMapping("/getSecondCategory")
	public Iterable<SecondCategory> getSecondCategory(String firstCategoryId) {
		return service.getSecondCategory(firstCategoryId);
	}
	
	@GetMapping("/getThirdCategory")
	public Iterable<ThirdCategory> getThirdCategory(String secondCategoryId) {
		return service.getThirdCategory(secondCategoryId);
	}
	
	@GetMapping("/getThirdCategoryRecipe")
	public ThirdCategory getThirdCategoryRecipe(String thirdCategoryId) {
		return service.getThirdCategoryRecipe(thirdCategoryId);
	}
	
	@GetMapping("/getRecipeByfirst")
	public Iterable<ThirdCategory> getRecipeByfirst(String firstCategoryId) {
		return service.getRecipeByfirst(firstCategoryId);
	}
}

package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dao.FirstCategoryRepository;
import model.dao.ImgListRepository;
import model.dao.IngredientsRepository;
import model.dao.RecipeListRepository;
import model.dao.SecondCategoryRepository;
import model.dao.ThirdCategoryRepository;
import model.domain.FirstCategory;
import model.domain.SecondCategory;
import model.domain.ThirdCategory;

@Service
public class RecipeService {

	@Autowired
	private FirstCategoryRepository fRepo;

	@Autowired
	private SecondCategoryRepository sRepo;

	@Autowired
	private ThirdCategoryRepository tRepo;

	@Autowired
	private ImgListRepository imgRepo;

	@Autowired
	private IngredientsRepository ingredientRepo;

	@Autowired
	private RecipeListRepository recipeRepo;

	private static int firstSequence = 1;
	private static int secondSequence = 1;
	private static int thirdSequence = 1;

//	private static Selenium browser = Selenium.getInstance();
	
	// ==================================================================================
	
	// 첫번째 카테고리
	
	public Iterable<FirstCategory> getFirstCategory() {
		return fRepo.findAll();
	}
	
	// ==================================================================================
	
	// 두번째 카테고리
	
	public Iterable<SecondCategory> getSecondCategory(String firstCategoryId) {
		return sRepo.findAllByFirstCategory(fRepo.findById(firstCategoryId).get());
	}

	// ==================================================================================
	
	// 세번째 카테고리
	
	public Iterable<ThirdCategory> getThirdCategory(String secondCategoryId) {
		return tRepo.findAllBySecondCategory(sRepo.findById(secondCategoryId).get());
	}
	
	public ThirdCategory getThirdCategoryRecipe(String thirdCategoryId) {
		return tRepo.findById(thirdCategoryId).get();
	}

	// ==================================================================================

	// 크롤링

//	public void movePage(String name) {
//		browser.get("http://www.10000recipe.com/recipe/list.html?q=" + name);
//		browser.sleep(2);
//	}
//
//	public void getRecipeName() {
//		String[] nameList = { "밥", "죽", "국수", "만두", "떡국", "수제비", "국", "찌개", "구이", "전", "조림", "튀김", "볶음", "나물", "생채", "젓갈", "장아찌", "찜", "전골", "김치"};
//
//		try {
//			for (String name : nameList) {
//				FirstCategory entity = new FirstCategory();
//				entity.setId("A" + firstSequence++);
//				entity.setName(name);
//				fRepo.save(entity);
//
//				System.out.println("1번째 : " + name);
//
//				movePage(name);
//				getSecondRecipeName("A" + (firstSequence - 1), browser.findByClass("tag_cont").getText().split(" "));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			browser.sleep(2);
//			browser.quit();
//		}
//
//	}
//
//	public void getSecondRecipeName(String firstCategoryId, String[] secondNameList) {
//		SecondCategory entity = new SecondCategory();
//
//		for (String name : secondNameList) {
//			entity.setFirstCategory(fRepo.findById(firstCategoryId).get());
//			entity.setId("B" + secondSequence++);
//			entity.setName(name);
//			sRepo.save(entity);
//
//			System.out.println("2번째 : " + name);
//			
//			movePage(name);
//			String[] recipeList = browser.findByClass("tag_cont").getText().split(" ");
//
//			if(recipeList[0].length() != 0) {
//				getThirdRecipeName("B" + (secondSequence - 1), recipeList);
//			}
//
//		}
//
//	}
//
//	public void getThirdRecipeName(String secondCategoryId, String[] ThirdNameList) {
//		for (String name : ThirdNameList) {
//			ThirdCategory entity = new ThirdCategory();
//			entity.setFirstCategory(sRepo.findById(secondCategoryId).get().getFirstCategory());
//			entity.setSecondCategory(sRepo.findById(secondCategoryId).get());
//			entity.setId("C" + thirdSequence++);
//			entity.setName(name);
//
//			System.out.println("3번째 : " + name);
//			movePage(name);
//
//			try {
//				// 요리 썸네일 주소값
//				entity.setThumbnail(
//						browser.find("#contents_area_full > div > div.rcp_m_list2 > div.row > div:nth-child(1) > a > img")
//								.getAttribute("src"));
//
//				// 요리 링크 주소
//				String url = browser.findByClass("thumbnail").getAttribute("href");
//				entity.setRecipeUrl(url);
//
//				movePage(url);
//
//				
//				try {
//					// 몇인분
//					entity.setServings(browser.findByClass("view2_summary_info1").getText());
//				}catch (NoSuchElementException | UnhandledAlertException e) {
//					e.printStackTrace();
//				}
//				
//				try {
//					// 요리시간
//					entity.setTime(browser.findByClass("view2_summary_info2").getText());
//				}catch (NoSuchElementException | UnhandledAlertException e) {
//					e.printStackTrace();
//				}
//				
//				try {
//					// 난이도
//					entity.setDifficulty(browser.findByClass("view2_summary_info3").getText());
//				}catch (NoSuchElementException | UnhandledAlertException e) {
//					e.printStackTrace();
//				}
//
//				tRepo.save(entity);
//
//			}catch (NoSuchElementException | UnhandledAlertException e) {
//				e.printStackTrace();
//			}
//
//		}
//
//	}
//
//	public void saveRecipe() {
//		for(ThirdCategory firstEntity : tRepo.findAll()) {
//			movePage(firstEntity.getRecipeUrl());
//
//			try {
//				
//				for (WebElement el : browser.findByClass("ready_ingre3").findElements(By.tagName("li"))) {
//					// 재료
//					Ingredients ingredientEntity = new Ingredients();
//					ingredientEntity.setThirdCategory(firstEntity);
//					ingredientEntity.setIngredients(el.getText().replace("\n", ""));
//					ingredientRepo.save(ingredientEntity);
//
//				}
//
//				for(WebElement el : browser.findAllByClass("view_step_cont")) {
//					
//					try {
//						// 레시피
//						RecipeList recipeListEntiy = new RecipeList();
//						recipeListEntiy.setRecipe(el.getText());
//						recipeListEntiy.setThirdCategory(firstEntity);
//						recipeRepo.save(recipeListEntiy);
//
//					}catch (NoSuchElementException e) {
//						e.printStackTrace();
//					}
//
//					try {
//						// 레시피 이미지
//						ImgList imgListEntity = new ImgList();
//						imgListEntity.setThirdCategory(firstEntity);
//						imgListEntity.setImg(el.findElement(By.tagName("img")).getAttribute("src"));
//						imgRepo.save(imgListEntity);
//					}catch (NoSuchElementException e) {
//						e.printStackTrace();
//					}
//
//				}
//			}catch (NoSuchElementException | UnhandledAlertException e) {
//				e.printStackTrace();
//			}
//			
//			browser.sleep(2);
//		}
//		browser.quit();
//
//	}

}

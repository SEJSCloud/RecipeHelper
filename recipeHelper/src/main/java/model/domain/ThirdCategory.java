package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ThirdCategory {

	@Id
	@Column(name = "third_category_id", length = 10)
	private String id;
	
	@Column(name = "third_category_name", length = 50)
	private String name;
	
	@Column(name = "thumbnail_location", columnDefinition = "TEXT")
	private String thumbnail;
	
	@Column(name = "recipe_url", columnDefinition = "TEXT")
	private String recipeUrl;
	
	@Column(name = "servings", length = 10)
	private String servings;

	@Column(name = "time", length = 20)
	private String time;
	
	@Column(name = "difficulty", length = 10)
	private String difficulty;
	
	@JsonIgnore
	@OneToMany(mappedBy = "thirdCategory")
	private List<Ingredients> ingredients = new ArrayList<Ingredients>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "thirdCategory")
	private List<RecipeList> recipeList = new ArrayList<RecipeList>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "thirdCategory")
	private List<ImgList> imgList = new ArrayList<ImgList>();
	
	@ManyToOne
	@JoinColumn(name = "first_category_id")
	private FirstCategory firstCategory;
	
	@ManyToOne
	@JoinColumn(name = "second_category_id")
	private SecondCategory secondCategory;
}

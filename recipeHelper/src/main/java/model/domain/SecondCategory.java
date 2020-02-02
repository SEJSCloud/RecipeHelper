package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class SecondCategory {

	@Id
	@Column(name = "second_category_id", length = 10)
	private String id;
	
	@Column(name = "second_category_name", length = 50)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "first_category_id")
	private FirstCategory firstCategory;
	
	@JsonIgnore
	@OneToMany(mappedBy = "secondCategory")
	private List<ThirdCategory> thirdCategory = new ArrayList<ThirdCategory>();
	
}

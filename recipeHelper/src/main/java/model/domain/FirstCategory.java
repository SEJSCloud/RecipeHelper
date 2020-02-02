package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FirstCategory {

	@Id
	@Column(name = "first_category_id", length = 10)
	private String id;
	
	@Column(name = "first_category_name", length = 50)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "firstCategory")
	private List<SecondCategory> secondCategory = new ArrayList<SecondCategory>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "firstCategory")
	private List<ThirdCategory> thirdCategory = new ArrayList<ThirdCategory>();
}

package test.astralife.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "divisions")
public class Division {

	private long division_id;
	private String name;
	
	public Division() {
		
	}
	
	public Division(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getDivisionId() {
		return division_id;
	}
	public void setDivisionId(long division_id) {
		this.division_id = division_id;
	}
	
	@Column(name = "name", nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Division [division_id=" + division_id + ", name=" + name + "]";
	}
	
}

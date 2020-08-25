package test.astralife.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {

	private long position_id;
	private String level;
	private String name;
	
	public Position() {
		
	}
	
	public Position(String level, String name) {
		this.level = level;
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPositionId() {
		return position_id;
	}
	public void setPositionId(long position_id) {
		this.position_id = position_id;
	}
	
	@Column(name = "level", nullable = true)
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
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
		return "Position [position_id=" + position_id + ", level=" + level + ", name=" + name + "]";
	}
	
}

package test.astralife.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	private long id;
	private String nik;
	private String name;
	private String type;
	private String lastPosition;
	private long positionId;
	private long divisionId;
	private String createdDate;
	
	public Employee() {
		
	}
	
	public Employee(String nik, String name, String type, String lastPosition, long positionId, long divisionId, String createdDate) {
		this.nik = nik;
		this.name = name;
		this.type = type;
		this.lastPosition = lastPosition;
		this.positionId = positionId;
		this.divisionId = divisionId;
		this.createdDate = createdDate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nik", nullable = true)
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	
	@Column(name = "name", nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "type", nullable = true)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "last_position", nullable = true)
	public String getLastPosition() {
		return lastPosition;
	}
	public void setLastPosition(String lastPosition) {
		this.lastPosition = lastPosition;
	}
	
	@Column(name = "position_id", nullable = true)
	public long getPositionId() {
		return positionId;
	}
	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}
	
	@Column(name = "division_id", nullable = true)
	public long getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(long divisionId) {
		this.divisionId = divisionId;
	}
	
	@Column(name = "created_date", nullable = true)
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nik=" + nik + ", name=" + name + ", type=" + type
				+ ", lastPosition=" + lastPosition + ", positionId=" + positionId + ", divisionId=" + divisionId + ", createdDate=" + createdDate + "]";
	}
	
}

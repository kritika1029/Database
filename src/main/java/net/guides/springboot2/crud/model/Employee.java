package net.guides.springboot2.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidates")
public class Employee {

	private long id;
	private String time_date1;
	private String time_date2;
	private String tag;


	public Employee() {

	}

	public Employee(String time_date1 , String time_date2 , String tag) {
		this.time_date1 = time_date1;
		this.time_date2 = time_date2;
		this.tag = tag;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "time_date1", nullable = false)
	public String getTime_date1() {
		return time_date1;
	}
	public void setTime_date1(String time_date1) {
		this.time_date1 = time_date1;
	}

	@Column(name = "time_date2", nullable = false)
	public String getTime_date2() {
		return time_date2;
	}
	public void setTime_date2(String time_date2) {
		this.time_date2 = time_date2;
	}

	@Column(name = "tag", nullable = false)
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	/*@Override
	public String toString() {
		return "Employee [id=" + id + ", time_date1=" + time_date1 + ", time_date2=" + time_date2 + ", tag=" + tag
				+ "]";
	}*/

}

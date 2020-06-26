package net.guides.springboot2.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
public class Candidate {
    private long id;
    private String date1;
    private String tag;
    private String unique_id;
    private String time;


    public Candidate() {

    }

    public Candidate(long id, String date1 , String tag, String unique_id, String time) {
    	 this.id=id;
        this.date1 = date1;
        this.tag = tag;       
        this.unique_id=unique_id;
        this.time=time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "date1", nullable = false)
    public String getdate1() {
        System.out.println("Done 1");
        return date1;
    }
    
    public void setdate1(String date1) {
        System.out.println("Done 1 - ");
        this.date1 = date1;
    }


    @Column(name = "tag", nullable = false)
    public String getTag() {
        System.out.println("Done 2");
        return tag ;
    }
    public void setTag(String tag) {
        System.out.println("Done 2 - ");
        this.tag = tag;
    }
    
    @Column(name="unique_id",nullable = false)
	public String getUniqueId() {
    	System.out.println("Done 3");
		return unique_id;
	}

	public void setUniqueId(String unique_id) {
		System.out.println("Done 3-");
		this.unique_id = unique_id;
	}
	 @Column(name="time",nullable = false)
	public String getTime() {
		 System.out.println("Done 4");
		return time;
	}

	public void setTime(String time) {
		System.out.println("Done 4-");
		this.time = time;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", date1=" + date1 + ", tag=" + tag+", unique_id="+ unique_id+
				", time="+ time + "]";
	}

	

}

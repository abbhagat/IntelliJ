package javaa.mykong;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private String name;
	private Integer id;
	private Date dob;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    
	public Employee(String name, Integer id, Date dob) {
		this.name = name;
		this.id = id;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String toString() {
		return this.name + " " + this.id + "\t" + sdf.format(this.dob);
	}
}
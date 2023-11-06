package bw.pharma.patientService.model;

public class Patient {
	int id; 
	String firstname, 
	lastname, 
	age;
	
	public Patient() {

	}

	public Patient(String firstname, String lastname, String age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	

}
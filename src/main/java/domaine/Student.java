package domaine;

import java.util.Date;

public class Student extends Personne {
	
	private Course cours;
	

	public Student(String firstName, String lastName, String mail, String address, String phone, Date dob) {
		super(firstName, lastName, mail, address, phone, dob);
	}

	public Student(String firstName, String lastName, String mail, String address, String phone, Date dob, Course cours) {
		super(firstName, lastName, mail, address, phone, dob);
		this.cours = cours;
	}

	public Student() {
		super();
	}

	public Course getCours() {
		return cours;
	}

	public void setCours(Course cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Etudiant [cours=" + cours + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getMail()=" + getMail() + ", getAddress()=" + getAddress()
				+ ", getPhone()=" + getPhone() + ", getDob()=" + getDob() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}

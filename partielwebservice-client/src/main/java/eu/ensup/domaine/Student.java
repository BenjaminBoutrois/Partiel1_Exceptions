package eu.ensup.domaine;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student extends Personne
{
	private Set<Course> courses = new HashSet<Course>();

	public Student(String firstName, String lastName, String mail, String address, String phone, Date dob)
	{
		super(firstName, lastName, mail, address, phone, dob);
	}

	public Student(String firstName, String lastName, String mail, String address, String phone, Date dob,
			Set<Course> courses)
	{
		super(firstName, lastName, mail, address, phone, dob);
		this.courses = courses;
	}

	public Student()
	{
		super();
	}

	public Set<Course> getCourses()
	{
		return courses;
	}

	public void setCourses(Set<Course> courses)
	{
		this.courses = courses;
	}

	@Override
	public String toString()
	{
		return "Etudiant [cours=" + courses + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getMail()=" + getMail() + ", getAddress()=" + getAddress()
				+ ", getPhone()=" + getPhone() + ", getDob()=" + getDob() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}

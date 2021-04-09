package eu.ensup.partielspringbootweb.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe métier représentant un étudiant .
 * 
 *
 */
@Entity
@DiscriminatorValue("STUDENT")
@JsonIgnoreProperties(value =
{ "courses" })
public class Student extends Personne
{
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Course> courses = new HashSet<Course>();

	public Student()
	{
		super();
	}

	public Student(Long id, String firstName, String lastName, String mail, String address, String phone, Date dob)
	{
		super(id, firstName, lastName, mail, address, phone, dob);
	}

	public Set<Course> getCourses()
	{
		return courses;
	}

	public void setCourses(Set<Course> courses)
	{
		this.courses = courses;
	}
}

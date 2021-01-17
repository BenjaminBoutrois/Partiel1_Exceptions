package eu.ensup.partielspringbootweb.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Classe métier représentant un étudiant.
 * @author 33651
 *
 */
@Entity
@DiscriminatorValue("STUDENT")
@JsonIgnoreProperties(value = {"courses"})
public class Student extends Personne
{
	
	/*
	 * private String firstName; private String lastName; private String
	 * mailAddress; private String address; private String numberPhone; private
	 * String birthDate;
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Course> courses =  new HashSet<Course>();

	public Student()
	{
		super();
		
	}
	
	public Student(Long id, String firstName, String lastName, String mail, String address, String phone, Date dob) {
		super(id, firstName, lastName, mail, address, phone, dob);
	}



	public Set<Course> getCourses() {
		return courses;
	}



	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
	
}

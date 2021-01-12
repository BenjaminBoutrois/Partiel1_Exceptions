package eu.ensup.partielspringbootweb.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Classe métier représentant un étudiant.
 * @author 33651
 *
 */
@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Personne
{
	
	/*
	 * private String firstName; private String lastName; private String
	 * mailAddress; private String address; private String numberPhone; private
	 * String birthDate;
	 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	Collection<Course> courses;

	public Student()
	{
		super();
	}

	
}

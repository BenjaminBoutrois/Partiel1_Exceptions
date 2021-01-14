package eu.ensup.partielspringbootweb.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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


/**
 * Classe métier représentant un étudiant.
 * @author 33651
 *
 */
@Entity
@NamedEntityGraph(name = "Student.courses",
attributeNodes = @NamedAttributeNode("courses")
)
@DiscriminatorValue("STUDENT")
public class Student extends Personne
{
	
	/*
	 * private String firstName; private String lastName; private String
	 * mailAddress; private String address; private String numberPhone; private
	 * String birthDate;
	 */
	@ManyToMany(mappedBy = "students")
	
	List<Course> courses;

	public Student()
	{
		super();
		
	}
	
	public Student(String first_name, String last_name, String mail, String address, String phone, Date dob) {
		super(first_name, last_name, mail, address, phone, dob);
	}

	
}

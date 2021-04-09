package eu.ensup.partielspringbootweb.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Class Personne qui contient les attributs a heriter dans les classes filles
 * 
 * @author fatim
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Strategie de creation d'une table unique pour tout
														// enregistrement de type personne et les classes filles
@DiscriminatorColumn(name = "TYPE_PERSONNE")
@DiscriminatorValue("PERSONNE")
public class Personne
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String mail;
	private String address;
	private String phone;
	private Date dob;

	public Personne(String firstName, String lastName, String mail, String address, String phone, Date dob)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
	}

	public Personne()
	{
	}

	public Personne(Long id, String firstName, String lastName, String mail, String address, String phone, Date dob)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}
}

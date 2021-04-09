package eu.ensup.partielspringbootweb.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe métier représentant un utilisateur.
 * 
 * @author 33651
 *
 */
@Entity
@DiscriminatorValue("USER")
public class User extends Personne
{
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	private String profil;

	public User()
	{
		super();
	}

	public User(String login, String password)
	{
		this.login = login;
		this.password = password;
	}

	public User(Long id, String login, String password)
	{
		this.login = login;
		this.password = password;
		this.setId(id);
	}

	public User(String login, String password, String profil)
	{
		super();
		this.login = login;
		this.password = password;
		this.profil = profil;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getProfil()
	{
		return profil;
	}

	public void setProfil(String profil)
	{
		this.profil = profil;
	}

	@Override
	public String toString()
	{
		return "User [ login=" + login + ", password=" + password + ", profil=" + profil + "]";
	}
}

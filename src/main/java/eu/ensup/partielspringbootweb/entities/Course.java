package eu.ensup.partielspringbootweb.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Classe métier représentant un cours.
 * 
 * @author 33651
 *
 */
@Entity
public class Course
{
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCourse;
	private String themeCourse;
	private int numberHours;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				
				joinColumns = @JoinColumn(name = "idCourse"),
				inverseJoinColumns =  @JoinColumn(name = "id")
			)
	private Set<Student> students = new HashSet<Student>();
	public Course()
	{
		super();
	}

	public Course(String themeCourse, int numberHours)
	{
		super();
		this.themeCourse = themeCourse;
		this.numberHours = numberHours;
	}
	

	


	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getThemeCourse()
	{
		return themeCourse;
	}

	public void setThemeCourse(String themeCourse)
	{
		this.themeCourse = themeCourse;
	}

	public int getNumberHours()
	{
		return numberHours;
	}

	public void setNumberHours(int numberHours)
	{
		this.numberHours = numberHours;
	}

	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString()
	{
		return "Course [themeCourse=" + themeCourse + ", numberHours=" + numberHours + "]";
	}
	
	
}

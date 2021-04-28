package eu.ensup.domaine;

import java.util.HashSet;
import java.util.Set;

public class Course
{
	private Long idCourse;
	private String themeCourse;
	private int numberHours;
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

	public Long getIdCourse()
	{
		return idCourse;
	}

	public void setIdCourse(Long id)
	{
		idCourse = id;
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

	public Set<Student> getStudents()
	{
		return students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}
}

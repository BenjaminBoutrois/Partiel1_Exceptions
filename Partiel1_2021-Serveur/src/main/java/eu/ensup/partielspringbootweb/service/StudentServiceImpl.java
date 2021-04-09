package eu.ensup.partielspringbootweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService
{
	@Autowired
	private StudentRepository studentRepo;

	/**
	 * @param studentRepo
	 */
	public StudentServiceImpl(StudentRepository studentRepo)
	{
		this.studentRepo = studentRepo;
	}

	/**
	 * Methode de creation d'etudiant renvoi l'etudiant créer
	 */
	@Override
	public Student createStudent(Student student)
	{
		return studentRepo.save(student);
	}

	/**
	 * Mthode de recherche d'etudiant par son id
	 * 
	 * @param prend en parametre id de type Long
	 * @return renvoi l'etudiant trouver
	 */
	@Override
	public Student getStudent(Long id) throws ResourceNotFoundException
	{
		Student stu = null;
		Optional<Student> stuFound = studentRepo.findById(id);
		
		if (stuFound.isPresent())
		{
			stu = stuFound.get();
		}

		return stu;
	}

	/**
	 * Methode de recherche d'etudiant par son email
	 * 
	 * @param prend en parametre un mail de type String
	 * @return renvoi l'etudiant trouvé
	 */
	@Override
	public Student getStudentByMail(String mail)
	{
		return studentRepo.findByMail(mail);
	}

	/**
	 * Methode renvoi la liste de tous les etudiants
	 */
	@Override
	public List<Student> getAllStudents()
	{
		return (List<Student>) studentRepo.findAll();
	}

	/**
	 * methode de suppression d'etudiant
	 * 
	 * @param id
	 * 
	 */
	@Override
	public void deleteStudent(Long id)
	{
		Optional<Student> studDel = studentRepo.findById(id);
		
		if (studDel.isPresent())
		{
			studentRepo.delete(studDel.get());
		}
	}

	/**
	 * Methode de mise a jour des informations des etudiants
	 * 
	 * @param etudiant
	 * @return renvoi l'etudiant
	 */
	@Override
	public Student updateStudent(Student student)
	{
		return studentRepo.save(student);
	}

	/**
	 * Methode de recherche d'etudiant par son prenom et nom
	 * 
	 * @param firstName
	 * @param lastName
	 * @return renvoi une liste d'etudiant
	 */

	@Override
	public List<Student> searchStudent(String firstName, String lastName)
	{
		return (List<Student>) studentRepo.findAllByFirstNameAndLastName(firstName, lastName);
	}
}

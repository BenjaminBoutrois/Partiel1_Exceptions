package eu.ensup.partielspringbootweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	

	/**
	 * @param studentRepo
	 */
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public void createStudent(Student student) {
		studentRepo.save(student);
		
	}

	@Override
	public Student getStudent(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}

	@Override
	public Student getStudentByMail(String mail) {
		return studentRepo.findByMail(mail)
				;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		Student studDel = studentRepo.findById(id).get();
		studentRepo.delete(studDel);
		
	}

	@Override
	public void updateStudent(Long id ,Student student) {
		
		Student studentFound = studentRepo.findById(id).get();
		studentFound.setAddress(student.getAddress());
		studentFound.setDob(student.getDob());
		studentFound.setFirstName(student.getFirstName());
		studentFound.setLastName(student.getLastName());
		studentFound.setMail(student.getMail());
		studentFound.setPhone(student.getPhone());
		studentRepo.save(studentFound);

		
	}

	@Override
	public List<Student> searchStudent(String firstName, String lastName) {

		return (List<Student>) studentRepo.findAllByFirstNameAndLastName(firstName, lastName);
	}

}

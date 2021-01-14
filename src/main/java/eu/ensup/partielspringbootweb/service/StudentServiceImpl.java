package eu.ensup.partielspringbootweb.service;

import java.util.List;
import java.util.Optional;

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
	public Student createStudent(Student student) {
		return studentRepo.save(student);
		
	}

	@Override
	public Student getStudent(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Student stu = null;
		Optional<Student> stuFound = studentRepo.findById(id);
		if(stuFound.isPresent()) {
			stu = stuFound.get();
		}
		
			return stu;

		
		
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
		Optional<Student>  studDel = studentRepo.findById(id);
		if(studDel.isPresent()) {
			studentRepo.delete(studDel.get());
		}
		
		
	}

	@Override
	public Student updateStudent(Long id ,Student student) {
		Student stu = null;
		Optional<Student> studentFound  = studentRepo.findById(id);
		if(studentFound.isPresent()) {
			stu = studentFound.get();
			stu.setAddress(student.getAddress());
			stu.setDob(student.getDob());
			stu.setFirstName(student.getFirstName());
			stu.setLastName(student.getLastName());
			stu.setMail(student.getMail());
			stu.setPhone(student.getPhone());
			
			}
		return studentRepo.save(stu);
		
		
		
	}

	@Override
	public List<Student> searchStudent(String firstName, String lastName) {

		return (List<Student>) studentRepo.findAllByFirstNameAndLastName(firstName, lastName);
	}

}

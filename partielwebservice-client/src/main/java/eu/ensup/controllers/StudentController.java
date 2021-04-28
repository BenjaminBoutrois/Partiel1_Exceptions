package eu.ensup.controllers;

import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eu.ensup.domaine.Course;
import eu.ensup.domaine.Student;
import eu.ensup.domaine.User;
import eu.ensup.service.ICourseService;
import eu.ensup.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController
{
	@Autowired
	private IStudentService studentService;

	@Autowired
	private ICourseService courseService;

	@RequestMapping("/list")
	public String listStudent(Model model)
	{
		model.addAttribute("message", null);

		List<Student> students = studentService.getListStudent();

		if (students != null)
		{
			model.addAttribute("students", students);
		}

		return "etudiantsListe";
	}

	@GetMapping("/create")
	public String createStudent(Model model)
	{
		model.addAttribute("message", null);

		return "etudiantCreer";
	}

	@PostMapping("/save")
	public String saveStudent(@Validated @ModelAttribute Student student, Model model)
	{
		String pageRedirect = "etudiantCreer";

		model.addAttribute("student", null);
		User user = (User) model.getAttribute("user");

		Response responseFromService = studentService.createStudent(student);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			model.addAttribute("message", "Elément enregistré avec succès");
		else
			model.addAttribute("error", "Un problème est survenu. Veuillez réessayer.");

		model.addAttribute("students", studentService.getListStudent());

		if (user.getProfil().equalsIgnoreCase("directeur"))
			pageRedirect = "etudiantsListe";
		else
			pageRedirect = "etudiantCreer";

		return pageRedirect;
	}

	@GetMapping("/view")
	public String viewStudent(@RequestParam(name = "id", required = false) Long id, Model model)
	{
		model.addAttribute("student", studentService.getStudentById(id));
		
		return "etudiantVoir";
	}

	@GetMapping("/edit")
	public String editStudent(@RequestParam(name = "id", required = false) Long id, Model model)
	{
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);

		return "etudiantModifier";
	}

	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable(value = "id") Long id, @RequestBody Student student, Model model)
	{
		studentService.updateStudent(id, student);
		model.addAttribute("student", student);
		return "etudiantsListe";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam(name = "id", required = false) Long id, Model model)
	{
		model.addAttribute("student", null);

		Response responseFromService = studentService.deleteStudent(id);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			model.addAttribute("message", "Elément supprimé avec succès");
		else
			model.addAttribute("error", "Un problème est survenu. Veuillez réessayer.");

		model.addAttribute("students", studentService.getListStudent());
		
		return "etudiantsListe";
	}

	@GetMapping("/editCourses")
	public String editStudentCourses(@RequestParam(name = "id", required = false) Long id, Model model)
	{
		model.addAttribute("message", null);

		Student student = studentService.getStudentById(id);
		List<Course> listCours = courseService.getAllCourses();

		model.addAttribute("student", student);
		model.addAttribute("courses", listCours);

		return "etudiantCours";
	}

	@PostMapping("/addStudentCourse")
	public String editStudentCourses(@ModelAttribute(name = "studentId") Long studentId,
			@ModelAttribute(name = "courseId") Long courseId, Model model)
	{
		Student student = studentService.getStudentById(studentId);

		Set<Course> studentCourses = student.getCourses();
		Course currentCourse = courseService.getCourseById(courseId);

		if (!studentCourses.contains(currentCourse))
			studentCourses.add(currentCourse);

		Response responseFromService = studentService.updateStudent(studentId, student);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			model.addAttribute("message", "Elément modifié avec succès");
		else
			model.addAttribute("error", "Un problème est survenu. Veuillez réessayer.");

		return "etudiantsListe";
	}

	@PostMapping("/searchStudent")
	public String searchStudent(@ModelAttribute(name = "firstNameR") String firstName,
			@ModelAttribute(name = "lastNameR") String lastName, Model model)
	{
		model.addAttribute("student", null);

		model.addAttribute("students", studentService.getStudentByFirstAndLastName(firstName, lastName));
		
		return "etudiantsListe";
	}
}

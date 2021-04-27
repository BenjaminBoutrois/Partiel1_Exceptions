package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domaine.Course;
import domaine.Student;
import service.CoursServiceClient;
import service.ICoursServiceClient;
import service.IStudentServiceClient;
import service.StudentServiceClient;

@Controller
@RequestMapping("/EtudiantCours")
public class EtudiantCoursController
{
	private IStudentServiceClient studentService;
	private ICoursServiceClient courseService;
	private RequestDispatcher dispatcher = null;

	public EtudiantCoursController()
	{
		super();
		studentService = new StudentServiceClient();
		courseService = new CoursServiceClient();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		methode(request, response);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String object = request.getParameter("id");
		Long id = Long.valueOf(object);

		String course = request.getParameter("listeCours");
		Long idCourse = Long.valueOf(course);
		Student student = studentService.getStudentById(id);

		HttpSession session = request.getSession();

		student.setCourses(courseService.getCoursById(idCourse));

		System.out.println(course);

		Response responseFromService = studentService.updateStudent(id, student);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément modifié avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}

	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.setAttribute("message", null);

		String object = request.getParameter("id");
		Long id = Long.valueOf(object);

		Student student = studentService.getStudentById(id);
		List<Course> listCours = courseService.getAllCours();

		dispatcher = request.getRequestDispatcher("etudiantCours.jsp");

		session.setAttribute("student", student);
		session.setAttribute("courses", listCours);

		dispatcher.forward(request, response);
	}
}

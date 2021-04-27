package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domaine.Student;
import domaine.User;
import service.CoursServiceClient;
import service.ICoursServiceClient;
import service.IStudentServiceClient;
import service.StudentServiceClient;

@Controller
@RequestMapping("AjoutEtudiant")
public class AjoutEtudiantController
{
	private IStudentServiceClient studentService;
	private RequestDispatcher dispatcher = null;
	private ICoursServiceClient courseService;
	private User user = null;

	public AjoutEtudiantController()
	{
		studentService = new StudentServiceClient();
		courseService = new CoursServiceClient();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		session.setAttribute("message", null);
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
		dispatcher.forward(request, response);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Student student = new Student();

		try
		{
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			student.setMail(request.getParameter("mailAdresse"));
			student.setAddress(request.getParameter("adress"));
			student.setPhone(request.getParameter("numberPhone"));
			student.setDob(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateOfBirth")));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");

		Response responseFromService = studentService.createStudent(student);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément enregistré avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		session.setAttribute("students", studentService.getListStudent());
		session.setAttribute("courses", courseService.getAllCours());

		if (user.getProfil().equalsIgnoreCase("directeur"))
			dispatcher = request.getRequestDispatcher("etudiant.jsp");
		else
			dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");

		dispatcher.forward(request, response);
	}
}

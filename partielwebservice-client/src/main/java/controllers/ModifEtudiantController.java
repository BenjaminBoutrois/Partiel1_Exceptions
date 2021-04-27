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
import service.IStudentServiceClient;
import service.StudentServiceClient;

@Controller
@RequestMapping("ModifEtudiant")
public class ModifEtudiantController
{
	private IStudentServiceClient studentService;
	private RequestDispatcher dispatcher = null;

	public ModifEtudiantController()
	{
		studentService = new StudentServiceClient();
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

		Long idEtudiant = Long.valueOf(request.getParameter("id"));

		HttpSession session = request.getSession();
		session.setAttribute("student", null);

		Response responseFromService = studentService.updateStudent(idEtudiant, student);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément modifié avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		session.setAttribute("student", null);
		session.setAttribute("students", studentService.getListStudent());

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
}

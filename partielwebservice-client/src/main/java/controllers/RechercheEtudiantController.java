package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.IStudentServiceClient;
import service.StudentServiceClient;

@Controller
@RequestMapping("/RechercheEtudiant")
public class RechercheEtudiantController
{
	private IStudentServiceClient studentService;

	public RechercheEtudiantController()
	{
		super();
		studentService = new StudentServiceClient();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		doPost(request, response);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		session.setAttribute("student", null);

		session.setAttribute("students", studentService.getStudentByFirstAndLastName(request.getParameter("firstNameR"),
				request.getParameter("lastNameR")));

		RequestDispatcher dispatcher = null;

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
}

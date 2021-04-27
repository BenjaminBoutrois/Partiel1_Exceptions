package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.IStudentServiceClient;
import service.StudentServiceClient;

@Controller
@RequestMapping("SupprimerEtudiant")
public class SupprimerEtudiantController
{
	private IStudentServiceClient studentService;
	private RequestDispatcher dispatcher = null;
	
	public SupprimerEtudiantController()
	{
		studentService = new StudentServiceClient();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		session.setAttribute("message", null);

		methode(request, response);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
	}

	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();

		String object = request.getParameter("id");
		int id = Integer.valueOf(object);

		session.setAttribute("student", null);

		Response responseFromService = studentService.deleteStudent(id);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément supprimé avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		session.setAttribute("students", studentService.getListStudent());

		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}
}

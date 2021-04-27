package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.IStudentServiceClient;
import service.StudentServiceClient;

@Controller
@RequestMapping("/ViewEtudiant")
public class ViewEtudiantController
{
	private IStudentServiceClient studentService;
	private RequestDispatcher dispatcher = null;

	public ViewEtudiantController()
	{
		studentService = new StudentServiceClient();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
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
		Long id = Long.valueOf(object);

		dispatcher = request.getRequestDispatcher("etudiantView.jsp");
		session.setAttribute("student", studentService.getStudentById(id));

		dispatcher = request.getRequestDispatcher("etudiantView.jsp");
		dispatcher.forward(request, response);
	}
}

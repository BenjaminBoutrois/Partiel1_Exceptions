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

import service.CoursServiceClient;
import service.ICoursServiceClient;

@Controller
@RequestMapping("SupprimerCours")
public class SupprimerCoursController
{
	private RequestDispatcher dispatcher = null;
	private ICoursServiceClient courseService;

	public SupprimerCoursController()
	{
		courseService = new CoursServiceClient();
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
		doGet(request, response);
	}

	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();

		Long id = Long.valueOf(request.getParameter("id"));

		session.setAttribute("cours", null);

		Response responseFromService = courseService.deleteCours(id);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément supprimé avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		session.setAttribute("courses", courseService.getAllCours());
		dispatcher = request.getRequestDispatcher("cours.jsp");
		dispatcher.forward(request, response);
	}
}

package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domaine.Course;
import service.CoursServiceClient;
import service.ICoursServiceClient;

@Controller
@RequestMapping("ModifCours")
public class ModifCoursController
{
	private ICoursServiceClient coursService;
	private RequestDispatcher dispatcher = null;

	public ModifCoursController()
	{
		coursService = new CoursServiceClient();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		session.setAttribute("message", null);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Course cours = new Course(request.getParameter("courseTheme"),
				Integer.valueOf(request.getParameter("courseTime")));
		Long idCours = Long.valueOf(request.getParameter("id"));

		HttpSession session = request.getSession();
		session.setAttribute("cours", null);

		Response responseFromService = coursService.updateCours(idCours, cours);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément modifié avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		session.setAttribute("cours", null);
		session.setAttribute("courses", coursService.getAllCours());

		dispatcher = request.getRequestDispatcher("cours.jsp");
		dispatcher.forward(request, response);
	}
}

package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.CoursServiceConfig;
import domaine.Course;
import service.ICoursServiceClient;

@Controller
@RequestMapping("/AjoutCours")
public class AjoutCoursController
{
	private RequestDispatcher dispatcher = null;
	private ICoursServiceClient courseService;
	
	public AjoutCoursController()
	{
		courseService = new CourseService();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		session.setAttribute("message", null);
		dispatcher = request.getRequestDispatcher("coursAjout.jsp");
		dispatcher.forward(request, response);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int nbHeure = Integer.valueOf(request.getParameter("courseTime"));
		Course cours = new Course(request.getParameter("courseTheme"), nbHeure);
		
		HttpSession session = request.getSession();
		// session.setAttribute("cours", null);
		// user = (User) session.getAttribute("user");

		System.out.println(cours.getNumberHours());

		Response responseFromService = courseService.createCours(cours);
		
		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément enregistré avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		session.setAttribute("courses", courseService.getAllCours());

		dispatcher = request.getRequestDispatcher("cours.jsp");
		dispatcher.forward(request, response);
	}
}

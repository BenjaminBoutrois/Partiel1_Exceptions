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

import domaine.User;
import exceptions.UserNotFoundException;
import service.CoursServiceClient;
import service.ICoursServiceClient;
import service.IStudentServiceClient;
import service.IUserServiceClient;
import service.StudentServiceClient;
import service.UserServiceClient;

@Controller
@RequestMapping("/Connexion")
public class ConnexionController
{
	private IUserServiceClient userService;
	private IStudentServiceClient studentService;
	private ICoursServiceClient courseService;
	private RequestDispatcher dispatcher = null;

	public ConnexionController()
	{
		userService = new UserServiceClient();
		courseService = new CoursServiceClient();
		studentService = new StudentServiceClient();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		session.removeAttribute("error");
		dispatcher = request.getRequestDispatcher("index.jsp");
	}

	@RequestMapping(method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		session.removeAttribute("error");

		methode(request, response);
	}
	
	public void methode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException
	{
		HttpSession session = request.getSession();

		try
		{
			User user = new User();
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));

			System.out.println(user.getLogin() + user.getPassword());

			User userRetour = userService.login(user);

			System.out.println(userRetour.toString());

			if (userRetour != null && userRetour.getLogin().equalsIgnoreCase(request.getParameter("login"))
					&& userRetour.getPassword().equalsIgnoreCase(request.getParameter("password")))
			{

				dispatcher = request.getRequestDispatcher("home.jsp");
				String profil;
				if (userRetour.getProfil().equalsIgnoreCase("D"))
				{
					profil = "Directeur";
				}
				else
				{
					profil = "Responsable";
				}
				session.setAttribute("user", userRetour);
				session.setAttribute("profil", profil);
				session.setAttribute("students", studentService.getListStudent());
				session.setAttribute("courses", courseService.getAllCours());

			}
			else
			{
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
		}
		catch (UserNotFoundException e)
		{
			session.setAttribute("error", e.getMessage());
			dispatcher = request.getRequestDispatcher("index.jsp");
		}

		dispatcher.forward(request, response);
	}
}

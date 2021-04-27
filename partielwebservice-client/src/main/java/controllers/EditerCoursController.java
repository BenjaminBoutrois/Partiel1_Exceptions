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

import service.CoursServiceClient;
import service.ICoursServiceClient;

@Controller
@RequestMapping("EditerCours")
public class EditerCoursController
{
	private ICoursServiceClient coursService;
	private RequestDispatcher dispatcher = null;

	public EditerCoursController()
	{
		coursService = new CoursServiceClient();
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

		dispatcher = request.getRequestDispatcher("coursModif.jsp");

		session.setAttribute("cours", coursService.getCoursById(id));

		dispatcher.forward(request, response);
	}
}

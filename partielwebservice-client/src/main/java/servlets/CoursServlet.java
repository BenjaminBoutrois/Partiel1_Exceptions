package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CoursServiceClient;
import service.ICoursServiceClient;

/**
 * Servlet implementation class CoursServlet
 */
public class CoursServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ICoursServiceClient courseService;
	private RequestDispatcher dispatcher = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoursServlet()
	{
		courseService = new CoursServiceClient();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.setAttribute("message", null);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.setAttribute("message", null);

		session.setAttribute("courses", courseService.getAllCours());

		dispatcher = request.getRequestDispatcher("cours.jsp");
		dispatcher.forward(request, response);
	}
}

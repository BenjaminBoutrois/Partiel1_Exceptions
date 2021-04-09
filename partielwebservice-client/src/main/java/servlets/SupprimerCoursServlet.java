package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import service.CoursServiceClient;
import service.ICoursServiceClient;

/**
 * Servlet implementation class SupprimerCoursServlet
 */
public class SupprimerCoursServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher = null;
	private ICoursServiceClient courseService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerCoursServlet()
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

		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
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

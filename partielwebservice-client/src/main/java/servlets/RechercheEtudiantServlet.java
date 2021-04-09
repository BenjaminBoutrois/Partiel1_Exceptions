package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IStudentServiceClient;
import service.StudentServiceClient;

/**
 * Servlet implementation class RechercheEtudiantServlet
 */
public class RechercheEtudiantServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentServiceClient studentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheEtudiantServlet()
	{
		super();
		studentService = new StudentServiceClient();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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

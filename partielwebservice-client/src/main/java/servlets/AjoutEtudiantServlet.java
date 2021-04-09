package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import domaine.Student;
import domaine.User;
import service.CoursServiceClient;
import service.ICoursServiceClient;
import service.IStudentServiceClient;
import service.StudentServiceClient;

/**
 * Servlet implementation class AjoutEtudiantServlet
 */
//@WebServlet("/AjoutEtudiant")
public class AjoutEtudiantServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private IStudentServiceClient studentService;
	private RequestDispatcher dispatcher = null;
	private ICoursServiceClient courseService;
	private User user = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutEtudiantServlet()
	{
		studentService = new StudentServiceClient();
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
		dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Student student = new Student();

		try
		{
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			student.setMail(request.getParameter("mailAdresse"));
			student.setAddress(request.getParameter("adress"));
			student.setPhone(request.getParameter("numberPhone"));
			student.setDob(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateOfBirth")));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("student", null);
		user = (User) session.getAttribute("user");

		Response responseFromService = studentService.createStudent(student);

		if (responseFromService.getStatus() == 200 || responseFromService.getStatus() == 204)
			session.setAttribute("message", "Elément enregistré avec succès");
		else
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");

		session.setAttribute("students", studentService.getListStudent());
		session.setAttribute("courses", courseService.getAllCours());

		if (user.getProfil().equalsIgnoreCase("directeur"))
			dispatcher = request.getRequestDispatcher("etudiant.jsp");
		else
			dispatcher = request.getRequestDispatcher("etudiantAjout.jsp");

		dispatcher.forward(request, response);
	}
}

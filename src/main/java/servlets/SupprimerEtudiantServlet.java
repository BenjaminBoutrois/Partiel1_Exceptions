package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


import domaine.Student;
import domaine.User;
import service.IStudentServiceClient;
import service.StudentServiceClient;


/**
 * Servlet implementation class SupprimerEtudiantServlet
 */
public class SupprimerEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentServiceClient studentService;
//	private CoursService courseService;
	private RequestDispatcher dispatcher = null;
	private User user = null;
//	private IEtudiantDao etudiantDao = new EtudiantDao();

	/**
	 * Default constructor.
	 */
	public SupprimerEtudiantServlet() {
		studentService = new StudentServiceClient();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("message", null);
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		int id = Integer.valueOf(object);
		
		
//		session.setAttribute("courses", getAllCours());
		session.setAttribute("student", null);
		
		Response responseFromService = studentService.deleteStudent(id);
		if (responseFromService.getStatus()==200 || responseFromService.getStatus()==204) {
			session.setAttribute("message", "Elément supprimé avec succès");
		} else {
			session.setAttribute("message", "Un problème est survenu. Veuillez réessayer.");
		}
		
		
		session.setAttribute("students", studentService.getListStudent());
		dispatcher = request.getRequestDispatcher("etudiant.jsp");
		dispatcher.forward(request, response);
	}


//
//	private List<Cours> getAllCours() {
//
//		List<Cours> courses = Collections.emptyList();
//		try {
//
//			courses = courseService.getAllCours();
//		} catch (Exception e) {
//
//		}
//		return courses;
//	}

}

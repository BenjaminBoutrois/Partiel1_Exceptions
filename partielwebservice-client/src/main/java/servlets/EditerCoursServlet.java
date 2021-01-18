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
 * Servlet implementation class EditerCoursServlet
 */
public class EditerCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICoursServiceClient coursService;
	private RequestDispatcher dispatcher = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditerCoursServlet() {
    	coursService = new CoursServiceClient();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		methode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void methode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String object = request.getParameter("id");
		Long id = Long.valueOf(object);

		dispatcher = request.getRequestDispatcher("coursModif.jsp");

		session.setAttribute("cours", coursService.getCoursById(id));

		dispatcher.forward(request, response);
	}

}

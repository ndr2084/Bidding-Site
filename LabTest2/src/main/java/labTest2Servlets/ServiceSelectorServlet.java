package labTest2Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ServiceData;
import dbutils.*;


/**
 * Servlet implementation class Processor1
 */
@WebServlet("/ServiceSelectorServlet")
public class ServiceSelectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceSelectorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			// CREATE USER SESSION
			HttpSession session = request.getSession();
			
			// CREATE DBUTILS OBJECT 
			UserDAOImpl getUser = new UserDAOImpl();
			ServiceData user = new ServiceData(); 
			user = getUser.getUserByProfile(email, password);
			if (user == null) { 
				String target = "/NoSuchUser.jsp";
				request.getRequestDispatcher(target).forward(request, response);
			}
			
			
			
			
			// SET USER SESSION ATTRIBUTES
			session.setAttribute("firstName", user.getFirstName());
			session.setAttribute("lastName", user.getLastName());
			
			String target = "/ServiceSelectorPage.jsp";
			request.getRequestDispatcher(target).forward(request, response);
		} catch (Exception exp) {
			System.out.println(exp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

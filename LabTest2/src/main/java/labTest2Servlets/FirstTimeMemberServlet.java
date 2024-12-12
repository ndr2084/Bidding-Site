package labTest2Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbutils.UserDAOImpl;

/**
 * Servlet implementation class FirstTimeMemberServlet
 */
@WebServlet("/FirstTimeMemberServlet")
public class FirstTimeMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstTimeMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			String email = request.getParameter("email"); 
			
			// CREATE USER SESSION
			HttpSession session = request.getSession();
			
			// CREATE DBUTILS OBJECT 
			UserDAOImpl user = new UserDAOImpl(); 
			
			
			// SET USER SESSION ATTRIBUTES
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			
			// GET AGE FROM DB 
			user.addUser(firstName, lastName, email, password);	
			String target = "/ServiceSelectorPage.jsp";
			request.getRequestDispatcher(target).forward(request, response);
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

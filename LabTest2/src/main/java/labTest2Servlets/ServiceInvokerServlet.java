package labTest2Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ServiceData;
import labTest2Services.IServiceInvoker;
import labTest2Services.ServiceInvokerFactory;

/**
 * Servlet implementation class Processor2
 */
@WebServlet("/ServiceInvokerServlet")
public class ServiceInvokerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceInvokerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checked = request.getParameter("checked");
		HttpSession session = request.getSession(false);
		
		ServiceInvokerFactory aSIFactory = new ServiceInvokerFactory();
		
		//Polymorphism is happening -- instantiate superclass, then let appropriate subclass handle argument
		IServiceInvoker serviceInvoker = aSIFactory.createService(checked);
		
		
		String dataForField1 = (String) session.getAttribute("firstName");
		String dataForField2 = (String) session.getAttribute("lastName");
		ServiceData data = new ServiceData();
		data.setField1(dataForField1);
		data.setField2(dataForField2);
		
		/*result will have either: 
		 * [1] "Live long and prosper", or
		 * [2] "Many happy returns to come"
		 */
		
		String result = serviceInvoker.perform(data); 
		session.setAttribute("serviceResult", result);

		
		String target = "/ServiceInvokerPage.jsp";
		request.getRequestDispatcher(target).forward(request, response);
		
		//response.getWriter().append("The Selected Service: "+ result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

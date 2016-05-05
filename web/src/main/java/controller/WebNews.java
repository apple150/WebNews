/**
 * 	    Control Work 			17.02.2015
 *
 * 	    Main WebNews Servlet
 *
 *      Copyright	Sergey Buglak
 *		e-mail:  	Apple150@mail.ru 
*/

package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.AddWrite;
import command.Command;
import command.ShowAllNews;
import command.ShowOneNews;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@WebServlet("/WebNews")
public class WebNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger myLog = LogManager.getLogger(WebNews.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		config = getServletConfig();
		String CurDir = config.getInitParameter("CurDir");
	}
	
    /**
     * Default constructor
     */
    public WebNews() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=windows-1251");
		response.setCharacterEncoding("Cp1251");
		String email = request.getParameter("email");
		if (email == null) {
			myLog.error("E-MAIL login to site is NULL");
		} else {
			if (email.equals("")) {
				myLog.error("User does login with empty e-mail");
				response.sendRedirect("Login.html");
			} else {
				myLog.error("User has e-mail: " + email);
				HttpSession session = request.getSession();
				session.setAttribute("user", email);
				String getEmail = (String) session.getAttribute("user");
				myLog.error("USER e-mail that was reading from session is: " + getEmail);
			}
		}
				
		String operation = request.getParameter("operation");		
		Command com = null;
		if (operation == null) {
			com = new ShowAllNews();
		} else if(operation.equals("show")) {
			com = new ShowOneNews();
		} else if(operation.equals("add")) {
			com = new AddWrite();
		} 
		com.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
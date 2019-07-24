package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Employee;
import dataAccessObjects.UserDAO;
import dbControllers.UserController;

/**
 * Servlet implementation class Project1Servlet
 */
public class Project1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO uDao = new UserController();

    /**
     * Default constructor. 
     */
    public Project1Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String route = request.getParameter("route");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("\nEmployees: \n");
		Employee testUser = uDao.getUser(3);
		System.out.println(testUser);
		response.getWriter().append("From db, security question for user 1: " + testUser.getSecurityQ());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = "";
		String userName = "";
		String option = "";
		
		BufferedReader breader = request.getReader();
		String req = breader.readLine();
		String[] params = req.split("&");
		String[] keys = new String[3];
		String[] vals = new String[3];
		for (int i = 0; i < params.length; i++) {
			String[] temp = params[i].split("=");
			keys[i] = temp[0];
			vals[i] = temp[1];
		}
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals("name")) {
				userName = vals[i];
			}
			else if (keys[i].equals("password")) {
				password = vals[i];
			}
			else if (keys[i].equals("option")) {
				option = vals[i];
			}
		}
		
		if (option.equals("signup")) {		
			response.getWriter().append("Sorry, signUp has not been implemented yet");
		}
		else {
			Employee user = uDao.getUserByName(userName);
			if (password.equals(user.getpWord())) {
				response.getWriter().append("Sign in was successful!");
				HttpSession session = request.getSession();
				session.setAttribute("uName", user.getName());
				session.setAttribute("isLoggedIn", "true");
				session.setAttribute("id", user.getId());
//			forward to page depending on option
			} else {
				response.getWriter().append("Sign in was not successful, please try again");

			}
		}
	}

}

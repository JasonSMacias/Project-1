package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

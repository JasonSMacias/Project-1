package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;
import beans.ReimbRequest;
import dataAccessObjects.ReimbRequestDAO;
import dataAccessObjects.UserDAO;
import dbControllers.ReimbRequestController;
import dbControllers.UserController;
import service.SignupService;

/**
 * Servlet implementation class Project1Servlet
 */
public class Project1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO uDao = new UserController();
	private static ReimbRequestDAO rDao = new ReimbRequestController();

	/**
	 * Default constructor.
	 */
	public Project1Servlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("option");
		System.out.println(option);
		switch (option) {
		case "signup":
			System.out.println("switch working");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signupxyz.html");
			dispatcher.forward(request, response);
			break;
		case "employee":
			RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher("/employeexyz.html");
			dispatcher2.forward(request, response);
			break;
		case "manager":
			RequestDispatcher dispatcher3 = getServletContext().getRequestDispatcher("/managerxyz.html");
			dispatcher3.forward(request, response);
			break;
		case "createuser":
			System.out.println("got to create user");
			String newName = request.getParameter("name");
			String newPassword = request.getParameter("password");
			String newSecurityQ = request.getParameter("securityq");
			String newSecurityA = request.getParameter("securitya");
			String newRole = request.getParameter("role");
			Employee newEmployee = SignupService.signupUser(newName, newPassword, newSecurityQ, newSecurityA, newRole);
			HttpSession session = request.getSession();
			session.setAttribute("uName", newEmployee.getName());
			session.setAttribute("isLoggedIn", "true");
			session.setAttribute("id", newEmployee.getId());
			System.out.println(session.getAttribute("uName") + " logged in");
			String role = newEmployee.isManager() == true ? "manager" : "employee";
			response.getWriter().append(role);
			break;
		case "getuser":
			HttpSession session2 = request.getSession(false);
			String usr = (String) session2.getAttribute("uName");
			System.out.println(usr);
			response.getWriter().append(usr);
			break;
		case "displaypending":
			HttpSession session3 = request.getSession(false);
			int id = (int) session3.getAttribute("id");
			List<ReimbRequest> requestList = rDao.viewRequestsByEmployee(id, "pending");
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(requestList.get(0));
			response.getWriter().append(jsonString);
			break;
		case "logout":
			HttpSession session4 = request.getSession(false);
			if (session4 != null) {
			    session4.invalidate();
			}

			break;
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("\nEmployees: \n");
//		Employee testUser = uDao.getUser(3);
//		System.out.println(testUser);
//		response.getWriter().append("From db, security question for user 1: " + testUser.getSecurityQ());
//		System.out.println("Get route hit");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = "";
		String userName = "";
		String option = "";
		String value = "";
		String description = "";
		String date = "";

		BufferedReader breader = request.getReader();
		String req = breader.readLine();
		// Checking for json strings
//		char ch1 = req.charAt(0);
		// Failed attempt at Jackson json parsing (date is a problem)
//		if (ch1 == '{') {
//			// parsing json file
//			ObjectMapper mapper = new ObjectMapper();
//			ReimbRequest incomingRequest = mapper.readValue(req, ReimbRequest.class);
//			System.out.println(incomingRequest.getDescription());
//		} else {

		String[] params = req.split("&");
		List<String> keys = new ArrayList<>();
		List<String> vals = new ArrayList<>();
		for (int i = 0; i < params.length; i++) {
			String[] temp = params[i].split("=");
			keys.add(i, temp[0]);
			vals.add(i, temp[1]);
		}
		for (int i = 0; i < keys.size(); i++) {
			if (keys.get(i).equals("name")) {
				userName = vals.get(i);
			} else if (keys.get(i).equals("password")) {
				password = vals.get(i);
			} else if (keys.get(i).equals("option")) {
				option = vals.get(i);
			} else if (keys.get(i).equals("value")) {
				value = vals.get(i);
			} else if (keys.get(i).equals("description")) {
				description = vals.get(i);
			} else if (keys.get(i).equals("date")) {
				date = vals.get(i);
			}
		}

		if (option.equals("signup")) {

			System.out.println("signup");

		} else if (option.equals("createuser")) {
			System.out.println("creating user");
		} else if (option.equals("addrequest")) {
			System.out.println("adding request");
			HttpSession session3 = request.getSession(false);
			int usr = (int) session3.getAttribute("id");
			ReimbRequest newReq = rDao.addNewRequest(usr, Double.parseDouble(value), description);
		} else {
			Employee user = uDao.getUserByName(userName);
			if (password.equals(user.getpWord())) {
//				response.getWriter().append("Sign in was successful!");
				HttpSession session = request.getSession();
				session.setAttribute("uName", user.getName());

				session.setAttribute("isLoggedIn", "true");
				session.setAttribute("id", user.getId());
				System.out.println(session.getAttribute("uName") + " logged in");
				String role = user.isManager() == true ? "manager" : "employee";
				response.getWriter().append(role);
//			forward to page depending on option
			} else {
//				response.getRequestDispatcher("/../../jmacias_project-1/");
				response.getWriter().append("failed");
			}
		}

	}

}

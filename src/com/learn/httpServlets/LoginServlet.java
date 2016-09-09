package com.learn.httpServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learn.dao.UserDAO;
import com.learn.dataaccess.DBUtil;
import com.learn.dto.User;

import java.sql.*;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// setting the content type
		System.out.println("Entering into login servlet");
		res.setContentType("text/html");

		// Get the form parameters
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		User user;

		// Validate user credentials
		boolean validUser = validateUser(userName, password);

		// create session if it is not existed., req.getSession() , will always
		// creates new session, but req.getSession(true) will not create new
		// session if there an existing session

		HttpSession session = req.getSession(true);

		// verify if user is already logged in, then forward request to userHome
		if (isUserAlreadyLoggedIn(session)) {
			req.getRequestDispatcher("userHome.jsp").forward(req, res);
		} else {

			// if user is valid, then get data from database and then forward
			// request to display user details page.
			if (validUser) {

				UserDAO userDAO = new UserDAO();

				user = userDAO.getUser(userName, password);

				if (user != null) {
					System.out.println(user.toString());

					// create a session and save userName in session
					session.setAttribute("userName", user.getUserName());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("lastName", user.getLastName());
					session.setAttribute("email", user.getEmail());
					session.setAttribute("city", user.getCity());
					session.setAttribute("state", user.getState());
					session.setAttribute("zip", user.getZip());
					session.setAttribute("address1", user.getAddress1());
					session.setAttribute("address2", user.getAddress2());

					req.getRequestDispatcher("userHome.jsp").forward(req, res);

				} else {
					req.setAttribute("error", "User not found, please check your credentials");
					req.getRequestDispatcher("login.jsp").forward(req, res);
				}

			} else {
				// If user is not valid, then forward request to login page with
				// error message
				req.setAttribute("error", "Please check your credentials");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		}
	}

	private boolean isUserAlreadyLoggedIn(HttpSession session) {
		boolean userLoggedIn = false;

		System.out.print("userName from session--->" + session.getAttribute("userName"));
		if (session.getAttribute("userName") != null) {
			userLoggedIn = true;
		}
		return userLoggedIn;
	}

	/*
	 * validateUser validates the userName and password values, it compares if
	 * they are empty or null
	 */
	private boolean validateUser(String userName, String password) {
		System.out.println("Validating user with user name-->" + userName);
		if (userName == null || userName.isEmpty()) {
			return false;
		} else if (password == null || password.isEmpty()) {
			return false;
		}
		return true;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Setting the content type
		res.setContentType("text/html");
		System.out.println("Entering into login servlet doGet");

		// see if session is valid, then get userName from session and get
		// userdetails from DB and
		// redirect to registration details:

		// we want to redirect this request to registration jsp
		res.sendRedirect("login.jsp");
	}

}

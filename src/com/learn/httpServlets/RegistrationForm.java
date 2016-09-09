package com.learn.httpServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.dao.UserDAO;
import com.learn.dataaccess.DBUtil;
import com.learn.dto.User;

@WebServlet(name="registrationServlet",urlPatterns="/register")
public class RegistrationForm extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//Setting the content type
		res.setContentType("text/html");
		
		//we want to redirect this request to registration jsp
		res.sendRedirect("registration.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		//setting the content type
		User user = new User();
		res.setContentType("text/html");
		
		//Save user information to database:
		
		user.setFirstName(req.getParameter("firstName"));
		user.setLastName(req.getParameter("lastName"));
		user.setUserName(req.getParameter("userName"));
		user.setEmail(req.getParameter("email"));
		user.setPhone(req.getParameter("phone"));
		user.setPassword(req.getParameter("password"));
		user.setAddress1(req.getParameter("address1"));
		user.setAddress2(req.getParameter("address2"));
		user.setCity(req.getParameter("city"));
		user.setState(req.getParameter("state"));
		user.setZip(Integer.parseInt(req.getParameter("zip")));

		try{
		//Save user into database	
		new UserDAO().createUser(user);
		
		req.setAttribute("firstName", user.getFirstName()); 
		req.setAttribute("lastName", user.getLastName());
		req.setAttribute("email", user.getEmail());
		req.setAttribute("phone", user.getPhone());
		req.setAttribute("address1", user.getAddress1());
		req.setAttribute("address2", user.getAddress2());
		req.setAttribute("city", user.getCity());
		req.setAttribute("state", user.getState());
		req.setAttribute("zip", user.getZip());
		
		req.getRequestDispatcher("RegistrationDetails.jsp").forward(req,res);
		}catch(Exception ex){
			req.setAttribute("error", "Unable to update user information");
			req.getRequestDispatcher("registration.jsp").forward(req,res);
		}
		// create insert statement with all user data
		
		
		
	}
	
}

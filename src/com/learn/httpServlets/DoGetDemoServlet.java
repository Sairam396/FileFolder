package com.learn.httpServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Read and print the default values from header
 * 
 *
 */

@WebServlet(urlPatterns = "/getHeaders", displayName = "Headers", name = "getHeaders")
public class DoGetDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		Enumeration<String> headers = req.getHeaderNames();
		while (headers.hasMoreElements()) {
			String name = headers.nextElement();
			Enumeration<String> values = req.getHeaders(name);
			if (values != null) {
				while (values.hasMoreElements()) {
					String value = values.nextElement();
					out.println("name:" + name + "," + "Value:" + value + "\n");
					
				}
			}
		}
	}
}

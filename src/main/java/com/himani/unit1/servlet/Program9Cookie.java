/**
 * Program # 9 - Write a Program which displays cookie id
 */
package com.himani.unit1.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Program9Cookie
 */
@WebServlet("/cookieExample")
public class Program9Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Program9Cookie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie ck[] = request.getCookies();
		if (ck != null) {
			response.getWriter().println("<html>Below Cookie already present:");
			for (int i = 0; i < ck.length; i++) {
				response.getWriter().println("<br>" + ck[i].getName() + " " + ck[i].getValue());// printing name and value
																								// of cookie
			}
			response.getWriter().println("</html>");
		}else {
			response.getWriter().append("No Cookie exist, so new Cookie Added ");
			Cookie newCookie = new Cookie("user", "HimaniSharma");// creating cookie object, 
			//space is not allowed in cookie values
			response.addCookie(newCookie);// adding cookie in the response
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

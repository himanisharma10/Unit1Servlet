/**
 * 
 */
package com.himani.unit1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Program19
 */
@WebServlet("/program19Servlet")
public class Program19 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Program19() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie newCookie = new Cookie("user1", "pwd1");
		response.addCookie(newCookie);// creating cookie object, 
		newCookie = new Cookie("user2", "pwd2");
		response.addCookie(newCookie);
		newCookie = new Cookie("user3", "pwd3");
		response.addCookie(newCookie);
		newCookie = new Cookie("user4", "pwd4");
		response.addCookie(newCookie);
		String htmlResponse = "<html><body>";

        htmlResponse += "<form name=\"loginForm\" method=\"post\" action=\"program19Servlet\">";      
        htmlResponse += "Username: <input type=\"text\" name=\"username\"/> <br/>"; 
        htmlResponse += "Password: <input type=\"password\" name=\"password\"/> <br/>";  
        htmlResponse += "<input type=\"submit\" value=\"Login\" /></form></body></html>";
        PrintWriter writer = response.getWriter();
        writer.println(htmlResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean loginSuccess = false;
        
        Cookie ck[] = request.getCookies();
		if (ck != null) {
			for (int i = 0; i < ck.length; i++) {
				if(ck[i].getName().equals(username) && ck[i].getValue().equals(password)) {
					loginSuccess = true;
				}
			}
			response.getWriter().println("</html>");
		}
		String htmlResponse = "<html><body>";
		if(loginSuccess) {
			htmlResponse += "<h2>Loging Success</h2>";
		}else {
			htmlResponse += "<h2>Loging Unseccessfull</h2>"; 
		}
		htmlResponse += "</body></html>";
		PrintWriter writer = response.getWriter();
        writer.println(htmlResponse);
	}

}

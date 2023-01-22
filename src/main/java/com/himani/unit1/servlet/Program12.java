/**
 * Program # 12 : Write a Program that takes three input as: User Name, User PAssword, 
 * and mobile number from html form and access these data by using servlet also display
 * these details on browser
 */
package com.himani.unit1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Program12
 */
@WebServlet("/program12Servlet")
public class Program12 extends HttpServlet {
	

    /**
     * Default constructor. 
     */
    public Program12() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
         
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("mobile: " + mobile);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
        htmlRespone += "Your password is: " + password + "</br>"; 
        htmlRespone += "Your mobile # is: " + mobile + "</h2>";  
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
	}

}

package main;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SimpleServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if the request post contains the username Smoothstack and the password April2021 then respond as correct
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		response.setContentType("text/html");
		if(user.equals("Smoothstack") && pass.equals("April2021") ) {
			response.getWriter().append("Welcome back!");
			System.out.println("Login successful");
		} else {
			response.getWriter().append("Invalid username or password");
			System.out.println("login failed");
		}
	}

}

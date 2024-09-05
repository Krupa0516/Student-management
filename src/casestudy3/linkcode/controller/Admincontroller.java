package casestudy3.linkcode.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import casestudy3.linkcode.model.Admin;
import casestudy3.linkcode.service.Registerimp;

/**
 * Servlet implementation class Admincontroller
 */
@WebServlet("/Admincontroller")
public class Admincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ADMIN_USERNAME =request.getParameter("ADMIN_USERNAME");
		String ADMIN_PASSWORD =request.getParameter("ADMIN_PASSWORD");
		Admin aobj=new Admin(ADMIN_USERNAME, ADMIN_PASSWORD);
		aobj.setADMIN_USERNAME("Krupa");
		aobj.setADMIN_PASSWORD("1614");
		Registerimp ad=new Registerimp();
		boolean b=ad.Adminlogin(aobj);
		
		 if (b) {
			 System.out.println("Login Successfully");
		      response.sendRedirect("Addcourse.jsp");
		    } 
		 
		 else{
			 System.out.println("Invalid");
			 response.sendRedirect("Admin.jsp");
		 }
		 
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

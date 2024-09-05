package casestudy3.linkcode.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import casestudy3.linkcode.model.Register;
import casestudy3.linkcode.service.Registerimp;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regno=request.getParameter("regno");
		String fname=request.getParameter("fname");
		String mobno=request.getParameter("mobno");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		
				
		Register register=new Register();
		List<Register>lst =new ArrayList<Register>();
		lst.add(register);
		
		Registerimp rdao= new Registerimp();
		int i=rdao.create(lst);
		
		if(i>0)
		{
			response.sendRedirect("loginController");
		}
		else
		{
			response.sendRedirect("Home.html");
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

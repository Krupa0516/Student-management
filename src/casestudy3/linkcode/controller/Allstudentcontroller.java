package casestudy3.linkcode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import casestudy3.linkcode.model.Register;
import casestudy3.linkcode.service.Registerimp;

/**
 * Servlet implementation class Allstudentcontroller
 */
@WebServlet("/Allstudentcontroller")
public class Allstudentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allstudentcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Registerimp rdao=new Registerimp();
		List<Register> lst= rdao.displayall();
		PrintWriter pw=response.getWriter();
		pw.print("<table>");
		for(Register r:lst){
			pw.print("<tr><td>"+r.getRegno()+"</td><td>"+r.getFname()+"</td><td>"+r.getMobno()+"</td><td>"+r.getUname()+"</td><td>");
		}
		pw.print("</table>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

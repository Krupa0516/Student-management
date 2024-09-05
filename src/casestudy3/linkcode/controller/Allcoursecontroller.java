package casestudy3.linkcode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import casestudy3.linkcode.model.Addcourse;
import casestudy3.linkcode.service.Registerimp;

/**
 * Servlet implementation class Allcoursecontroller
 */
@WebServlet("/Allcoursecontroller")
public class Allcoursecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allcoursecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Registerimp rdao=new Registerimp();
		List<Addcourse> aclst= rdao.displaycourse();
		PrintWriter pw=response.getWriter();
		pw.print("<table>");
		for(Addcourse ad:aclst){
			pw.print("<tr><td>"+ad.getCname()+"</td><td>"+ad.getDuration()+"</td><td>"+ad.getFees());
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

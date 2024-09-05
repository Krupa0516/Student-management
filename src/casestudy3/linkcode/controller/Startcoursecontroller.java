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
 * Servlet implementation class Startcoursecontroller
 */
@WebServlet("/Startcoursecontroller")
public class Startcoursecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Startcoursecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str=request.getParameter("cname");
		
		Registerimp rdao=new Registerimp();
		String cname=request.getParameter(str);
		List<Addcourse>aclst=rdao.search(cname);
		
		PrintWriter pw=response.getWriter();
		Addcourse ad=(Addcourse)aclst.get(0);
		pw.println(ad.getCname()+"\n"+ad.getDuration()+"\n"+ad.getFees());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

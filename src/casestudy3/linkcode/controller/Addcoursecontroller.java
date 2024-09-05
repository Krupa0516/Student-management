package casestudy3.linkcode.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import casestudy3.linkcode.model.Addcourse;
import casestudy3.linkcode.service.Registerimp;

/**
 * Servlet implementation class Addcoursecontroller
 */
@WebServlet("/Addcoursecontroller")
public class Addcoursecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcoursecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname=request.getParameter("cname");
		String duration=request.getParameter("duration");
		int fees=Integer.parseInt(request.getParameter("fees"));
		
		Addcourse acobj=new Addcourse() ;
		List<Addcourse>aclst=new ArrayList<Addcourse>();
		aclst.add(acobj);
		
		Registerimp rdao=new Registerimp();
		String str=rdao.addcourse(aclst);
		
		System.out.println("In Controller str is:"+str);
		HttpSession session=request.getSession();
		if(str.equals("Valid")){
			str="Course Added Successfully";
		}
		session.setAttribute("msg", str);
		response.sendRedirect("Addcourse.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

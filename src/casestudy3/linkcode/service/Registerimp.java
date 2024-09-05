package casestudy3.linkcode.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import casestudy3.linkcode.ds.DataSource;
import casestudy3.linkcode.model.Addcourse;
import casestudy3.linkcode.model.Admin;
import casestudy3.linkcode.model.Register;
import casestudy3.linkcode.model.login;


public class Registerimp implements Registerservice{

	private static final Object Krupa = null;
	DataSource dsa=new DataSource();
public boolean validateUser(login lobj){
		
		boolean b=false;
		Connection con=dsa.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Studentreg where uname=? and password=?");
			ps.setString(1, lobj.getUname());
			ps.setString(2, lobj.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				b=true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}


	@Override
	public int create(List<Register> lst) {
		Register reg=lst.get(0);
		int i=0;
		Connection con=dsa.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Studentreg values (?,?,?,?,?)");
			pstate.setInt(1, reg.getRegno());
			pstate.setString(2, reg.getFname());
			pstate.setString(3, reg.getMobno());
			pstate.setString(4, reg.getUname());
			pstate.setString(5, reg.getPassword());
			
			
			i=pstate.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;	
	}

	@Override
	public boolean Adminlogin(Admin aobj){
		
		 String ADMIN_USERNAME="Krupa";
		 String ADMIN_PASSWORD="1614";
		 boolean b=false;
		 
		 
		    if (ADMIN_USERNAME.equals(ADMIN_USERNAME) && ADMIN_PASSWORD.equals(ADMIN_PASSWORD)) {
		      b=true;
		    } 
		  
		    else{
		    	System.out.println("Incorrect");
		    }
		    return b;
		  }


	@Override
	public String addcourse(List<Addcourse> aclst) {
		
		Addcourse ac=aclst.get(0);
		int i=0;
		String str=null;
		Connection con=dsa.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Addcourse values (?,?,?)");
			pstate.setString(1, ac.getCname());
			pstate.setString(2, ac.getDuration());
			pstate.setInt(3, ac.getFees());
			i=pstate.executeUpdate();
			
			if(i>0)
			{
				str="Valid";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			str=e.getMessage();
			e.printStackTrace();
		}
		return str;
		}


	@Override
	public List<Register> displayall() {
		
			ResultSet rs=null;
			Register r=null;
			LinkedList<Register> lst=new LinkedList<>();
			Connection con=dsa.getConnection();
			Statement state=null;
			String str=null;
			int i=0;
		
			try {
				state=con.createStatement();
				rs=state.executeQuery("select * from Studentreg");
			
				while(rs.next()){
					r=new Register();
					r.setRegno(rs.getInt(1));
					r.setFname(rs.getString(2));
					r.setMobno(rs.getString(5));
					r.setUname(rs.getString(3));
					r.setPassword(rs.getString(4));
					
					lst.add(r);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			return lst;
		}


	@Override
	public List<Addcourse> displaycourse() {
		ResultSet rs=null;
		Addcourse ad=null;
		LinkedList<Addcourse> aclst=new LinkedList<>();
		Connection con=dsa.getConnection();
		Statement state=null;
		String str=null;
		int i=0;
	
		try {
			state=con.createStatement();
			rs=state.executeQuery("select * from Addcourse");
		
			while(rs.next()){
				ad=new Addcourse();
				ad.setCname(rs.getString(1));
				ad.setDuration(rs.getString(2));
				ad.setFees(rs.getInt(3));
				aclst.add(ad);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return aclst;
	}


	@Override
	public List<Addcourse> search(String cname) {
		ResultSet rs=null;
		Addcourse ad=null;
		LinkedList<Addcourse> aclst=new LinkedList<>();
		Connection con=dsa.getConnection();
		int i=0;
	
		try {
			PreparedStatement pstate=con.prepareStatement("select * from Addcourse where cname=?");
			pstate.setString(1, cname);
			rs=pstate.executeQuery();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			if(rs.next()){
				ad=new Addcourse();
				ad.setCname(rs.getString(1));
				ad.setDuration(rs.getString(2));
				ad.setFees(rs.getInt(3));
				aclst.add(ad);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return aclst;
	}
	}
	
	
	
	
	



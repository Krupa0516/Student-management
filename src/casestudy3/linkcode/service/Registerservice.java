package casestudy3.linkcode.service;
import java.util.List;
import casestudy3.linkcode.model.Addcourse;
import casestudy3.linkcode.model.Admin;
import casestudy3.linkcode.model.Register;

public interface Registerservice {

	public int create(List<Register>lst);
	public boolean Adminlogin(Admin aobj);
	public String addcourse(List<Addcourse>aclst);
	public List<Register>displayall();
	public List<Addcourse>displaycourse();
	public List<Addcourse> search(String cname);
}

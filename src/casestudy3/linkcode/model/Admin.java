package casestudy3.linkcode.model;

public class Admin {
	private String ADMIN_USERNAME;
	private String ADMIN_PASSWORD;
	public Admin(String aDMIN_USERNAME, String aDMIN_PASSWORD) {
		super();
		ADMIN_USERNAME = aDMIN_USERNAME;
		ADMIN_PASSWORD = aDMIN_PASSWORD;
	}
	public String getADMIN_USERNAME() {
		return ADMIN_USERNAME;
	}
	public void setADMIN_USERNAME(String aDMIN_USERNAME) {
		ADMIN_USERNAME = aDMIN_USERNAME;
	}
	public String getADMIN_PASSWORD() {
		return ADMIN_PASSWORD;
	}
	public void setADMIN_PASSWORD(String aDMIN_PASSWORD) {
		ADMIN_PASSWORD = aDMIN_PASSWORD;
	}
	
}

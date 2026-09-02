package admin;

public class Admin {
	private String Id = "admin";
	private static String pass = "0123";

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public static String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}

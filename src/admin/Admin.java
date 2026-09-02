package admin;

public class Admin {
	private String Id = "admin";
	private static int pass = 1111;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public static int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

}

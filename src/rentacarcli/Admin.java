package rentacarcli;

public class Admin {
	private String Id = "admin";
	private int pass = 1111;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	public boolean certificationPass(String id, int pass) {
		if (id == getId() && pass == getPass()) {
			System.out.println("パスワードが認証されました。");
			return true;
		} else {
			System.out.println("IDまたはパスワードが違います。");
			return false;
		}

	}

}

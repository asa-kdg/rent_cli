package main;

public class Admin {
	private String id;
	private int password;

	public Admin(String id, int password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public int getPassword() {
		return password;
	}

}

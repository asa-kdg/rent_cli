package main;

public class Admin {
	private static String id;
	private static int password;

	public Admin(String id, int password) {
		this.id = id;
		this.password = password;
	}

	public static String getId() {
		return id;
	}

	public static int getPassword() {
		return password;
	}

}

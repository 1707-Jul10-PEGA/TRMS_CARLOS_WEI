package com.revature.trms.pojos;

public class Login extends User{
	String username;
	String password;
	
	public Login() {
		super();
	}
	
	public Login(String username, String password){
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return this.getUserId();
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}
}

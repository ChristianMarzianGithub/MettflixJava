package businessLogikPackage;

import dataBasePackage.DatabaseObject;

public class LoginService {
	private String usr;
	private String pw;
	private boolean isLogedIn;
	
	public LoginService(String usr, String pw) {
		this.usr = usr;
		this.pw = pw;
	}
	
	
	public String getUsr() {
		return this.usr;
	}
	
	public void setUsr(String usr) {
		this.usr = usr;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public boolean getIsLogedIn() {
		return this.isLogedIn;
	}
	
	public void setIsLogedIn(boolean isLogedIn) {
		this.isLogedIn = isLogedIn;
	}
	
	public int login() {
		DatabaseObject bo = new DatabaseObject(); 
		return bo.login(this.usr,this.pw);
	}
	
	
	
	
	
}
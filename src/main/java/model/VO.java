package model;

import java.util.ArrayList;

public class VO {
	private UserDTO user;
	private ArrayList<String> list;
	
	public VO(UserDTO user, ArrayList<String> list) {
		super();
		this.user = user;
		this.list = list;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	
}

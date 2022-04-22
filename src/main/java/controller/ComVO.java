package controller;

import model.CommunityDTO;
import model.UserDTO;

public class ComVO {
	private CommunityDTO com;
	private UserDTO user;
	public ComVO() {
		super();
	}
	public ComVO(CommunityDTO com, UserDTO user) {
		super();
		this.com = com;
		this.user = user;
	}
	public CommunityDTO getCom() {
		return com;
	}
	public void setCom(CommunityDTO com) {
		this.com = com;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
}

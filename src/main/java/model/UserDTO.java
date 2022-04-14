package model;

public class UserDTO {

	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_nick;
	private String user_phone;
	private String user_birthdate;
	private String user_joindate;
	private String user_type;
	private String family_id; // 9개
	
	// 생성자
	public UserDTO() {
		super();
	}
	// 로그인시 필요한 생성자
	public UserDTO(String user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	// 회원가입시 필요한 생성자
	
	public UserDTO(String user_id, String user_pw, String user_name, String user_nick, String user_phone,
			String user_birthdate, String user_joindate, String user_type, String family_id) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_nick = user_nick;
		this.user_phone = user_phone;
		this.user_birthdate = user_birthdate;
		this.user_joindate = user_joindate;
		this.user_type = user_type;
		this.family_id = family_id;
	}
	public UserDTO(String user_id, String user_pw, String user_name, String user_nick, String user_phone,
			String user_birthdate) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_nick = user_nick;
		this.user_phone = user_phone;
		this.user_birthdate = user_birthdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(String user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	public String getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getFamily_id() {
		return family_id;
	}
	public void setFamily_id(String family_id) {
		this.family_id = family_id;
	}
}

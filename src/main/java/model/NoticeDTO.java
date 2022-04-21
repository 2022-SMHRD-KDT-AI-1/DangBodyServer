package model;

public class NoticeDTO {
	private String notice_title;
	private String date;
	private String check;
	private String user_id;
	
	public NoticeDTO() {}
	
	public NoticeDTO(String notice_title, String date, String check, String user_id) {
		super();
		this.notice_title = notice_title;
		this.date = date;
		this.check = check;
		this.user_id = user_id;
	}

	public NoticeDTO(String user_id,String notice_title, String date) {
		super();
		this.user_id = user_id;
		this.notice_title = notice_title;
		this.date = date;
	}


	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}

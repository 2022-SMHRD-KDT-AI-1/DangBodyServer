package model;

public class WalkDTO {
	private int walk_seq;
	private String walk_time;
	private String walk_distance;
	private String walk_date;
	private String user_id;
	private int pet_seq;
	public WalkDTO() {
		super();
	}
	public WalkDTO(int walk_seq, String walk_time, String walk_distance, String walk_date, String user_id,
			int pet_seq) {
		super();
		this.walk_seq = walk_seq;
		this.walk_time = walk_time;
		this.walk_distance = walk_distance;
		this.walk_date = walk_date;
		this.user_id = user_id;
		this.pet_seq = pet_seq;
	}
	public WalkDTO(String walk_time, String walk_distance, String walk_date, String user_id) {
		this.walk_time = walk_time;
		this.walk_distance = walk_distance;
		this.walk_date = walk_date;
		this.user_id = user_id;
	}
	public WalkDTO(String walk_time, String walk_distance, String walk_date) {
		this.walk_time = walk_time;
		this.walk_distance = walk_distance;
		this.walk_date = walk_date;
	}
	
	public int getWalk_seq() {
		return walk_seq;
	}
	public void setWalk_seq(int walk_seq) {
		this.walk_seq = walk_seq;
	}
	public String getWalk_time() {
		return walk_time;
	}
	public void setWalk_time(String walk_time) {
		this.walk_time = walk_time;
	}
	public String getWalk_distance() {
		return walk_distance;
	}
	public void setWalk_distance(String walk_distance) {
		this.walk_distance = walk_distance;
	}
	public String getWalk_date() {
		return walk_date;
	}
	public void setWalk_date(String walk_date) {
		this.walk_date = walk_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPet_seq() {
		return pet_seq;
	}
	public void setPet_seq(int pet_seq) {
		this.pet_seq = pet_seq;
	}
	
	
}

package model;

public class PetDTO {
	private String pet_seq;
	private String pet_name;
	private String pet_birthdate;
	private String pet_gender;
	private String pet_neutral;
	private int pet_weight;
	private String pet_date;
	private String user_id;

	// 생성자
	public PetDTO() {
	}

	// 펫등록
	public PetDTO(String pet_name, String pet_birthdate, String pet_gender, String pet_neutral, int pet_weight,
			String pet_date, String user_id) {
		super();
		this.pet_name = pet_name;
		this.pet_birthdate = pet_birthdate;
		this.pet_gender = pet_gender;
		this.pet_neutral = pet_neutral;
		this.pet_weight = pet_weight;
		this.pet_date = pet_date;
		this.user_id = user_id;
	}

	public PetDTO(String pet_seq, String pet_name, String pet_birthdate, String pet_gender, String pet_neutral,
			int pet_weight, String pet_date, String user_id) {
		super();
		this.pet_seq = pet_seq;
		this.pet_name = pet_name;
		this.pet_birthdate = pet_birthdate;
		this.pet_gender = pet_gender;
		this.pet_neutral = pet_neutral;
		this.pet_weight = pet_weight;
		this.pet_date = pet_date;
		this.user_id = user_id;
	}

	public String getPet_seq() {
		return pet_seq;
	}

	public void setPet_seq(String pet_seq) {
		this.pet_seq = pet_seq;
	}

	public String getPet_name() {
		return pet_name;
	}

	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}

	public String getPet_birthdate() {
		return pet_birthdate;
	}

	public void setPet_birthdate(String pet_birthdate) {
		this.pet_birthdate = pet_birthdate;
	}

	public String getPet_gender() {
		return pet_gender;
	}

	public void setPet_gender(String pet_gender) {
		this.pet_gender = pet_gender;
	}

	public String getPet_neutral() {
		return pet_neutral;
	}

	public void setPet_neutral(String pet_neutral) {
		this.pet_neutral = pet_neutral;
	}

	public int getPet_weight() {
		return pet_weight;
	}

	public void setPet_weight(int pet_weight) {
		this.pet_weight = pet_weight;
	}

	public String getPet_date() {
		return pet_date;
	}

	public void setPet_date(String pet_date) {
		this.pet_date = pet_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}

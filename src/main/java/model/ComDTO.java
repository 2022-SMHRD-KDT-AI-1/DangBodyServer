package model;

public class ComDTO {
	private int article_seq;
	private String article_content;
	private String article_file;
	private String article_date;
	private int like;
	private String user_nick;
	public ComDTO() {
		super();
	}
	public ComDTO(int article_seq, String article_content, String article_file, String article_date, int like,
			String user_nick) {
		super();
		this.article_seq = article_seq;
		this.article_content = article_content;
		this.article_file = article_file;
		this.article_date = article_date;
		this.like = like;
		this.user_nick = user_nick;
	}
	public int getArticle_seq() {
		return article_seq;
	}
	public void setArticle_seq(int article_seq) {
		this.article_seq = article_seq;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_file() {
		return article_file;
	}
	public void setArticle_file(String article_file) {
		this.article_file = article_file;
	}
	public String getArticle_date() {
		return article_date;
	}
	public void setArticle_date(String article_date) {
		this.article_date = article_date;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	
}

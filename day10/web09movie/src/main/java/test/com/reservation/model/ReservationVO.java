package test.com.reservation.model;

import java.sql.Timestamp;

public class ReservationVO {
	private int num;
	private String user_id;
	private int movie_num;
	private Timestamp regdate;
	private String movie_date;
	private int mcount;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getMovie_num() {
		return movie_num;
	}

	public void setMovie_num(int movie_num) {
		this.movie_num = movie_num;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getMovie_date() {
		return movie_date;
	}

	public void setMovie_date(String movie_date) {
		this.movie_date = movie_date;
	}

	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}

	@Override
	public String toString() {
		return "ReservationVO [num=" + num + ", user_id=" + user_id + ", movie_num=" + movie_num + ", regdate="
				+ regdate + ", movie_date=" + movie_date + ", mcount=" + mcount + ", title=" + title + "]";
	}

}

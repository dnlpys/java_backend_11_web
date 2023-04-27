package test.com.comments.model;

import java.sql.Timestamp;

public class CommentsVO {

	private int cnum;
	private int wnum;
	private String content;
	private Timestamp wdate;
	private String writer;

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public int getWnum() {
		return wnum;
	}

	public void setWnum(int wnum) {
		this.wnum = wnum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "CommentsVO [cnum=" + cnum + ", wnum=" + wnum + ", content=" + content + ", wdate=" + wdate + ", writer="
				+ writer + "]";
	}

}

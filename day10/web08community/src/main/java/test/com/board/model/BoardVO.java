package test.com.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int wnum;
	private String writer;
	private String title;
	private String content;
	private Timestamp wdate;
	private int vcount;

	public int getWnum() {
		return wnum;
	}

	public void setWnum(int wnum) {
		this.wnum = wnum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getVcount() {
		return vcount;
	}

	public void setVcount(int vcount) {
		this.vcount = vcount;
	}

	@Override
	public String toString() {
		return "BoardVO [wnum=" + wnum + ", writer=" + writer + ", title=" + title + ", content=" + content + ", wdate="
				+ wdate + ", vcount=" + vcount + "]";
	}

}

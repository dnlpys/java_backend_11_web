package test.com.movie.model;

public class MovieVO {
	private int num;
	private String title;
	private int price;
	private String producer;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "MovieVO [num=" + num + ", title=" + title + ", price=" + price + ", producer=" + producer + "]";
	}

}

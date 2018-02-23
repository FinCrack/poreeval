package data;

public class Product {

	private String productname;
	private Integer ean;
	private String note;
	private Integer rating;
	private String date;

	public Product(String productname, Integer ean, String note, Integer rating, String date) {
		super();
		this.productname = productname;
		this.ean = ean;
		this.note = note;
		this.rating = rating;
		this.setDate(date);
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getEan() {
		return ean;
	}

	public void setEan(Integer ean) {
		this.ean = ean;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

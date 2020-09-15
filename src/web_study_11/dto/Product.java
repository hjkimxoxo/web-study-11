package web_study_11.dto;

public class Product {
	private int code;
	private String name;
	private int price;
	private String description;
	private String pictureUrl;

	public Product() {

	}

	public Product(int code) {
		this.code = code;
	}
	
	
	

	public Product(int code, String name, int price, String description, String pictureUrl) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.pictureUrl = pictureUrl;
	}

	public Product( String name, int price, String description, String picUrl) {
		
		this.name = name;
		this.price = price;
		this.description = description;
		this.pictureUrl = picUrl;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return pictureUrl;
	}

	public void setPicUrl(String picUrl) {
		this.pictureUrl = picUrl;
	}

	@Override
	public String toString() {
		return String.format("Product [code=%s, name=%s, price=%s, description=%s, picUrl=%s]", code, name, price,
				description, pictureUrl);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code != other.code)
			return false;
		return true;
	}

}

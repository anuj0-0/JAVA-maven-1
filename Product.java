package jdbc_maven;

public class Product {
	private int id;
	private String name;
	private double price;
	private String manufacturer;
	private double discount;
	private int warranty;
	private String manufaterDate;
	private int gst;
	
	
	public Product() {
		super();
	}
	public Product(int id, String name, double price, String manufacturer, double discount, int warranty,
			String manufaterDate, int gst) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
		this.discount = discount;
		this.warranty = warranty;
		this.manufaterDate = manufaterDate;
		this.gst = gst;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	public String getManufaterDate() {
		return manufaterDate;
	}
	public void setManufaterDate(String manufaterDate) {
		this.manufaterDate = manufaterDate;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", manufacturer=" + manufacturer
				+ ", discount=" + discount + ", warranty=" + warranty + ", manufaterDate=" + manufaterDate + ", gst="
				+ gst + "]";
	}
	
	

}

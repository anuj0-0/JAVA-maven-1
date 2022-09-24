package jdbc_maven;

public class Mobile {
	private int id;
	private String name;
	private String brand;
	private String colour;
	private double price;
	private int ram;
	private int camera;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getCamera() {
		return camera;
	}
	public void setCamera(int camera) {
		this.camera = camera;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", brand=" + brand + ", colour=" + colour + ", price=" + price
				+ ", ram=" + ram + ", camera=" + camera + "]";
	}
	
}

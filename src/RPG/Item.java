package RPG;

public class Item {
	
	private String name;
	private String type;
	private double price; 
	private double wear;
	
	
	
	public Item(String name, String type, double price, double wear) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.wear = wear;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double precio) {
		this.price = precio;
	}



	public double getWear() {
		return wear;
	}



	public void setWear(double wear) {
		this.wear = wear;
	}


	

}

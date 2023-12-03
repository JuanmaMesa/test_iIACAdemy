package RPG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Item {
	
	
	private String name;
	private String type;
	private double price; 
	private double wear;
	
	
	
	public Item(String name, String type, double price, double wear) {
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

	
	public static Item findByNameItem(String name) {
		
		for(Item n: GameControler.getAllItems()) {
			if(n.getName().equalsIgnoreCase(name)) {
				return n;
			}
		}
		return null;
	}
	
	
	
	public Item copy() {
		return new Item (this.name, this.type, this.price, this.wear);
	}
	



	@Override
	public int hashCode() {
		return Objects.hash(name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(name, other.name);
	}



	@Override
	public String toString() {
		return  "OBJETO: "+name + ", TIPO: " + type + ", PRECIO: " + price + " mondeas, "+" DESGASTE " + wear  ;
	}
	
	
	
	
	


}

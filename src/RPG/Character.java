package RPG;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public abstract class Character {

	private String name;
	private String location;

	private ArrayList<Item>inventory;

	public Character(String name, String location) {
		this.name = name;
		this.location = location;
		
		inventory = new ArrayList<>();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public void toSeeInventory() {
		if(inventory.isEmpty()) {
			System.out.println("El inventario esta vacio");
		
		}else {inventory.forEach( n -> System.out.println(n.toString()));
		
		}
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
		Character other = (Character) obj;
		return Objects.equals(name, other.name);
	}
	
}

	
	
	
	
	

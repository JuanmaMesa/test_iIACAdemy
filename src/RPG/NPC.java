package RPG;

import java.util.ArrayList;

public abstract class NPC {

	private String type;
	private String name;
	private String location;

	private ArrayList<Item>inventory;

	

	public NPC(String type, String name,String location ) {
		super();
		this.type = type;
		this.name = name;
	
		inventory = new ArrayList<>();
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
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
	
	
	public abstract void add_item(Item item) throws InventariFullException;
	
	public void toSeeInventory() {
		
		for(Item item: inventory) {
			System.out.println(item.getName());
		}
		
		
	}
	





}

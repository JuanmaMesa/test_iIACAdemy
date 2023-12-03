package RPG;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public abstract class NPC extends Character  {

	private String type;
	
	

	public NPC(String name, String location, String type) {
		super(name, location);
		this.type = type;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public abstract void add_item(Item item) throws InventariFullException;
	
	public abstract Item sell_item(Item item);
	
	public abstract Item remove_item (Item item);
	
	


	
	
	

	


}

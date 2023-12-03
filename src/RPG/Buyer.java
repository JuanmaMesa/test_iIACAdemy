package RPG;

import java.util.ArrayList;
import java.util.Objects;

import RPG.GameControler.CharacterType;

public class Buyer extends Character {
	
	public Buyer(String name, String location) {
		super(name, location);
		
	}
	
	public Item buy_item(String nameSeller, String nameItem) {
		NPC seller = (NPC) GameControler.findByName(nameSeller, CharacterType.SELLER);
		
		if(seller == null) {
			
			return null;
		}
		
		Item itemToBuy = seller.getInventory().stream()
					.filter(item -> item.getName().equalsIgnoreCase(nameItem))
					.findFirst()
					.orElse(null);
			
		if(itemToBuy == null) {
			return null;
		}
		
		seller.sell_item(itemToBuy);
		getInventory().add(itemToBuy);
		seller.getInventory().remove(itemToBuy);
		return itemToBuy;
			
	
		
		
		
		
	}
	
}

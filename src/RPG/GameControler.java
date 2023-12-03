package RPG;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GameControler {
	public enum CharacterType {
	    SELLER,
	    BUYER;

	}
	
	private static  Set<Item> allItems = new HashSet<>();
	private static Set<NPC> allNpcSeller = new HashSet<>();
	private static Set<Buyer> allBuyers = new HashSet<>();
	
	public static Set<NPC> getAllNpcSeller() {
		return allNpcSeller;
	}

	public static Set<Item> getAllItems() {
		return allItems;
	}
	public static Set<Buyer> getAllNpcBuyers() {
		return allBuyers;
	}

	
	
	public void createNPCSellers() {
		
		allNpcSeller.add(new Thief("Aragon","city"));
		allNpcSeller.add(new Thief("Reginna","Asgard"));
		allNpcSeller.add(new Farmer("Stuard","city"));
		allNpcSeller.add(new Trader("Wilson","town"));
		allNpcSeller.add(new Trader("Martha","Asgard"));

		
	}
	
	public void createItems() {
		allItems.add(new Item("Pistola", "arma", 25.5, 3));
		allItems.add(new Item("Lanzallamas", "arma", 50.9, 3));
		allItems.add(new Item("Cuerda", "objeto", 15, 1));
		allItems.add(new Item("Cuchillo", "arma", 10, 1.5));
		
	}
	
	public void createBuyers() {
		allBuyers.add(new Buyer("Magneto","Asgard"));
		allBuyers.add(new Buyer("Magneto besson","city"));
		
		
	}
	public void ToSeeSellers() {
		System.out.println("---- Lista de Vendedores ----");
		allNpcSeller.forEach( n -> System.out.println(n.getName()));
		
	}

	
	public void ToSeeItems() {
		System.out.println("---- Lista de Items ----");
		allItems.forEach( n -> System.out.println(n.getName()));
		
	}
	
	public void ToSeeBuyers() {
		System.out.println("---- Lista de Compradores ----");
		allBuyers.forEach( n -> System.out.println(n.getName()));
	}
	
	public static Character findByName(String name, CharacterType characterType) {
		if(characterType == CharacterType.SELLER) {
			for(NPC n: GameControler.getAllNpcSeller()){
				if(n.getName().equalsIgnoreCase(name)) {
					return n;
				}
			}return null;
			
		} else if(characterType == CharacterType.BUYER) {
			for(Buyer n: GameControler.getAllNpcBuyers()){
				if(n.getName().equalsIgnoreCase(name)) {
					return n;
				}
			}return null;
			
		} else {
			return null;
		}
	}
	
	
	
	public void addItemToInventory(String nameNPC, String nameItem) {
		
		Item item = Item.findByNameItem(nameItem);
		
		NPC npc = (NPC) findByName(nameNPC, CharacterType.SELLER);
		
		if ( item != null && npc != null) {
			try {
				Item itemCopy = item.copy();// creamos una copia del item original
				npc.add_item(itemCopy);
				System.out.println("Item "+itemCopy.getName() +" agregado correctamente a "+ npc.getName());
			} catch (InventariFullException e) {
				System.out.println("InventariFullException: "+ e.getMessage());
			}
			
		}else {
			System.out.println("Error, No hay nada con esos nombres.");
		}		
	}
	
	public void toSeeInventory(String name, CharacterType character) {
		Character npc = findByName(name, character);
		
		if(npc != null) {
			npc.toSeeInventory();
		}
		else {
			System.out.println("No se encontro ninguna coincidencia con ese nombre.");
		}
	}
	
	public List<Character> toSeeCharacterInCity(String city, CharacterType character) {
		if(character ==CharacterType.BUYER) {
			return allBuyers.stream()
					.filter(b -> b.getLocation().equalsIgnoreCase(city))
					.collect(Collectors.toList());
					
					
		}else if( character == CharacterType.SELLER) {
			return allNpcSeller.stream()
					.filter(s -> s.getLocation().equalsIgnoreCase(city))
					.collect(Collectors.toList());
			
			
		}
		
		return new ArrayList<>();
		
		
		
	}
	public Item toSeeItemCheapest(String city) {
			return allNpcSeller.stream()
				.filter( npc -> npc.getLocation() != null && npc.getLocation().equalsIgnoreCase(city))
				.flatMap(npc -> npc.getInventory().stream())
				.min(Comparator.comparing(Item::getPrice))
				.orElse(null);
	}
	

	public void toBuy(String nameBuyer, String nameSeller, String nameItem) {
		
		Buyer buyer = (Buyer) findByName(nameBuyer, CharacterType.BUYER);
		
		if( buyer != null) {
		Item item = buyer.buy_item(nameSeller, nameItem);
			if(item == null) {
				System.out.println("item "+nameItem+" no encontrado");
				
			}else {System.out.println("Item comprado: "+ item.getName()+" por "+item.getPrice()+" monedas.");
				
					
			}
			
		
		}
	}
		
	public List<Item> seeTypeItem(String typeItem) {
		
		return allItems.stream()
				.filter( i -> i.getType().equalsIgnoreCase(typeItem))
				.sorted(Comparator.comparing(Item :: getPrice))
				.toList();
				
				
	}
}
	
	



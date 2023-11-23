package RPG;
import java.util.*;

public class App_Rpg {
	public static ArrayList<NPC>listAllNpcSellers = new ArrayList<>();

	public static void main(String[] args) {
		
		
		
		
		

	     //1
		createNPCSellers();
		ToSeeNPCSellers();
		
		
		//2
		
		addItemToNPC("Aragon", new Item("Pistola", "arma", 25.5,1));
		addItemToNPC("Aragon", new Item("balas", "arma", 25.5,1));
		addItemToNPC("Aragon", new Item("cuerda", "equipamiento", 25.5,1));
		addItemToNPC("Aragon", new Item("Piedra misteriosa", "objeto", 25.5,1));// ocurrira una exceptionn 
		addItemToNPC("Stuard", new Item("Pistola", "arma", 16.4,1));
		
		
		//3
	sellerInLocation("town");
		
	}
	
	public static void createNPCSellers() {
		
		listAllNpcSellers.add(new Thief("Aragon", "city"));
		listAllNpcSellers.add(new Thief("Reginna", "Asgard"));
		listAllNpcSellers.add(new Farmer("Stuard", "city"));
		listAllNpcSellers.add(new Trader("Wilson", "town"));
		listAllNpcSellers.add(new Trader("Marta", "Asgard"));
		
	}
	
	public static void ToSeeNPCSellers() {
		System.out.println("--Lista NPC Venderdores--");
		listAllNpcSellers.forEach(n -> System.out.println(n.getName()+" ("+n.getType()+")"));
	}
	
	public static void ToseeInventoryToNPC(String name) {
		
		NPC npc = findByName(name);
		if(npc != null) {
			npc.toSeeInventory();
			
			}
	}
		
	public static void addItemToNPC(String name, Item item) {
		NPC npc = findByName(name);
		if(npc != null) {
			try {
				npc.add_item(item);
				
			} catch (InventariFullException e) {
			System.out.println("InventoryFUllException: "+ e.getMessage());
			}
		}
		else {
			System.out.println("No se ha encontrado el NPC que buscas");
		}
		
	}
	
	public static ArrayList<NPC> sellerInLocation(String name) {
		ArrayList <NPC> listNPCtoLocation  = new ArrayList<>();
		
		for(NPC npc : listAllNpcSellers) {
			if(npc.getLocation().equalsIgnoreCase(name)) {
				listNPCtoLocation.add(npc);
			}else {
				System.out.println("No se pudo encontrar a ningun vendedor en la ciudad");
			}
			
		}
		return listNPCtoLocation;
		
		}
	
	
	
	
	public static void toSeeCheapestItem(String name) {
		
		ArrayList<NPC>listNpcCity = sellerInLocation(name);
		ArrayList<Item>listAllItems = new ArrayList <>();
		
		for( NPC npc: listNpcCity) {
			listAllItems.addAll(npc.getInventory());
		}
		
		Collections.sort(listAllItems, new ItemComparator());
		Item CheapestItem = listAllItems.get(0);
		System.out.println(CheapestItem);
		
		
		
		
		
	}
		
	
	public static NPC findByCity(String name) {
		for(NPC n: listAllNpcSellers) {
			if(n.getLocation().equalsIgnoreCase(name)) {
				return n;
			}
		}return null;
		
	}
	
	
	public static NPC findByName(String name) {
		for(NPC n: listAllNpcSellers) {
			if(n.getName().equalsIgnoreCase(name)) {
				return n;
			}
		}return null;
		
	}
	

}

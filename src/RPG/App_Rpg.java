package RPG;
import java.util.*;
import RPG.GameControler;
import RPG.GameControler.CharacterType;


public class App_Rpg {
	

	public static void main(String[] args) {
		
		GameControler gameControler = new GameControler();
		
		// 1. creamos vendedores e items en el juego.
		gameControler.createNPCSellers();
		gameControler.createItems();
		

	
		// 2. Añadir un item al inventario de un vendedor.*
		System.out.println("\n--- Agregando items a los NPC ---");
		gameControler.addItemToInventory("Reginna", "Pistola");
		gameControler.addItemToInventory("Reginna", "cuerda");
		gameControler.addItemToInventory("Reginna", "Pistola");
		gameControler.addItemToInventory("Reginna", "Pistola");// mostrando error por inventario lleno
		gameControler.addItemToInventory("Martha", "Pistola");
		gameControler.addItemToInventory("Martha", "Lanzallamas");
		
		
		
		// 3. Ver el item mas barato en una ciudad especifica.
		System.out.println("-----");
		String location = "Asgard";
		Item cheapestItem = gameControler.toSeeItemCheapest(location);
		
		if(cheapestItem != null) {
			System.out.println("El item más barato en "+location+ " es: "+cheapestItem.toString());
					
		}else {
			System.out.println("No se encontro ningun item en la ciudad");
		}
		
		
		// 4.  Consultar los Items de un vendedor.
		String nameNPC = "Reginna";
		String nameFarmer = "Martha";
		System.out.println("\nEl inventario de "+nameNPC+":");
		gameControler.toSeeInventory(nameNPC, CharacterType.SELLER);
	
		
		// 5. crear un comprador
		gameControler.createBuyers();
		
		
		// 6.Realizar la compra de un item
		
		String buyer = "magneto";
		System.out.println("\n-- Comprando items --");
		gameControler.toBuy(buyer, nameNPC, "pistola");
		gameControler.toBuy(buyer, nameFarmer, "cuerda");// Item no encontrado
		gameControler.toBuy(buyer, nameFarmer, "pistola");// ver la diferencia con taxas
		
		
		
		// 7.Consultar los items de un comprador
		System.out.println("\n Inventario de "+buyer);
		gameControler.toSeeInventory(buyer, CharacterType.BUYER);
		
		
		//8. Consultar todos los vendedores que hay en una ciudad
		System.out.println("\n -- vendedores en la ciudad escogida --");
	
		List<Character> charactersInCity = gameControler.toSeeCharacterInCity(location,CharacterType.SELLER);
		
		if( charactersInCity.isEmpty()) {
			System.out.println("No hay nadie en la ciudad ");
		}else {
			charactersInCity.forEach(n -> System.out.println(n.getName()));
		}
		
		
		// 9 - Consultar todos los compradores que hay en una ciudad.**
		System.out.println("\n -- vendedores en la ciudad escogida --");
		List<Character> charactersInCityBuyers = gameControler.toSeeCharacterInCity(location,CharacterType.BUYER);
		

		if( charactersInCityBuyers.isEmpty()) {
			System.out.println("No hay nadie en la ciudad ");
		}else {
			charactersInCityBuyers.forEach(n -> System.out.println(n.getName()));
		}
		
		
		// 10 - Mostrar todos los ítems de un determinado tipo ordenados por precio (asc). **
		String nameTypeItem = "Arma";
		System.out.println("-- Lista de items --");
		List<Item>listOfTypeItem = gameControler.seeTypeItem(nameTypeItem);
		
		if( listOfTypeItem.isEmpty()) {
			System.out.println("NO hay Items de este typo");
		}else {
		listOfTypeItem.forEach(n -> System.out.println("Objeto: "+ n.getName()+" precio: "+n.getPrice()));
		}
	
		
		
		
		
		
		
		
		
		

		
	
		
		
		
	}

		
	
		
		
	

	
	
	
	

}

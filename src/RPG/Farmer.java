package RPG;

public class Farmer extends NPC{
	
	private final static int MAX_ITEM = 5;
	private final static double TAX  = 0.02;
	private final static double WEAR = 0.15;

	public Farmer(String name, String location) {
		super("Farmer",name, location);
		
	}

	@Override
	public void add_item(Item item) throws InventariFullException{
		
		if(super.getInventory().size() >= MAX_ITEM) {
			throw new InventariFullException("El inventario lleno, El vendedor no puede comprar el item ");
			
		}
		item.setPrice(item.getPrice()+TAX);
		super.getInventory().add(item);
		System.out.println("Item añadido correctamento al inventario");
		
		
		
	}

}

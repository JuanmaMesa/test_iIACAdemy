package RPG;

public class Trader extends NPC {
	
	private final static int MAX_ITEM = 7;
	private final static double TAX  = 0.04;
	private final static double WEAR = 0;

	public Trader(String name, String location) {
		super("Trader",name, location);
	
		
	}

	@Override
	public void add_item(Item item) throws InventariFullException {
		
		if(super.getInventory().size() >= MAX_ITEM) {
			throw new InventariFullException("El inventario lleno, El vendedor no puede comprar el item ");
			
		}
		item.setPrice(item.getPrice()+TAX);
		super.getInventory().add(item);
		System.out.println("Item añadido correctamento al inventario");
		
		
	}

}

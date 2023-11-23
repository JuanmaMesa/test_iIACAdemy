package RPG;

public class Thief extends NPC {
	
	private final static int MAX_ITEM = 3;
	private final static double TAX  = 0;
	private final static double WEAR = 0.25;

	public Thief(String name, String location) {
		super("Thief",name, location);
		
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

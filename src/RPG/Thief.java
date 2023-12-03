package RPG;

public class Thief extends NPC {
	
	private final static int MAX_ITEM = 3;
	private final static double WEAR = 0.25;

	public Thief(String name, String location) {
		super(name, location,"Thief");
		
	}

	@Override
	public void add_item(Item item) throws InventariFullException {
	
		if(super.getInventory().size() >= MAX_ITEM) {
			throw new InventariFullException("El inventario lleno, El vendedor no puede obtener el item ");
			
		}
		item.setWear(item.getWear()+WEAR);
		super.getInventory().add(item);
		
	}

	@Override
	public Item sell_item(Item item) {
		return item;
		
		
		
		
	}

	@Override
	public Item remove_item(Item item) {
		// TODO Borrar item despues de venderlo
		return null;
	}
	
	

}

package RPG;

public class Trader extends NPC {
	
	private final static int MAX_ITEM = 7;
	private final static double TAX  = 0.04;

	public Trader(String name, String location) {
		super(name, location,"Trader");
	
		
	}

	@Override
	public void add_item(Item item) throws InventariFullException {
		
		if(super.getInventory().size() >= MAX_ITEM) {
			throw new InventariFullException("El inventario lleno, El vendedor no puede obtener el item ");
			
		}
		super.getInventory().add(item);
	}

	@Override
	public Item sell_item(Item item) {
		item.setPrice(item.getPrice()+TAX);
		return item;
		
	}

	@Override
	public Item remove_item(Item item) {
		// TODO: borrar item despues de venderlo
		return null;
	}



}

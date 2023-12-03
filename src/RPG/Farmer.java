package RPG;

public class Farmer extends NPC{
	
	private final static int MAX_ITEM = 5;
	private final static double TAX  = 0.02;
	private final static double WEAR = 0.15;

	public Farmer(String name, String location) {
		super(name, location,"Farmer");
		
	}

	@Override
	public void add_item(Item item) throws InventariFullException{
		
		if(super.getInventory().size() >= MAX_ITEM) {
			throw new InventariFullException("El inventario lleno, El vendedor no puede obtener el item ");
			
		}
		item.setWear(item.getWear()+WEAR);
		super.getInventory().add(item);
	
	}

	@Override
	public Item sell_item(Item item) {
		item.setPrice(item.getPrice()+ TAX);
		return item;
		
	}

	@Override
	public Item remove_item(Item item) {
		// TODO borrar item despues de venderlo
		return null;
	}
	


}

package hust.soict.ict.aims.store;


import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.removeDigitalVideoDisc(dvd2);
		
        for (int i = 0; i < anOrder.qtyOrdered; i++) {
            DigitalVideoDisc dvd = anOrder.itemsOrdered[i];
            System.out.printf("%-6d %-30s $%-10.2f\n", dvd.getId(), dvd.getTitle(), dvd.getCost());
        }
        System.out.printf("%-37s $%-10.2f\n", "Total Cost", anOrder.totalCost());
        
        //anOrder.removeDigitalVideoDisc(dvd2);
	}
}

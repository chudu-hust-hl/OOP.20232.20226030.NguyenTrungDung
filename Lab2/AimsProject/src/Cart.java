import javax.swing.JOptionPane;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			 JOptionPane.showMessageDialog(null, "The cart is full!", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			itemsOrdered[qtyOrdered]=disc;
			qtyOrdered ++;
			JOptionPane.showMessageDialog(null, "The disc has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered+dvdList.length>= MAX_NUMBERS_ORDERED) {
			 JOptionPane.showMessageDialog(null, "The cart is full!", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int j=0; j<dvdList.length;j++) {
				addDigitalVideoDisc(dvdList[j]);
			}
			JOptionPane.showMessageDialog(null, "The disc list has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered>= MAX_NUMBERS_ORDERED-1) {
			 JOptionPane.showMessageDialog(null, "The cart is full!", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			addDigitalVideoDisc(dvd1);
			addDigitalVideoDisc(dvd2);
			JOptionPane.showMessageDialog(null, "The disc list has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	 public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
	        boolean discFound = false;
	        int indexToRemove = -1;

	        for (int i = 0; i < qtyOrdered; i++) {
	            if (itemsOrdered[i] == disc) {
	                discFound = true;
	                indexToRemove = i;
	                JOptionPane.showMessageDialog(null, "The disc is removed", "Cart update", JOptionPane.INFORMATION_MESSAGE);
	                break;
	            }
	        }

	        if (!discFound) {
	            JOptionPane.showMessageDialog(null, "Disc not found in the cart!", "Cart update", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }


	        for (int i = indexToRemove; i < qtyOrdered - 1; i++) {
	            itemsOrdered[i] = itemsOrdered[i + 1];
	        }
	        itemsOrdered[qtyOrdered - 1] = null; 
	        qtyOrdered--;
	        
	        return true; 
	    }
	
	 public float totalCost() {
	        float total = 0.0f;

	        for (int i = 0; i < qtyOrdered; i++) {
	            total += itemsOrdered[i].getCost();
	        }
	        JOptionPane.showMessageDialog(null, "The total cost of this cart is: "+ total , "Payment information", JOptionPane.INFORMATION_MESSAGE);

	        return total;
	    }
}

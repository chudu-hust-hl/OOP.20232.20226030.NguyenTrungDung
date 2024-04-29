package hust.soict.ict.aims.store;

import javax.swing.JOptionPane;

import hust.soict.ict.aims.media.DigitalVideoDisc;

public class Store {
    private static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int itemCount = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemCount >= MAX_ITEMS_IN_STORE) {
			 JOptionPane.showMessageDialog(null, "The cart is full!", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			itemsInStore[itemCount]=disc;
			itemCount ++;
			//JOptionPane.showMessageDialog(null, "The disc has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (itemCount+dvdList.length>= MAX_ITEMS_IN_STORE) {
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
		if (itemCount>= MAX_ITEMS_IN_STORE-1) {
			 JOptionPane.showMessageDialog(null, "The cart is full!", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			addDigitalVideoDisc(dvd1);
			itemCount ++;
			addDigitalVideoDisc(dvd2);
			itemCount ++;
			JOptionPane.showMessageDialog(null, "The disc list has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public boolean removeDigitalVideoDisc(String title) {
        boolean discFound = false;
        int indexToRemove = -1;

        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i].getTitle() == title) {
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


        for (int i = indexToRemove; i < itemCount - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }
        itemsInStore[itemCount - 1] = null; 
        itemCount--;
        
        return true; 
	}
	
	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean discFound = false;
        int indexToRemove = -1;

        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i] == disc) {
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


        for (int i = indexToRemove; i < itemCount - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }
        itemsInStore[itemCount - 1] = null; 
        itemCount--;
        
        return true; 
 }
    
    public void print() {
		 if (itemCount==0) {
	            System.out.println("The store is empty.");
	        }
		 else {
			 System.out.println("**************************************************STORE**************************************************");
			 for (int n=0;n < itemCount; n++) {
				 System.out.printf("%-2d. DVD - %-30s - %-20s - %-20s - %-5d : %.2f$ \n",n+1, itemsInStore[n].getTitle(), itemsInStore[n].getCategory(), itemsInStore[n].getDirector(), itemsInStore[n].getLength(), itemsInStore[n].getCost());		 
			 }
			 System.out.println("*********************************************************************************************************\n");
		 }
	 }
}

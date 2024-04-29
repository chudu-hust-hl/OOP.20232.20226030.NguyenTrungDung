package hust.soict.ict.aims.cart;

import javax.swing.JOptionPane;

import hust.soict.ict.aims.media.DigitalVideoDisc;

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
			//JOptionPane.showMessageDialog(null, "The disc has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
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
	 
	 public boolean removeDigitalVideoDisc(String title) {
	        boolean discFound = false;
	        int indexToRemove = -1;

	        for (int i = 0; i < qtyOrdered; i++) {
	            if (itemsOrdered[i].getTitle() == title) {
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
	 
	 public void print() {
		 if (qtyOrdered==0) {
	            System.out.println("The cart is empty.");
	        }
		 else {
			 System.out.println("************************************************CART************************************************");
			 System.out.println("Ordered items:");
			 for (int n=0;n < qtyOrdered; n++) {
				 System.out.printf("%2d. DVD - %-30s - %-20s - %-15s - %-5d : %.2f$ \n",n+1, itemsOrdered[n].getTitle(), itemsOrdered[n].getCategory(), itemsOrdered[n].getDirector(), itemsOrdered[n].getLength(), itemsOrdered[n].getCost());		 
			 }
			 System.out.printf("Total cost: %.2f \n", this.totalCost());
			 System.out.println("****************************************************************************************************\n");
		 }
	 }
	 
	 
	public void searchByTitle(String title) {
	    if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
	    }

	    title = title.toLowerCase(); // Convert the search title to lowercase for case-insensitive comparison
	    DigitalVideoDisc[] matchingDVDs = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	    int count = 0;

	    for (int i = 0; i < qtyOrdered; i++) {
	        String dvdTitle = itemsOrdered[i].getTitle().toLowerCase(); // Convert DVD title to lowercase
	        if (dvdTitle.contains(title)) { // Check if the DVD title contains the search string
	            matchingDVDs[count] = itemsOrdered[i]; // Add the matching DVD to the array
	            count++;
	        }
	    }

	    if (count == 0) {
	    	JOptionPane.showMessageDialog(null, "There is no disc match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("************************************************CART************************************************");
			 System.out.println("Matched items:");
			 for (int n=0;n < count; n++) {
				 System.out.printf("%d. DVD - %-30s - %-20s - %-15s - %-5d : %.2f$ \n",n+1, matchingDVDs[n].getTitle(), matchingDVDs[n].getCategory(), matchingDVDs[n].getDirector(), matchingDVDs[n].getLength(), matchingDVDs[n].getCost());		 
			 }
			 System.out.println("****************************************************************************************************\n");
		 }
	}
	
	public void searchByCategory(String category){
		if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
	    }
		
		category=category.toLowerCase();
		DigitalVideoDisc[] matchingDVDs = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		int count = 0;

	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].getCategory().equalsIgnoreCase(category)) { // Check if the DVD title contains the search string
	            matchingDVDs[count] = itemsOrdered[i]; // Add the matching DVD to the array
	            count++;
	        }
	    }
	    
	    if (count == 0) {
	    	JOptionPane.showMessageDialog(null, "There is no disc match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("************************************************CART************************************************");
			 System.out.println("Matched items:");
			 for (int n=0;n < count; n++) {
				 System.out.printf("%d. DVD - %-30s - %-20s - %-15s - %-5d : %.2f$ \n",n+1, matchingDVDs[n].getTitle(), matchingDVDs[n].getCategory(), matchingDVDs[n].getDirector(), matchingDVDs[n].getLength(), matchingDVDs[n].getCost());		 
			 }
			 System.out.println("****************************************************************************************************\n");
		 }
	    	
	}
	
	
	public void searchByPrice(float maxPrice) {
		if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
	    }
		
		int count = 0;
	    DigitalVideoDisc[] matchingDVDs = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].getCost() <= maxPrice) {
	            matchingDVDs[count++] = itemsOrdered[i];
	        }
	    }
	    
	    if (count == 0) {
	    	JOptionPane.showMessageDialog(null, "There is no disc match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("************************************************CART************************************************");
			 System.out.println("Matched items:");
			 for (int n=0;n < count; n++) {
				 System.out.printf("%d. DVD - %-30s - %-20s - %-15s - %-5d : %.2f$ \n",n+1, matchingDVDs[n].getTitle(), matchingDVDs[n].getCategory(), matchingDVDs[n].getDirector(), matchingDVDs[n].getLength(), matchingDVDs[n].getCost());		 
			 }
			 System.out.println("****************************************************************************************************\n");
		 }
	}
	
	public void searchByPrice(float minPrice, float maxPrice) {
		if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
	    }
		
		int count = 0;
	    DigitalVideoDisc[] matchingDVDs = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	    for (int i = 0; i < qtyOrdered; i++) {
	        float dvdPrice = itemsOrdered[i].getCost();
	        if (dvdPrice >= minPrice && dvdPrice <= maxPrice) {
	            matchingDVDs[count++] = itemsOrdered[i];
	        }
	    }
	    
	    if (count == 0) {
	    	JOptionPane.showMessageDialog(null, "There is no disc match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("************************************************CART************************************************");
			 System.out.println("Matched items:");
			 for (int n=0;n < count; n++) {
				 System.out.printf("%d. DVD - %-30s - %-20s - %-15s - %-5d : %.2f$ \n",n+1, matchingDVDs[n].getTitle(), matchingDVDs[n].getCategory(), matchingDVDs[n].getDirector(), matchingDVDs[n].getLength(), matchingDVDs[n].getCost());		 
			 }
			 System.out.println("****************************************************************************************************\n");
		 }
	}
 
}

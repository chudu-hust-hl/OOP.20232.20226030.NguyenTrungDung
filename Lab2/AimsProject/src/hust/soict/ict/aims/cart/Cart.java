package hust.soict.ict.aims.cart;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public ArrayList<Media> itemsOrdered = new ArrayList<>();
	
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			 JOptionPane.showMessageDialog(null, "The cart is full!", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else if(itemsOrdered.contains(media)) {
			JOptionPane.showMessageDialog(null, "The media is exist", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			itemsOrdered.add(media);
			//JOptionPane.showMessageDialog(null, "The media has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void addMedia(Media[] mediaList) {
		if (itemsOrdered.size()+mediaList.length>= MAX_NUMBERS_ORDERED) {
			 JOptionPane.showMessageDialog(null, "The cart is full!", "Cart update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int j=0; j<mediaList.length;j++) {
				addMedia(mediaList[j]);
			}
			JOptionPane.showMessageDialog(null, "The media list has been added", "Cart update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	 public void removeMedia(Media mediaToRemove) {
		 for(Media media : itemsOrdered) {
			 if(media.equals(mediaToRemove)) {
				 itemsOrdered.remove(media);
				 break;
			 }
		 }
		 
	 }
	 
	 
	 public void removeMedia(String title) {
		 for(Media media : itemsOrdered) {
			 if(media.getTitle()== title) {
				 removeMedia(media);
				 break;
			 }
		 }
	 }
	
	 public float totalCost() {
	        float total = 0.0f;

	        for (Media media : itemsOrdered) {
	            total += media.getCost();
	        }
	        //JOptionPane.showMessageDialog(null, "The total cost of this cart is: "+ total , "Payment information", JOptionPane.INFORMATION_MESSAGE);

	        return total;
	    }
	 
	 public void print() {
		 if (itemsOrdered.size()==0) {
	            System.out.println("The cart is empty.");
	        }
		 else {
			 System.out.println("*******************************************CART*******************************************");
			 System.out.println("Ordered items:");
			 for (Media media : itemsOrdered) {
				if (media instanceof Book) {
					System.out.printf("%2d. BOOK - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof CompactDisc) {
					System.out.printf("%2d. CD   - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof DigitalVideoDisc) {
					System.out.printf("%2d. DVD  - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				}						 
			 }
			 System.out.printf("Total cost: %.2f \n", this.totalCost());
			 System.out.println("******************************************************************************************\n");
		 }
	 }
	 
	 
	public void searchByTitle(String title) {
	    if (itemsOrdered.size() == 0) {
            System.out.println("The cart is empty.");
	    }

	    title = title.toLowerCase(); // Convert the search title to lowercase for case-insensitive comparison
	    ArrayList<Media> matchingMedia = new ArrayList<>();

	    for (Media media: itemsOrdered) {
	        String mediaTitle = media.getTitle().toLowerCase(); 
	        if (mediaTitle.contains(title)) { 
	            matchingMedia.add(media); 
	        }
	    }

	    if (matchingMedia.size()==0) {
	    	JOptionPane.showMessageDialog(null, "There is no media match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("*******************************************CART*******************************************");
			 System.out.println("Matched items:");
			 for (Media media : matchingMedia) {
				if (media instanceof Book) {
					System.out.printf("%2d. BOOK - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof CompactDisc) {
					System.out.printf("%2d. CD   - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof DigitalVideoDisc) {
					System.out.printf("%2d. DVD  - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				}						 
			 }
			 System.out.println("******************************************************************************************\n");
		 }
	}
	
	public void searchByCategory(String category){
		if (itemsOrdered.size() == 0) {
            System.out.println("The cart is empty.");
	    }
		
		category=category.toLowerCase();
	    ArrayList<Media> matchingMedia = new ArrayList<>();

	    for (Media media: itemsOrdered) {
	        String mediaCategory = media.getCategory().toLowerCase(); 
	        if (mediaCategory.equalsIgnoreCase(category)) { 
	            matchingMedia.add(media); 
	        }
	    }
	    
	    if (matchingMedia.size()==0) {
	    	JOptionPane.showMessageDialog(null, "There is no media match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("*******************************************CART*******************************************");
			 System.out.println("Matched items:");
			 for (Media media : matchingMedia) {
				if (media instanceof Book) {
					System.out.printf("%2d. BOOK - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof CompactDisc) {
					System.out.printf("%2d. CD   - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof DigitalVideoDisc) {
					System.out.printf("%2d. DVD  - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				}						 
			 }
			 System.out.println("******************************************************************************************\n");
		 }
	    	
	}
	
	
	public void searchByPrice(float maxPrice) {
		if (itemsOrdered.size() == 0) {
            System.out.println("The cart is empty.");
	    }
		
		ArrayList<Media> matchingMedia = new ArrayList<>();

	    for (Media media: itemsOrdered) {
	        if (media.getCost() <= maxPrice) {
	            matchingMedia.add(media);
	        }
	    }
	    
	    if (matchingMedia.size()==0) {
	    	JOptionPane.showMessageDialog(null, "There is no media match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("*******************************************CART*******************************************");
			 System.out.println("Matched items:");
			 for (Media media : matchingMedia) {
				if (media instanceof Book) {
					System.out.printf("%2d. BOOK - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof CompactDisc) {
					System.out.printf("%2d. CD   - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof DigitalVideoDisc) {
					System.out.printf("%2d. DVD  - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				}						 
			 }
			 System.out.println("******************************************************************************************\n");
		 }
	}
	
	public void searchByPrice(float minPrice, float maxPrice) {
		if (itemsOrdered.size() == 0) {
            System.out.println("The cart is empty.");
	    }
		
		ArrayList<Media> matchingMedia = new ArrayList<>();

	    for (Media media: itemsOrdered) {
	        if (media.getCost() <= maxPrice && media.getCost() >= minPrice) {
	            matchingMedia.add(media);
	        }
	    }
	    
	    if (matchingMedia.size()==0) {
	    	JOptionPane.showMessageDialog(null, "There is no media match!", "Serching DVDs", JOptionPane.ERROR_MESSAGE);
	    }
	    else {
			 System.out.println("*******************************************CART*******************************************");
			 System.out.println("Matched items:");
			 for (Media media : matchingMedia) {
				if (media instanceof Book) {
					System.out.printf("%2d. BOOK - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof CompactDisc) {
					System.out.printf("%2d. CD   - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof DigitalVideoDisc) {
					System.out.printf("%2d. DVD  - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				}						 
			 }
			 System.out.println("******************************************************************************************\n");
		 }
	}
	
	public void searchByType(String type) {
		switch(type) {
		case "Book": 
			System.out.println("*******************************************CART*******************************************");
			System.out.println("Ordered items:");
			for (Media media : itemsOrdered) {
				if (media instanceof Book) {
					System.out.printf("%2d. BOOK - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 	 
			}
			System.out.println("******************************************************************************************\n");
			break;
		case "DVD":
			System.out.println("*******************************************CART*******************************************");
			System.out.println("Ordered items:");
			for (Media media : itemsOrdered) {
				if (media instanceof DigitalVideoDisc) {
					System.out.printf("%2d. DVD  - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 	 
			}
			System.out.println("******************************************************************************************\n");
			break;
		case "CD":
			System.out.println("*******************************************CART*******************************************");
			System.out.println("Ordered items:");
			for (Media media : itemsOrdered) {
				if (media instanceof CompactDisc) {
					System.out.printf("%2d. CD   - %-30s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 	 
			}
			System.out.println("******************************************************************************************\n");
			break;
		}
	}
 
}

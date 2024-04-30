package hust.soict.ict.aims.store;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;


public class Store {
    private static final int MAX_ITEMS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
		if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
			 JOptionPane.showMessageDialog(null, "The store is full!", "Store update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			itemsInStore.add(media);
			//JOptionPane.showMessageDialog(null, "The media has been added", "Store update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void addMedia(Media[] mediaList) {
		if (itemsInStore.size()+mediaList.length>= MAX_ITEMS_IN_STORE) {
			 JOptionPane.showMessageDialog(null, "The store is full!", "Store update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int j=0; j<mediaList.length;j++) {
				addMedia(mediaList[j]);
			}
			JOptionPane.showMessageDialog(null, "The media list has been added", "Store update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void addMedia(Media media1, Media media2) {
		if (itemsInStore.size()>= MAX_ITEMS_IN_STORE-1) {
			 JOptionPane.showMessageDialog(null, "The store is full!", "Store update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			addMedia(media1);
			addMedia(media2);
			JOptionPane.showMessageDialog(null, "The media list has been added", "Store update", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void removeMedia(Media media) {
		 if(itemsInStore.contains(media)) {
			 itemsInStore.remove(media);
		 }
		 
		 else {
			 JOptionPane.showMessageDialog(null, "Media not found in the store!", "Store update", JOptionPane.ERROR_MESSAGE);
		 }
	 }
	 
	 
	 public void removeMedia(String title) {
		 for(Media media : itemsInStore) {
			 if(media.getTitle()== title) {
				 removeMedia(media);
				 break;
			 }
		 }
	 }
    
	 public void print() {
		 if (itemsInStore.size()==0) {
	            System.out.println("The cart is empty.");
	        }
		 else {
			 System.out.println("*******************************************STORE*******************************************");
			 System.out.println("Ordered items:");
			 for (Media media : itemsInStore) {
				if (media instanceof Book) {
					System.out.printf("%2d. BOOK - %-40s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof CompactDisc) {
					System.out.printf("%2d. CD   - %-40s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				} 
				else if (media instanceof DigitalVideoDisc) {
					System.out.printf("%2d. DVD  - %-40s - %-20s: %.2f$ \n",media.getId(), media.getTitle(), media.getCategory(), media.getCost());
				}						 
			 }
			 System.out.println("*******************************************************************************************\n");
		 }
	 }
}

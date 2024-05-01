package hust.soict.ict.aims.store;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;


public class Store {
    private static final int MAX_ITEMS_IN_STORE = 100;
    public ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
		if (getItemsInStore().size() >= MAX_ITEMS_IN_STORE) {
			 JOptionPane.showMessageDialog(null, "The store is full!", "Store update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			getItemsInStore().add(media);
			//JOptionPane.showMessageDialog(null, "The media has been added", "Store update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void addMedia(Media[] mediaList) {
		if (getItemsInStore().size()+mediaList.length>= MAX_ITEMS_IN_STORE) {
			 JOptionPane.showMessageDialog(null, "The store is full!", "Store update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int j=0; j<mediaList.length;j++) {
				addMedia(mediaList[j]);
			}
			//JOptionPane.showMessageDialog(null, "The media list has been added", "Store update", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void addMedia(Media media1, Media media2) {
		if (getItemsInStore().size()>= MAX_ITEMS_IN_STORE-1) {
			 JOptionPane.showMessageDialog(null, "The store is full!", "Store update", JOptionPane.ERROR_MESSAGE);
		}
		else {
			addMedia(media1);
			addMedia(media2);
			//JOptionPane.showMessageDialog(null, "The media list has been added", "Store update", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void removeMedia(Media media) {
		 if(getItemsInStore().contains(media)) {
			 getItemsInStore().remove(media);
		 }
		 
		 else {
			 JOptionPane.showMessageDialog(null, "Media not found in the store!", "Store update", JOptionPane.ERROR_MESSAGE);
		 }
	 }
	 
	 
	 public void removeMedia(String title) {
		 for(Media media : getItemsInStore()) {
			 if(media.getTitle()== title) {
				 removeMedia(media);
				 break;
			 }
		 }
	 }
    
	 public void print() {
		 if (getItemsInStore().size()==0) {
	            System.out.println("The cart is empty.");
	        }
		 else {
			 System.out.println("*******************************************STORE*******************************************");
			 System.out.println("Ordered items:");
			 for (Media media : getItemsInStore()) {
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


	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}


	public void setItemsInStore(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}
}

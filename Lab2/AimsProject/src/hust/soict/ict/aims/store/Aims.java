package hust.soict.ict.aims.store;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Track;

public class Aims {
	static Scanner info = new Scanner(System.in);
	static Scanner myOption = new Scanner(System.in);
	static Scanner scanner = new Scanner(System.in);
	static Store store = new Store();
	static Cart cart = new Cart();
	static boolean running=true;
	
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void showDetails(Media media) {
        if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            System.out.println("Type: Compact Disc");
            System.out.println("Title: " + cd.getTitle());
            System.out.println("Category: " + cd.getCategory());
            System.out.println("Director: " + cd.getDirector());
            System.out.println("Length: " + cd.getLength());
            System.out.println("Cost: " + cd.getCost());
            System.out.println("Artist: " + cd.getArtist());
            System.out.println("Tracks:");
            for (Track track : cd.getTracks()) {
                System.out.println("  - Title: " + track.getTitle() + ", Length: " + track.getLength());
            }
        } else if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            System.out.println("Type: Digital Video Disc");
            System.out.println("Title: " + dvd.getTitle());
            System.out.println("Category: " + dvd.getCategory());
            System.out.println("Director: " + dvd.getDirector());
            System.out.println("Length: " + dvd.getLength());
            System.out.println("Cost: " + dvd.getCost());
        } else if (media instanceof Book) {
            Book book = (Book) media;
            System.out.println("Type: Book");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Category: " + book.getCategory());
            System.out.println("Authors:");
            for (String author : book.getAuthors()) {
                System.out.println("  - " + author);
            }
            System.out.println("Cost: " + book.getCost());
        } else {
            System.out.println("Unsupported media type.");
        }
	}
	
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void storeUpdateMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static Media createNewMedia() {
        System.out.println("Choose media type: ");
        System.out.println("1. Book");
        System.out.println("2. CD");
        System.out.println("3. DVD");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter title:");
        String title = scanner.nextLine();

        System.out.println("Enter category:");
        String category = scanner.nextLine();

        System.out.println("Enter cost:");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
            	System.out.println("Enter number of authors:");
                int numAuthors = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                ArrayList<String> authors = new ArrayList<>();
                for (int i = 0; i < numAuthors; i++) {
                    System.out.println("Enter author " + (i + 1) + ":");
                    String author = scanner.nextLine();
                    authors.add(author);
                }
                return new Book(title, category, authors, cost);
            case 2:
                System.out.println("Enter artist:");
                String artist = scanner.nextLine();
                System.out.println("Enter director:");
                String directorCD = scanner.nextLine();
                System.out.println("Enter length:");
                int lengthCD = scanner.nextInt();
                CompactDisc cd = new CompactDisc(title, category, directorCD, null,lengthCD , cost, artist);
                // Add tracks to the CD
                // You can implement this part based on your specific requirements
                return cd;
            case 3:
                System.out.println("Enter director:");
                String directorDVD = scanner.nextLine();
                System.out.println("Enter length:");
                int lengthDVD = scanner.nextInt();
                return new DigitalVideoDisc(title, category, directorDVD, lengthDVD, cost);
            default:
                System.out.println("Invalid choice!");
                return null;
        }
    }
	
	public static Media findMedia(String title,Store store) {		
		for (Media media : store.itemsInStore) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				showDetails(media);
				return media;
			}
		}
		System.out.println("Item not found in the store");
		return null;
	}
	
	public static Media findMedia(String title,Cart cart) {		
		for (Media media : cart.itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				showDetails(media);
				return media;
			}
		}
		System.out.println("Item not found in the cart");
		return null;
	}
	
	//Functions for each options
	public static void startMenu() {
		showMenu();
		int choice = myOption.nextInt();
		switch (choice) {
		case 0:
			running= false;
			break;
		case 1:
			viewStore();
			break;
		case 2:
			
		case 3:
			cartView();
			break;
		}
	}
	
	
	public static void viewStore() {
		storeMenu();
		int choice = myOption.nextInt();
		switch (choice) {
		case 0:
			startMenu();
			break;
		case 1:
			System.out.println("Please enter the title of the media");
			String title = info.nextLine();
			if(findMedia(title,store)!= null) {
				showDetails(findMedia(title, store));
				mediaDetails(findMedia(title,store));
			}
			else {
				System.out.println("The media is not found!");
				viewStore();
			}
			viewStore();
			break;
		case 2:
			store.print();
			System.out.println("Please enter the title of the media");
			String titleAdd = info.nextLine();
			if(findMedia(titleAdd,store)!= null) {
				showDetails(findMedia(titleAdd, store));
				cart.addMedia(findMedia(titleAdd, store));
				System.out.println("Number of medium in the cart: "+cart.itemsOrdered.size());
			}
			else {
				System.out.println("The media is not found!");
				viewStore();
			}
			viewStore();
			break;
		case 3:
			store.print();
			System.out.println("Please enter the title of the media");
			String titlePlay = info.nextLine();
			if(findMedia(titlePlay,store)!= null) {
				Media media=findMedia(titlePlay, store);
				showDetails(findMedia(titlePlay, store));
				if (media instanceof Book) {
					System.out.println("This funtion does not run with book!");
				}
				else if (media instanceof CompactDisc){
					((CompactDisc) media).play();
				}
				else {
					((DigitalVideoDisc) media).play();
				}
			}
			else {
				System.out.println("The media is not found!");
				viewStore();
			}
			viewStore();
			break;
		case 4:
			cart.print();
			viewStore();
			break;
		default:
			System.out.println("Please enter an exist option");
			viewStore();
			break;
			
		}
	}
	
	public static void mediaDetails(Media media) {
		mediaDetailsMenu();
		int choice = myOption.nextInt();
		switch (choice) {
		case 0:
			viewStore();
			break;
		case 1:
			cart.addMedia(media);
			mediaDetails(media);
			break;
		case 2:
			if (media instanceof Book) {
				System.out.println("This funtion does not run with book!");
			}
			else if (media instanceof CompactDisc){
				((CompactDisc) media).play();
			}
			else {
				((DigitalVideoDisc) media).play();
			}
			break;
		default:
			System.out.println("Please enter an exist option");
			mediaDetails(media);
			break;
		}
		
	}
	
	public static void storeUpdate() {
		storeUpdateMenu();
		int choice = myOption.nextInt();
		switch (choice) {
		case 0:
			startMenu();
			break;
		case 1:
			store.addMedia(createNewMedia());
			storeUpdate();
			break;
		case 2:
			System.out.println("Please enter the title of the media");
			String titleDelete = info.nextLine();
			if(findMedia(titleDelete,store)!= null) {
				Media media = findMedia(titleDelete,store);
				store.removeMedia(media);
			}
			else {
				System.out.println("The media is not found!");
			}
			storeUpdate();
			break;
		}
	}
	
	public static void cartView() {
		cartMenu();
		int choice = myOption.nextInt();
		switch (choice) {
		case 0:
			startMenu();
			break;
		case 1:
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. By ID");
			System.out.println("2. By title");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int choiceF = myOption.nextInt();
			switch(choiceF) {
			case 0:
				cartView();
				break;
			case 1:
				int searchID = myOption.nextInt();
				cart.searchById(searchID);
				cartView();
				break;
			case 2:
				String searchTitle = info.nextLine();
				cart.searchByTitle(searchTitle);
				cartView();
				break;
			default:
				cartView();
				break;
			}
			cartView();
			break;
		case 2:
			sortCart();
			break;
		case 3:
			cart.print();
			System.out.println("Please enter the title of the media");
			String titleRemove = info.nextLine();
			if(findMedia(titleRemove,store)!= null) {
				Media media=findMedia(titleRemove, cart);
				showDetails(media);
				cart.removeMedia(media);
			}
			else {
				System.out.println("The media is not found!");
			}
			cartView();
			break;
		case 4:
			cart.print();
			System.out.println("Please enter the title of the media");
			String titlePlay = info.nextLine();
			if(findMedia(titlePlay,store)!= null) {
				Media media=findMedia(titlePlay, cart);
				showDetails(media);
				if (media instanceof Book) {
					System.out.println("This funtion does not run with book!");
				}
				else if (media instanceof CompactDisc){
					((CompactDisc) media).play();
				}
				else {
					((DigitalVideoDisc) media).play();
				}
			}
			else {
				System.out.println("The media is not found!");
			}
			cartView();
			break;
		case 5:
			System.out.println("Your order is created");
			cart.clean();
		}
	}
	
	public static void sortCart() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by price");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		int choice = myOption.nextInt();
		switch (choice) {
		case 0:
			cartView();
			break;
		case 1:
			Collections.sort(cart.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
			cartView();
	        cart.print();
			break;
		case 2:
			Collections.sort(cart.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
			cartView();
	        cart.print();
			break;
		default:
			System.out.println("Please enter an exist option");
			cartView();
			break;
		}
	}
	
	
	public static void main(String[] args) {
		DigitalVideoDisc[] dvds = new DigitalVideoDisc[12];
        dvds[0] = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 24.95f);
        dvds[1] = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        dvds[2] = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 19.99f);
        dvds[3] = new DigitalVideoDisc("Inception", "Action", "Christopher Nolan", 148, 15.99f);
        dvds[4] = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 12.99f);
        dvds[5] = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 14.99f);
        dvds[6] = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 18.99f);
        dvds[7] = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 11.99f);
        dvds[8] = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 13.99f);
        dvds[9] = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 16.99f);
        dvds[10] = new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowskis", 136, 14.99f);
        dvds[11] = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 17.99f);

        store.addMedia(dvds);

        // Adding books
        Book[] books = new Book[5];
        books[0] = new Book("To Kill a Mockingbird", "Classic", 9.99f);
        books[1] = new Book("1984", "Fiction", 8.99f);
        books[2] = new Book("The Great Gatsby", "Classic", 10.99f);
        books[3] = new Book("The Catcher in the Rye", "Fiction", 7.99f);
        books[4] = new Book("Animal Farm", "Fiction", 6.99f);

        store.addMedia(books);

        // Adding CDs
        ArrayList<Track> tracks1 = new ArrayList<>();
        CompactDisc[] cds = new CompactDisc[5];
        cds[0] = new CompactDisc("The Beatles - Abbey Road", "Rock", "The Beatles",tracks1, 19.99f);
        cds[0].addTrack(new Track("Come Together", 265));
        cds[0].addTrack(new Track("Something", 184));
        cds[0].addTrack(new Track("Oh! Darling", 210));
        cds[0].addTrack(new Track("Here Comes the Sun", 185));
        cds[0].addTrack(new Track("Because", 162));

        ArrayList<Track> tracks2 = new ArrayList<>();
        cds[1] = new CompactDisc("Michael Jackson - Thriller", "Pop", "Michael Jackson", tracks2, 17.99f);
        cds[1].addTrack(new Track("Wanna Be Startin' Somethin'", 362));
        cds[1].addTrack(new Track("Thriller", 357));
        cds[1].addTrack(new Track("Beat It", 258));
        cds[1].addTrack(new Track("Billie Jean", 294));
        cds[1].addTrack(new Track("Human Nature", 207));

        ArrayList<Track> tracks3 = new ArrayList<>();
        cds[2] = new CompactDisc("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd",tracks3 ,21.99f);
        cds[2].addTrack(new Track("Speak to Me", 67));
        cds[2].addTrack(new Track("Breathe", 163));
        cds[2].addTrack(new Track("On the Run", 213));
        cds[2].addTrack(new Track("Time", 413));
        cds[2].addTrack(new Track("The Great Gig in the Sky", 276));
       
        ArrayList<Track> tracks4 = new ArrayList<>();
        cds[3] = new CompactDisc("Led Zeppelin - IV", "Rock", "Led Zeppelin",tracks4 , 18.99f);
        cds[3].addTrack(new Track("Black Dog", 296));
        cds[3].addTrack(new Track("Rock and Roll", 220));
        cds[3].addTrack(new Track("Stairway to Heaven", 482));
        cds[3].addTrack(new Track("Misty Mountain Hop", 278));
        cds[3].addTrack(new Track("When the Levee Breaks", 407));

        ArrayList<Track> tracks5 = new ArrayList<>();
        cds[4] = new CompactDisc("The Rolling Stones - Sticky Fingers", "Rock", "The Rolling Stones", tracks5, 20.99f);
        cds[4].addTrack(new Track("Brown Sugar", 209));
        cds[4].addTrack(new Track("Sway", 213));
        cds[4].addTrack(new Track("Wild Horses", 342));
        cds[4].addTrack(new Track("Can't You Hear Me Knocking", 421));
        cds[4].addTrack(new Track("You Gotta Move", 164));

        store.addMedia(cds);
		while(running) {
			startMenu();
				
		}
	}

}

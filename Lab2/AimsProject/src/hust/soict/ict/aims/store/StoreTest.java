package hust.soict.ict.aims.store;

import hust.soict.ict.aims.disc.DigitalVideoDisc;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		
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
        
		store.addDigitalVideoDisc(dvds);
		store.removeDigitalVideoDisc("Titanic");
		store.print();

	}
}

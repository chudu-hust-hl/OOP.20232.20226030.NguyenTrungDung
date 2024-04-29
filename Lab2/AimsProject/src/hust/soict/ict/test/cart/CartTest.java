package hust.soict.ict.test.cart;

import java.util.ArrayList;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Adding DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Action", "Christopher Nolan", 148, 12.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 14.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 11.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 10.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(dvd4);
        cart.addMedia(dvd5);

        // Adding books
        Book book1 = new Book("To Kill a Mockingbird", "Classic", 9.99f);
        Book book2 = new Book("1984", "Fiction", 8.99f);
        Book book3 = new Book("The Great Gatsby", "Classic", 10.99f);
        Book book4 = new Book("The Catcher in the Rye", "Fiction", 7.99f);
        Book book5 = new Book("Animal Farm", "Fiction", 6.99f);

        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.addMedia(book4);
        cart.addMedia(book5);

        // Adding CDs
        ArrayList<Track> tracks1 = new ArrayList<>();
        CompactDisc cd1 = new CompactDisc("The Beatles - Abbey Road", "Rock", "The Beatles",tracks1, 19.99f);
        cd1.addTrack(new Track("Come Together", 265));
        cd1.addTrack(new Track("Something", 184));
        cd1.addTrack(new Track("Oh! Darling", 210));
        cd1.addTrack(new Track("Here Comes the Sun", 185));
        cd1.addTrack(new Track("Because", 162));

        
        ArrayList<Track> tracks2 = new ArrayList<>();
        CompactDisc cd2 = new CompactDisc("Michael Jackson - Thriller", "Pop", "Michael Jackson",tracks2, 17.99f);
        cd2.addTrack(new Track("Wanna Be Startin' Somethin'", 362));
        cd2.addTrack(new Track("Thriller", 357));
        cd2.addTrack(new Track("Beat It", 258));
        cd2.addTrack(new Track("Billie Jean", 294));
        cd2.addTrack(new Track("Human Nature", 207));

        
        ArrayList<Track> tracks3 = new ArrayList<>();
        CompactDisc cd3 = new CompactDisc("Pink Floyd", "Progressive Rock", "Pink Floyd",tracks3 , 21.99f);
        cd3.addTrack(new Track("Speak to Me", 67));
        cd3.addTrack(new Track("Breathe", 163));
        cd3.addTrack(new Track("On the Run", 213));
        cd3.addTrack(new Track("Time", 413));
        cd3.addTrack(new Track("The Great Gig in the Sky", 276));

        
        ArrayList<Track> tracks4 = new ArrayList<>();
        CompactDisc cd4 = new CompactDisc("Led Zeppelin - IV", "Rock", "Led Zeppelin",tracks4 , 18.99f);
        cd4.addTrack(new Track("Black Dog", 296));
        cd4.addTrack(new Track("Rock and Roll", 220));
        cd4.addTrack(new Track("Stairway to Heaven", 482));
        cd4.addTrack(new Track("Misty Mountain Hop", 278));
        cd4.addTrack(new Track("When the Levee Breaks", 407));

        
        ArrayList<Track> tracks5 = new ArrayList<>();
        CompactDisc cd5 = new CompactDisc("Sticky Fingers", "Rock", "The Rolling Stones", tracks5, 20.99f);
        cd5.addTrack(new Track("Brown Sugar", 209));
        cd5.addTrack(new Track("Sway", 213));
        cd5.addTrack(new Track("Wild Horses", 342));
        cd5.addTrack(new Track("Can't You Hear Me Knocking", 421));
        cd5.addTrack(new Track("You Gotta Move", 164));

        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(cd3);
        cart.addMedia(cd4);
        cart.addMedia(cd5);

        cart.searchByType("Book");
    }
}

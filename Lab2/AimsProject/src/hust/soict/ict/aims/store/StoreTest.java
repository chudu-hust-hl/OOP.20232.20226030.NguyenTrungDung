package hust.soict.ict.aims.store;

import java.util.ArrayList;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Track;

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

        store.removeMedia("Titanic");
        store.print();
    }
}

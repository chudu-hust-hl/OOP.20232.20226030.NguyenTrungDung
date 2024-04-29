package hust.soict.ict.aims.media;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, String director, ArrayList<Track> tracks, float cost) {
        super(title, category, director, cost);
    }

    public CompactDisc(String title, String category, String director, ArrayList<Track> tracks, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    // Getter and setter for artist
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public void addTrack(Track newTrack) {
    	if(tracks.contains(newTrack)) {
    		JOptionPane.showMessageDialog(null, "Track is already in the CD", "Duplicate Track", JOptionPane.ERROR_MESSAGE);
    	}
    	else {
    		tracks.add(newTrack);
    	}
    }
    
    public void removeTrack(Track trackToRemove) {
        if (tracks.contains(trackToRemove)) {
            tracks.remove(trackToRemove);
        } else {
            JOptionPane.showMessageDialog(null, "Track is not in the CD", "Track Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package hust.soict.ict.aims.media;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CompactDisc extends Disc {
    private String artist;
    public ArrayList<Track> tracks;

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, String director, ArrayList<Track> tracks, float cost) {
        super(title, category, director, cost);
        this.tracks = tracks;
        setLengthFromTracks();
    }
    

    public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String director, ArrayList<Track> tracks, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks;
        setLengthFromTracks();
    }

    // Getter and setter for artist
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public void setLengthFromTracks() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        setLength(totalLength);
    }
    
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength());

        // Loop through each track and play it
        for (Track track : tracks) {
            track.play();
        }
    }

    
    public void addTrack(Track newTrack) {
    	if(tracks.contains(newTrack)) {
    		JOptionPane.showMessageDialog(null, "Track is already in the CD", "Duplicate Track", JOptionPane.ERROR_MESSAGE);
    	}
    	else {
    		tracks.add(newTrack);
    		setLengthFromTracks();
    	}
    }
    
    public void addTrack(ArrayList<Track> tracksList) {
    	for(Track track : tracksList) {
    		addTrack(track);
    	}
    }
    
    public void removeTrack(Track trackToRemove) {
        if (tracks.contains(trackToRemove)) {
            tracks.remove(trackToRemove);
        } else {
            JOptionPane.showMessageDialog(null, "Track is not in the CD", "Track Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void print() {
		 if (tracks.size()==0) {
	        System.out.println("The cart is empty.");
	     }
		 else {
			 System.out.println("**************************************CDs Track**************************************");
			 System.out.println("Ordered items:");
			 for (Track track : tracks) {
				 System.out.printf("Track: %-35s - %-15s \n", track.getTitle(), track.getLength());		 
			 }
			 System.out.println("*************************************************************************************\n");
		 }
	 }
}

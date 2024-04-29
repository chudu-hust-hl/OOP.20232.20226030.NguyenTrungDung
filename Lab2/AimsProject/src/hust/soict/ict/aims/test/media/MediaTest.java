package hust.soict.ict.aims.test.media;

import java.util.ArrayList;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.Track;

public class MediaTest {
    public static void main(String[] args) {
        // Create a list of tracks
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Track 1", 120));
        tracks.add(new Track("Track 2", 180));
        tracks.add(new Track("Track 3", 150));

        // Create a CompactDisc object
        CompactDisc cd = new CompactDisc("CD Title", "Category", "Director", tracks, 19.99f);

        
        System.out.println("CD Length: " + cd.getLength());

        // Add a new track to the CD
        Track newTrack = new Track("New Track", 200);
        cd.addTrack(newTrack);

        // Attempt to add the same track again
        cd.addTrack(newTrack);

        // Remove a track from the CD
        cd.removeTrack(newTrack);

        // Attempt to remove a non-existent track
        Track nonExistentTrack = new Track("Non-Existent Track", 300);
        cd.removeTrack(nonExistentTrack);

        // Print information about the CD after modifications
        System.out.println("Updated CD Length: " + cd.getLength());
        cd.print();
        cd.play();
    }
}

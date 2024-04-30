package hust.soict.ict.aims.media;
import java.util.Comparator;
import hust.soict.ict.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        // First compare by cost
        int costComparison = Float.compare(o1.getCost(), o2.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        
        // If cost is equal, compare by title
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

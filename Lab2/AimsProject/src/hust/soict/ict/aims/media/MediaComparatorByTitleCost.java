package hust.soict.ict.aims.media;
import java.util.Comparator;
import hust.soict.ict.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        // First compare by title
        int titleComparison = o1.getTitle().compareTo(o2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        
        // If titles are equal, compare by cost
        return Float.compare(o1.getCost(), o2.getCost());
    }
}

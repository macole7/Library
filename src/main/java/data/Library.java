package data;

import java.util.Arrays;
import java.util.Comparator;

public class Library {

    public static final int INITIAL_CAPACITY = 1;
    private Publication[] publications;
    private int publicationsNumber;

    public Library() {
        publications = new Publication[INITIAL_CAPACITY];
    }

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public Publication[] getPublications() {
        return publications;
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public void addPublication(Publication publication) throws ArrayIndexOutOfBoundsException {
        if (publicationsNumber == publications.length) {
            publications = Arrays.copyOf(publications, publications.length * 2);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }
    public void removePublication(Publication publication){
        if(publication == null){
            return;
        }
        final int NOT_FOUND = -1;
        int found = NOT_FOUND;
        int i=0;
        while (i<publications.length && found == NOT_FOUND){
            if(publication.equals(publications[i])){
                found = i;
            } else {
                i++;
            }
        }
        if(found != NOT_FOUND){
            System.arraycopy(publications, found + 1, publications, found, publications.length - found);
            publicationsNumber--;
        }
    }
    public static class AlphabeticalComparator implements Comparator<Publication>{
        @Override
        public int compare(Publication o1, Publication o2) {
            if(o1 == null && o2 == null){
                return 0;
            }
            if(o1 == null){
                return 1;
            }
            if(o2==null){
                return -1;
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
    public static class DateComparator implements Comparator<Publication>{

        @Override
        public int compare(Publication o1, Publication o2) {
            if(o1 == null && o2 == null){
                return 0;
            }
            if(o1 == null){
                return 1;
            }
            if(o2 == null){
                return -1;
            }
            Integer i1 = o1.getReleaseDate();
            Integer i2 = o2.getReleaseDate();
            return -i1.compareTo(i2);
        }
    }
}

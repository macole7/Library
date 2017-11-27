package data;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, Publication> publications;
    private Map<String, LibraryUser> users;

    public Library(){
        publications = new HashMap<>();
        users = new HashMap<String, LibraryUser>();
    }

    public int getPublicationsNumber(){
        return this.publications.size();
    }

    public Map<String, Publication> getPublications(){
        return publications;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }
    public void addUser(LibraryUser user){
        users.put(user.getPesel(), user);
    }

    public void addPublication(Publication publication) {
        publications.put(publication.getTitle(), publication);
    }

    public void removePublication(Publication publication){
        if(publications.containsValue(publication)){
            publications.remove(publication.getTitle());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Publication p: publications.values()){
            stringBuilder.append(p);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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

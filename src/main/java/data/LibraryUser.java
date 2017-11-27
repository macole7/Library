package data;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends User {

    private List<Publication> publicationHistory;
    private List<Publication> borrowedPublications;

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
        publicationHistory = new ArrayList<>();
        borrowedPublications = new ArrayList<>();
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    private void addPublicationToHistory(Publication publication) {
        publicationHistory.add(publication);
    }

    public void borrowPublication(Publication publication) {
        borrowedPublications.add(publication);
    }

    public boolean returnPubliction(Publication publication) {
        boolean result = false;
        if (borrowedPublications.remove(publication)) {
            result = true;
            addPublicationToHistory(publication);
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(!super.equals(obj) || getClass() != obj.getClass()){
            return false;
        }
        LibraryUser other = (LibraryUser)obj;
        if(!publicationHistory.equals(other.publicationHistory)){
            return false;
        }
        if(!borrowedPublications.equals(other.borrowedPublications)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((publicationHistory != null? publicationHistory.hashCode():0));
        result = 31 * result + ((borrowedPublications != null? borrowedPublications.hashCode():0));
        return result;
    }
}
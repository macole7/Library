package utils;

import data.*;

public class LibraryUtils {
    public static void printBooks(Library library){
        printPublications(library, Book.class);
    }
    public static void printMagazines(Library library){
        printPublications(library, Magazine.class);
    }

    public static void printPublications(Library library, Class cl){
        long countPublications = library.getPublications().values().stream().filter(cl::isInstance).
                sorted(new Library.AlphabeticalComparator()).peek(System.out::println).count();
        if(countPublications == 0){
            System.out.println("There is not any " + cl.getSimpleName() + " in library");
        }
    }
    public static void printUsers(Library library){
        library.getUsers().values().stream().sorted((a,b)-> a.getLastName().compareTo(b.getLastName())).
                forEach(System.out::println);
    }
}

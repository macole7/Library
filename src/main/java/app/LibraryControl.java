package app;

import data.Book;
import data.Library;
import data.Magazine;
import utils.DataReader;
import utils.LibraryUtils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {
    private DataReader dataReader;
    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        library = new Library();
    }

    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                    case ADD_BOOK:
                        addBook();
                        break;
                    case ADD_MAGAZINE:
                        addMagazine();
                        break;
                    case PRINT_BOOKS:
                        printBooks();
                        break;
                    case PRINT_MAGAZINES:
                        printMagazines();
                        break;
                    case EXIT:
                }
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch exception");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Chosen option doesn't exist, try again");
            }
        }
        dataReader.close();
    }

    private void printOptions() {
        System.out.println("Choose option");
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addPublication(book);
    }

    private void printBooks() {
        LibraryUtils.printBooks(library);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }
}

    enum Option {

    EXIT(0, "EXIT"), ADD_BOOK(1, "Add new book"), ADD_MAGAZINE(2, "Add new magazine"),
    PRINT_BOOKS(3, "Print books"), PRINT_MAGAZINES(4, "Print magazines");

    private int value;
    private String description;

    Option(int value, String description){
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + ", " + description;
    }
    public static Option createFromInt(int option) throws NoSuchElementException{
        Option result = null;
        try{
            result = Option.values()[option];
        } catch (NoSuchElementException e){
            throw new NoSuchElementException("Wrong id");
        }
        return result;
    }
}


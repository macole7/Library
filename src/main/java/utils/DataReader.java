package utils;

import data.Book;
import data.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner;
    public DataReader(){
        scanner = new Scanner(System.in);
    }
    public void close (){
        scanner.close();
    }
    public int getInt() throws NumberFormatException{
        int number = 0;
        try{
            number = scanner.nextInt();
        } catch (InputMismatchException e){
            throw new NumberFormatException("Input number in wrong format");
        } finally {
            scanner.nextLine();
        }
        return number;
    }

    public Book readAndCreateBook() throws InputMismatchException {
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Author:");
        String author = scanner.nextLine();
        System.out.println("Publisher:");
        String publisher = scanner.nextLine();
        System.out.println("isbn:");
        String isbn = scanner.next();
        System.out.println("Release date:");
        int pages = 0;
        int releaseDate = 0;
        try {
            releaseDate = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Number of pages");
            pages = scanner.nextInt();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw e;
        }
        return new Book(title, publisher, releaseDate,author, pages, isbn);
    }
    public Magazine readAndCreateMagazine() throws InputMismatchException{
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Language:");
        String language = scanner.nextLine();
        System.out.println("Release date:");
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Month");
            month = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Day");
            day = scanner.nextInt();
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw e;
        }
        return new Magazine(title, publisher,year, month, day, language);
    }
}

package data;

public class Book extends Publication {
    private String author;
    private int pages;
    private String isbn;

    public Book(String title, String publisher, int releaseDate, String author, int pages, String isbn) {
        super(title, publisher, releaseDate);
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(getTitle()).append(", ").append(getAuthor()).append(", ").
                append(getReleaseDate()).append(", ").append(getPages()).append(", ").
                append(getPublisher()).append(", ").append(getIsbn());
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book)obj;
        if(!author.equals(other.author)){
            return false;
        }
        if(pages != other.pages){
            return false;
        }
        if(!isbn.equals(isbn)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = pages;
        result = 31 * result + (author != null? author.hashCode():0);
        result = 31 * result + (isbn != null? isbn.hashCode():0);
        return result;
    }
}

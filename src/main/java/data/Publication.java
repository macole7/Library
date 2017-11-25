package data;

public abstract class Publication implements Comparable<Publication> {
    private int releaseDate;
    private String title;
    private String publisher;

    protected Publication(String title, String publisher, int releaseDate) {
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareTo(o.title);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj == null||getClass()!= obj.getClass()) {
            return false;
        }
        Publication other = (Publication)obj;
        if(releaseDate != other.releaseDate ) {
            return false;
        }
        if(!title.equals(other.title)){
            return false;
        }
        if(!publisher.equals(other.publisher)){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = releaseDate;
        result = result * 31 + (title != null? title.hashCode():0);
        result = result * 31 + (publisher != null? publisher.hashCode(): 0);
        return result;
    }
}

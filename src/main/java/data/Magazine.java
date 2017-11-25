package data;

public class Magazine extends Publication {

    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, int releaseDate, int month, int day, String language) {
        super(title, publisher, releaseDate);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(getTitle()).append(", ").append(getPublisher()).append(", ").
                append(getReleaseDate()).append(", ").append(getMonth()).append(", ").
                append(getDay()).append(", ").append(getLanguage());
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
        Magazine other = (Magazine) obj;
        if (month != other.month) {
            return false;
        }
        if (day != other.day) {
            return false;
        }
        if (!language.equals(other.language)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = month;
        result = 31 * result + day;
        result = 31 * result + (language != null? language.hashCode(): 0);
        return result;
    }
}
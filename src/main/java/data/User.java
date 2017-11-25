package data;

public abstract class User {
    private String firstName;
    private String lastName;
    private int pesel;

    public User(String firstName, String lastName, int pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        User other = (User)obj;
        if(!firstName.equals(other.firstName)){
            return false;
        }
        if(!lastName.equals(other.lastName)){
            return false;
        }
        if(pesel != other.pesel){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = pesel;
        result = result * 31 + (firstName != null? firstName.hashCode():0);
        result = result * 31 + (lastName != null? lastName.hashCode():0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(firstName).append(", ").append(lastName).append(", ").append(pesel);
        return stringBuilder.toString();
    }
}

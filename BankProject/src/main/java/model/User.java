package model;

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String  extraUser;

    public User() {
        super();
    }

    public User(String userName, String firstName, String lastName, String extraUser) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.extraUser = extraUser;
    }
    // constructor if there is no extra user
    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


    public String getExtraUser() {
        return extraUser;
    }

    public void setExtraUser(String extraUser) {
        this.extraUser = extraUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", extraUser='" + extraUser + '\'' +
                '}';
    }
}

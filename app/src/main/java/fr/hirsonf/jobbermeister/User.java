package fr.hirsonf.jobbermeister;

import java.util.Date;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class User {
    public String email;
    public String password;
    public String lastName;
    public String firstName;
    public Date birthDate;
    public String street;
    public String city;
    public String zip;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}

package fr.hirsonf.jobbermeister;

import java.util.Date;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class User {
    public static String email;
    public static String password;
    public static String lastName;
    public static String firstName;
    public static Date birthDate;

    public User(String e, String p){
        this.email = e;
        this.password = p;
    }
}

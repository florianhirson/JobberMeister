package fr.hirsonf.jobbermeister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Employer extends User {
    public static String phone;
    public static String fax;
    public static String companyEmail;
    public static String street;
    public static String city;
    public static String zip;
    public static List<Offer> offers;

    public Employer(String e, String p){
        super(e, p);
        this.offers = new ArrayList<Offer>();
    }
}

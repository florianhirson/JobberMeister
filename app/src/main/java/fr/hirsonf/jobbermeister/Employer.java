package fr.hirsonf.jobbermeister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Employer extends User {
    public String phone;
    public String fax;
    public String companyEmail;
    public String street;
    public String city;
    public String zip;
    public List<Offer> offers;

    public Employer(){
        super();
        this.offers = new ArrayList<Offer>();
    }
}

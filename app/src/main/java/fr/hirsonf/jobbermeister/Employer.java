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
    public String position;
    public List<Offer> offers;

    public Employer(){
        super();
        this.offers = new ArrayList<Offer>();
    }

    @Override
    public String toString() {
        return "Employer{" +
                "phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", position='" + position + '\'' +
                ", offers=" + offers +
                super.toString() +
                '}';
    }
}

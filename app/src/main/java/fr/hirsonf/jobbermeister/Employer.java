package fr.hirsonf.jobbermeister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Employer extends User {
    public String companyName;
    public String position;
    public String phone;
    public String fax;
    public String companyEmail;
    public List<Offer> offers;

    public Employer(){
        super();
        this.offers = new ArrayList<Offer>();
    }

    @Override
    public String toString() {
        return "Employer{" +
                "companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", offers=" + offers +
                super.toString() +
                '}';
    }
}

package fr.hirsonf.jobbermeister.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rémi on 25-Oct-17.
 */

public class Employer extends User implements Serializable {
    private String companyName;
    private String position;
    private String phone;
    private String fax;
    private String companyEmail;
    private List<Offer> offers;

    public Employer(){
        super();
        this.offers = new ArrayList<Offer>();
    }

    public Employer(User user) {
        super();
        this.setLogin(user.getLogin());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setLastName(user.getLastName());
        this.setFirstName(user.getFirstName());
        this.setBirthDate(user.getBirthDate());
        this.setStreet(user.getStreet());
        this.offers = new ArrayList<Offer>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

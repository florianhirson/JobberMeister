package fr.hirsonf.jobbermeister;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Applicant  extends User implements Serializable{
    private List<Diploma> diplomas;
    private List<Experience> experiences;
    private String mobile;
    private String description;
    private String domainSought;
    private String typeOfContractSought;

    public Applicant(){
        super();
        this.diplomas = new ArrayList<Diploma>();
        this.experiences = new ArrayList<Experience>();
    }

    public Applicant(User user) {
        super();
        this.setLogin(user.getLogin());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setLastName(user.getLastName());
        this.setFirstName(user.getFirstName());
        this.setBirthDate(user.getBirthDate());
        this.setStreet(user.getStreet());
        this.diplomas = new ArrayList<Diploma>();
        this.experiences = new ArrayList<Experience>();
    }

    public List<Diploma> getDiplomas() {
        return diplomas;
    }

    public void setDiplomas(List<Diploma> diplomas) {
        this.diplomas = diplomas;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomainSought() {
        return domainSought;
    }

    public void setDomainSought(String domainSought) {
        this.domainSought = domainSought;
    }

    public String getTypeOfContractSought() {
        return typeOfContractSought;
    }

    public void setTypeOfContractSought(String typeOfContractSought) {
        this.typeOfContractSought = typeOfContractSought;
    }



    @Override
    public String toString() {
        return "Applicant{" +
                "diplomas=" + diplomas +
                ", experiences=" + experiences +
                ", mobile='" + mobile + '\'' +
                ", description='" + description + '\'' +
                ", domainSought='" + domainSought + '\'' +
                ", typeOfContractSought='" + typeOfContractSought + '\'' +
                super.toString() +
                '}';
    }
}

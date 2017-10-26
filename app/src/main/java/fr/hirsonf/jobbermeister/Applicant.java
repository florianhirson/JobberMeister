package fr.hirsonf.jobbermeister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Applicant extends User {
    public String phone;
    public String street;
    public String city;
    public String zip;
    public String description;
    public List<Diploma> diplomas;
    public List<Experience> experiences;
    public String domainSought;
    public String typeOfContractSought;

    public Applicant(){
        super();
        this.diplomas = new ArrayList<Diploma>();
        this.experiences = new ArrayList<Experience>();
    }
}

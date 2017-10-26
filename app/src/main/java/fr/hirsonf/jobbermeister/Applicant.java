package fr.hirsonf.jobbermeister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Applicant extends User {
    public List<Diploma> diplomas;
    public List<Experience> experiences;
    public String mobile;
    public String description;
    public String domainSought;
    public String typeOfContractSought;

    public Applicant(){
        super();
        this.diplomas = new ArrayList<Diploma>();
        this.experiences = new ArrayList<Experience>();
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

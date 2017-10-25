package fr.hirsonf.jobbermeister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Applicant extends User {
    public static String phone;
    public static String street;
    public static String city;
    public static String zip;
    public static String description;
    public static List<Diploma> diplomas;
    public static List<Experience> experiences;
    public static String domainSought;
    public static String typeOfContractSought;

    public Applicant(String e, String p){
        super(e, p);
        this.diplomas = new ArrayList<Diploma>();
        this.experiences = new ArrayList<Experience>();
    }
}

package fr.hirsonf.jobbermeister.model;

/**
 * Created by Rémi on 25-Oct-17.
 */

class Diploma {
    public String name;
    public String school;
    public String year;

    public Diploma(String n, String s, String y){
        this.name = n;
        this.school = s;
        this.year = y;
    }

    @Override
    public String toString() {
        return "Diploma{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
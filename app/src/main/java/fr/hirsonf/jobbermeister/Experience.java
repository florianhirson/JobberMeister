package fr.hirsonf.jobbermeister;

/**
 * Created by Rémi on 25-Oct-17.
 */

class Experience {
    public String domain;
    public String company;
    public Integer duration;

    public Experience(String dom, String c, Integer dur){
        this.domain = dom;
        this.company = c;
        this.duration = dur;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "domain='" + domain + '\'' +
                ", companyName='" + company + '\'' +
                ", duration=" + duration +
                '}';
    }
}

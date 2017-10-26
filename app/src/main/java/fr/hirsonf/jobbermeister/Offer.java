package fr.hirsonf.jobbermeister;

import java.util.Date;

/**
 * Created by Rémi on 25-Oct-17.
 */

class Offer {
    public String title;
    public String description;
    public String domain;
    public String typeOfContract;
    public Double wage;
    public Date startDate;

    @Override
    public String toString() {
        return "Offer{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", domain='" + domain + '\'' +
                ", typeOfContract='" + typeOfContract + '\'' +
                ", wage=" + wage +
                ", startDate=" + startDate +
                '}';
    }
}

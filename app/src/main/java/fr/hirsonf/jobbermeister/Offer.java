package fr.hirsonf.jobbermeister;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Rémi on 25-Oct-17.
 */

class Offer {
    @SerializedName("name")
    @Expose
    public String title;

    @SerializedName("domain")
    @Expose
    public String domain;

    public String typeOfContract;

    @SerializedName("location")
    @Expose
    public String location;

    public String companyName;

    public String description;

    public Double wage;

    public Date startDate;

    @SerializedName("url")
    @Expose
    public String logoURL;


    @Override
    public String toString() {
        return "Offer{" +
                "title='" + title + '\'' +
                ", domain='" + domain + '\'' +
                ", typeOfContract='" + typeOfContract + '\'' +
                ", location='" + location + '\'' +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", wage=" + wage +
                ", startDate=" + startDate +
                ", logoURL=" + logoURL +
                '}';
    }
}

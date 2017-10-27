package fr.hirsonf.jobbermeister.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Offer {
    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("domain")
    @Expose
    public String domain;

    public String typeOfContract;

    @SerializedName("location")
    @Expose
    public String location;

    @SerializedName("company")
    @Expose
    public String company;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("wage")
    @Expose
    public String wage;

    @SerializedName("startDate")
    @Expose
    public String startDate;

    @SerializedName("logoURL")
    @Expose
    public String logoURL;


    @Override
    public String toString() {
        return "Offer{" +
                "title='" + title + '\'' +
                ", domain='" + domain + '\'' +
                ", typeOfContract='" + typeOfContract + '\'' +
                ", location='" + location + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", wage=" + wage +
                ", startDate=" + startDate +
                ", logoURL=" + logoURL +
                '}';
    }
}

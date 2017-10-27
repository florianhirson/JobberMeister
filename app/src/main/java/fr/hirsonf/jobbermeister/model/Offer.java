package fr.hirsonf.jobbermeister.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Rémi on 25-Oct-17.
 */

public class Offer {
    @SerializedName("ID")
    @Expose
    public Integer id;

    @SerializedName("img")
    @Expose
    public String logoURL;

    @SerializedName("libelle")
    @Expose
    public String libelle;

    @SerializedName("login")
    @Expose
    public String login;

    @SerializedName("type")
    @Expose
    public String type;

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", logoURL='" + logoURL + '\'' +
                ", libelle='" + libelle + '\'' +
                ", login='" + login + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

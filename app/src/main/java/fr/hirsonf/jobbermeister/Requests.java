package fr.hirsonf.jobbermeister;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by flohi on 26/10/2017.
 */

public class Requests {
    private final String BASE_URL = "http://frene20.iut-infobio.priv.univ-lille1.fr:8080";
    private final String PATH = "/jobber/app/";

    public Requests () {}

    public void doLoginRequest(final Context context, String email, String mdp) {
        Uri.Builder b = Uri.parse(BASE_URL).buildUpon();
        b.path(PATH+email+"/"+mdp);
        String url = b.build().toString();

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Intent homepage = new Intent(context, BrowseOffersActivity.class);
                        context.startActivity(homepage);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(context,
                                    "Error Timeout ! ",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context,
                                    "Error d'authentification ! ",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(context,
                                    "Error de Serveur ! ",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(context,
                                    "Error de Réseau ! ",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(context,
                                    "Error de Parsing ! ",
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }

}

package fr.hirsonf.jobbermeister.cards;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import fr.hirsonf.jobbermeister.activities.BrowseOffersActivity;
import fr.hirsonf.jobbermeister.model.Offer;
import fr.hirsonf.jobbermeister.requests.Requests;

/**
 * Created by flohi on 26/10/2017.
 */

public class Utils {

    public static Context c;
    private static final String TAG = "Utils";

    public static List<Offer> loadProfiles(Context context) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            c = context;

            Requests r = new Requests();
            r.doListOffersRequest(context);

            JSONArray array = r.getArray();
            System.out.println("Array : " + array);
            List<Offer> offersList = new ArrayList<Offer>();
            for (int i = 0; i < array.length(); i++) {
                Offer offer = null;
                try {
                    offer = gson.fromJson(array.getString(i), Offer.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                offersList.add(offer);
            }

            System.out.println(offersList);
            return offersList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Point getDisplaySize(WindowManager windowManager){
        try {
            if(Build.VERSION.SDK_INT > 16) {
                Display display = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }else{
                return new Point(0, 0);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Point(0, 0);
        }
    }
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

}

package fr.hirsonf.jobbermeister.requests;

/**
 * Created by flohi on 27/10/2017.
 * */
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AlertDialog;
        import android.util.Log;
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

        import java.net.HttpURLConnection;

        import fr.hirsonf.jobbermeister.activities.BrowseOffersActivity;
        import fr.hirsonf.jobbermeister.activities.LoginActivity;
        import fr.hirsonf.jobbermeister.activities.RegisterCredentialsActivity;
        import fr.hirsonf.jobbermeister.activities.RegisterProfileActivity;
        import fr.hirsonf.jobbermeister.model.User;

/**
 * Created by flohi on 26/10/2017.
 */

public class Requests {
    private final String BASE_URL = "http://10.19.0.165:8080/jobber/app/";
    String url;
    public Requests () {}

    public void doLoginRequest(final Context context, final String login, final String mdp) {
        url = BASE_URL + login + "/" + mdp;

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
                                    "Error Timeout ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context,
                                    "Error d'authentification ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        } else if (error instanceof ServerError) {
                            Toast.makeText(context,
                                    "Error de Serveur ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(context,
                                    "Error de Réseau ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        } else if (error instanceof ParseError) {
                            Toast.makeText(context,
                                    "Error de Parsing ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        }

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }

    public void doLoginExistRequest(final Context context, final User user) {
        url = BASE_URL + user.getLogin();

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(response != null) {
                            AlertDialog.Builder b = new AlertDialog.Builder(context);
                            b.setMessage(user.getLogin()+" n'est pas disponible !");
                            b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            AlertDialog a = b.create();
                            a.show();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(context,
                                    "Error Timeout ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(context,
                                    "Error d'authentification ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        } else if (error instanceof ServerError) {
                            if(error.networkResponse.statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                                Intent homepage = new Intent(context, RegisterProfileActivity.class);
                                homepage.putExtra("user", user);
                                System.out.println("nouveau login");
                                context.startActivity(homepage);
                            } else {

                                Toast.makeText(context,
                                        "Error de Serveur ! : " + error.getStackTrace(),
                                        Toast.LENGTH_LONG).show();
                                System.out.println("url : " + url);
                                System.out.println(error.getStackTrace());
                            }
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(context,
                                    "Error de Réseau ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        } else if (error instanceof ParseError) {
                            Toast.makeText(context,
                                    "Error de Parsing ! : " + error,
                                    Toast.LENGTH_LONG).show();
                            System.out.println("url : " + url);
                            System.out.println(error);
                        }
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }

}
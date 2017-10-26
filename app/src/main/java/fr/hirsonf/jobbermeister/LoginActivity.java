package fr.hirsonf.jobbermeister;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by flohi on 26/10/2017.
 */

public class LoginActivity extends AppCompatActivity {

    Button login, register;
    EditText email;
    TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.b_login);
        register = findViewById(R.id.b_register);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(LoginActivity.this, RegisterCredentialsActivity.class);
                startActivity(homepage);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFields()) { /*
                    // Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    String url = "http://www.google.com";

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(LoginActivity.this, "Response is: " + response.substring(0, 500), Toast.LENGTH_LONG).show();

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this, "That didn't work !", Toast.LENGTH_SHORT).show();

                        }
                    });
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);
                    */
                    Intent homepage = new Intent(LoginActivity.this, BrowseOffersActivity.class);
                    startActivity(homepage);
                }
            }
        });

    }

    public boolean checkFields() {
        if (email.getText().toString().trim().equals("") || password.getText().toString().trim().equals("")) {
            AlertDialog.Builder b = new AlertDialog.Builder(LoginActivity.this);
            b.setMessage("Veuillez completer tous les champs !");
            b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog a = b.create();
            a.show();
            return false;
        } else if (Model.checkEmail(email.getText()) == false) {
            AlertDialog.Builder b = new AlertDialog.Builder(LoginActivity.this);
            b.setMessage("Le format de l'adresse email est invalide !");
            b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog a = b.create();
            a.show();
            return false;
        }
        return true;
    }
}

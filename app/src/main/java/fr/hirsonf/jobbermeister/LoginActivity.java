package fr.hirsonf.jobbermeister;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static fr.hirsonf.jobbermeister.RegisterCredentialsActivity.isEmailValid;

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
                                    Toast.makeText(LoginActivity.this, "Response is: " + response.substring(0, 500), Toast.LENGTH_SHORT).show();

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
                    Intent homepage = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(homepage);
                }
            }
        });

    }

    public static boolean isEmailValid(CharSequence email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
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
        } else if (!isEmailValid(email.getText())) {
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

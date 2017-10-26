package fr.hirsonf.jobbermeister;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

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
        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).
                getRequestQueue();


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
                if (checkFields()) {
                    String mail = email.getText().toString();
                    String pwd = password.getText().toString();
                    Requests r = new Requests();
                    r.doLoginRequest(LoginActivity.this, mail, pwd);
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

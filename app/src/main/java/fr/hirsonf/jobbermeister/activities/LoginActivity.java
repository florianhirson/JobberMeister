package fr.hirsonf.jobbermeister.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import fr.hirsonf.jobbermeister.R;
import fr.hirsonf.jobbermeister.requests.Requests;


/**
 * Created by flohi on 26/10/2017.
 */

public class LoginActivity extends AppCompatActivity {

    Button register, bLogin, bypass;
    EditText eLogin;
    TextInputEditText ePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.b_register);
        bLogin = findViewById(R.id.b_login);
        bypass = findViewById(R.id.b_bypass);
        eLogin = findViewById(R.id.editTextEmail);
        ePassword = findViewById(R.id.editTextPassword);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(LoginActivity.this, RegisterCredentialsActivity.class);
                startActivity(homepage);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFields()) {

                    String mail = eLogin.getText().toString();
                    String pwd = ePassword.getText().toString();
                    Requests r = new Requests();
                    RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                    r.doLoginRequest(LoginActivity.this, mail, pwd, requestQueue);
                }
            }
        });

        bypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(LoginActivity.this, BrowseOffersActivity.class);
                startActivity(homepage);
            }
        });
    }



    public boolean checkFields() {
        if (eLogin.getText().toString().trim().equals("") || ePassword.getText().toString().trim().equals("")) {
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
        }
        return true;
    }
}

package fr.hirsonf.jobbermeister;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterCredentialsActivity extends AppCompatActivity {
    Button b;
    EditText email;
    TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);

        b = (Button) findViewById(R.id.b_next);
        email = (EditText) findViewById(R.id.editTextEmail);
        password = (TextInputEditText) findViewById(R.id.editTextPassword);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().trim().equals("") || password.getText().toString().trim().equals("")) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterCredentialsActivity.this);
                    b.setMessage("Veuillez completer tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else if (Model.checkEmail(email.getText()) == false) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterCredentialsActivity.this);
                    b.setMessage("Le format de l'adresse email est invalide !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else {
                    Model.user = new User();
                    Model.user.email = email.getText().toString();
                    Model.user.password = password.getText().toString();
                    Intent homepage = new Intent(RegisterCredentialsActivity.this, RegisterProfileActivity.class);
                    startActivity(homepage);
                }

            }
        });
    }
}

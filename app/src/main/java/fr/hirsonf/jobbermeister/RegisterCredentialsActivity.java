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
    EditText mail;
    TextInputEditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);

        b = (Button) findViewById(R.id.b_next);
        mail = (EditText) findViewById(R.id.editTextEmail);
        password = (TextInputEditText) findViewById(R.id.editTextPassword);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean envoi = true;
                if(mail.getText().toString().trim().equals("") || password.getText().toString().trim().equals("")) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterCredentialsActivity.this);
                    b.setMessage("Veuillez completer tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    envoi = false;
                    AlertDialog a = b.create();
                    a.show();
                }

                if(!isEmailValid(mail.getText())) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterCredentialsActivity.this);
                    b.setMessage("Le format de l'adresse mail n'est pas correct !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    envoi = false;
                    AlertDialog a = b.create();
                    a.show();
                }

                if (envoi) {
                    Intent homepage = new Intent(RegisterCredentialsActivity.this, RegisterProfileActivity.class);
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


}

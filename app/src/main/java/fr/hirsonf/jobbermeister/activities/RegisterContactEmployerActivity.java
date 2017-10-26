package fr.hirsonf.jobbermeister.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.hirsonf.jobbermeister.Employer;
import fr.hirsonf.jobbermeister.Model;
import fr.hirsonf.jobbermeister.R;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterContactEmployerActivity extends AppCompatActivity {

    Button b;
    EditText phone, fax, companyEmail, street, city, zip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact_employer);
        b = (Button) findViewById(R.id.button);
        phone = (EditText) findViewById(R.id.editTextPhone);
        fax = (EditText) findViewById(R.id.editTextFax);
        companyEmail = (EditText) findViewById(R.id.editTextCompanyEmail);
        street = (EditText) findViewById(R.id.editTextStreet);
        city = (EditText) findViewById(R.id.editTextCity);
        zip = (EditText) findViewById(R.id.editTextZIP);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.getText().toString().trim().equals("") || fax.getText().toString().trim().equals("") || street.getText().toString().trim().equals("")
                        || city.getText().toString().trim().equals("") || zip.getText().toString().trim().equals("")) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterContactEmployerActivity.this);
                    b.setMessage("Veuillez completer tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else if (Model.checkEmail(companyEmail.getText()) == false) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterContactEmployerActivity.this);
                    b.setMessage("Le format de l'adresse email est invalide !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else {
                    ((Employer) Model.user).phone = phone.getText().toString();
                    ((Employer) Model.user).fax = fax.getText().toString();
                    Model.user.street = street.getText().toString();
                    Model.user.city = city.getText().toString();
                    Model.user.zip = zip.getText().toString();
                    Intent homepage = new Intent(RegisterContactEmployerActivity.this, RegisterCompanyActivity.class);
                    startActivity(homepage);
                }
            }
        });
    }
}

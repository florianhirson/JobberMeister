package fr.hirsonf.jobbermeister.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.hirsonf.jobbermeister.Employer;
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
        b =  findViewById(R.id.button);
        phone = findViewById(R.id.editTextPhone);
        fax =  findViewById(R.id.editTextFax);
        companyEmail = findViewById(R.id.editTextCompanyEmail);
        street = findViewById(R.id.editTextStreet);
        city =  findViewById(R.id.editTextCity);
        zip =  findViewById(R.id.editTextZIP);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Employer employer = (Employer)i.getSerializableExtra("employer");

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
                } else if (employer.checkEmail(companyEmail.getText()) == false) {
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


                    employer.setPhone(phone.getText().toString());
                    employer.setFax(fax.getText().toString());
                    employer.setStreet(street.getText().toString());
                    employer.setCity(city.getText().toString());
                    employer.setZip(zip.getText().toString());

                    Intent homepage = new Intent(RegisterContactEmployerActivity.this, RegisterCompanyActivity.class);
                    homepage.putExtra("employer", employer);
                    Log.e("My Application", employer.toString());
                    startActivity(homepage);
                }
            }
        });
    }
}

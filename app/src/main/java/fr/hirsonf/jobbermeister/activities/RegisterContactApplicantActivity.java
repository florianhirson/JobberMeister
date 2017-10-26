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

import fr.hirsonf.jobbermeister.Applicant;
import fr.hirsonf.jobbermeister.R;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterContactApplicantActivity extends AppCompatActivity {

    Button b;
    EditText mobile, street, city, zip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact_applicant);
        b = findViewById(R.id.button);
        mobile = findViewById(R.id.editTextMobile);
        street =  findViewById(R.id.editTextStreet);
        city = findViewById(R.id.editTextCity);
        zip = findViewById(R.id.editTextZIP);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mobile.getText().toString().trim().equals("") || street.getText().toString().trim().equals("")
                        || city.getText().toString().trim().equals("") || zip.getText().toString().trim().equals("")) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterContactApplicantActivity.this);
                    b.setMessage("Veuillez completer tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else {
                    Intent i = getIntent();
                    Applicant applicant = (Applicant)i.getSerializableExtra("applicant");

                    applicant.setMobile(mobile.getText().toString());
                    applicant.setStreet(street.getText().toString());
                    applicant.setCity(city.getText().toString());
                    applicant.setZip(zip.getText().toString());

                    Intent homepage = new Intent(RegisterContactApplicantActivity.this, RegisterDescriptionActivity.class);
                    homepage.putExtra("applicant", applicant);
                    System.out.println(applicant);
                    Log.v("My Application", applicant.toString());
                    startActivity(homepage);
                }
            }
        });
    }
}

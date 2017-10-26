package fr.hirsonf.jobbermeister.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.hirsonf.jobbermeister.Applicant;
import fr.hirsonf.jobbermeister.Model;
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
        b = (Button) findViewById(R.id.button);
        mobile = (EditText) findViewById(R.id.editTextMobile);
        street = (EditText) findViewById(R.id.editTextStreet);
        city = (EditText) findViewById(R.id.editTextCity);
        zip = (EditText) findViewById(R.id.editTextZIP);

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
                    ((Applicant) Model.user).mobile = mobile.getText().toString();
                    Model.user.street = street.getText().toString();
                    Model.user.city = city.getText().toString();
                    Model.user.zip = zip.getText().toString();
                    Intent homepage = new Intent(RegisterContactApplicantActivity.this, RegisterDescriptionActivity.class);
                    startActivity(homepage);
                }
            }
        });
    }
}

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

import fr.hirsonf.jobbermeister.model.Employer;
import fr.hirsonf.jobbermeister.R;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterCompanyActivity extends AppCompatActivity {

    Button b;
    EditText companyName, position;
    Intent i = getIntent();
    Employer employer = (Employer)i.getSerializableExtra("employer");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);
        b =  findViewById(R.id.button);
        companyName =  findViewById(R.id.editTextCompanyName);
        position =  findViewById(R.id.editTextPosition);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(companyName.getText().toString().trim().equals("") || position.getText().toString().trim().equals("")) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterCompanyActivity.this);
                    b.setMessage("Veuillez completer tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else {
                    employer.setCompanyName(companyName.getText().toString());
                    employer.setPosition(position.getText().toString());
                    Log.e("My Application", employer.toString());

                    // Intent homepage = new Intent(RegisterCompanyActivity.this, CreateOfferActivity.class);
                    // startActivity(homepage);
                }
            }
        });
    }
}

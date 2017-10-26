package fr.hirsonf.jobbermeister.activities;

import android.content.DialogInterface;
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

public class RegisterCompanyActivity extends AppCompatActivity {

    Button b;
    EditText companyName, position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_company);
        b = (Button) findViewById(R.id.button);
        companyName = (EditText) findViewById(R.id.editTextCompanyName);
        position = (EditText) findViewById(R.id.editTextPosition);

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
                    ((Employer) Model.user).companyName = companyName.getText().toString();
                    ((Employer) Model.user).position = position.getText().toString();
                    // Intent homepage = new Intent(RegisterCompanyActivity.this, CreateOfferActivity.class);
                    // startActivity(homepage);
                }
            }
        });
    }
}

package fr.hirsonf.jobbermeister.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Date;

import fr.hirsonf.jobbermeister.Applicant;
import fr.hirsonf.jobbermeister.Employer;
import fr.hirsonf.jobbermeister.Model;
import fr.hirsonf.jobbermeister.R;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterProfileActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    EditText lastName, firstName, birthDate ;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_profile);

        b = (Button) findViewById(R.id.b_next);
        radioGroup = (RadioGroup) findViewById(R.id.r_group);
        lastName = (EditText) findViewById(R.id.editTextLastName);
        firstName = (EditText) findViewById(R.id.editTextFirstName);
        birthDate = (EditText) findViewById(R.id.editTextBirthDate);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                System.out.println("test : "+ radioGroup.getCheckedRadioButtonId());

                String c = checkBirthDate(birthDate.getText().toString());

                if (c.equals("ok") == false) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterProfileActivity.this);
                    b.setMessage(c);
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else if(lastName.getText().toString().trim().equals("") || firstName.getText().toString().trim().equals("")
                        || birthDate .getText().toString().trim().equals("") || selectedId == -1) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterProfileActivity.this);
                    b.setMessage("Veuillez remplir tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else {
                    String email = Model.user.email;
                    String password = Model.user.password;
                    if(selectedId == R.id.r_applicant) {
                        Model.user = new Applicant();
                        Intent homepage = new Intent(RegisterProfileActivity.this, RegisterContactApplicantActivity.class);
                        startActivity(homepage);
                    } else if (selectedId == R.id.r_employer) {
                        Model.user = new Employer();
                        System.out.println("Employer !");
                        Intent homepage = new Intent(RegisterProfileActivity.this, RegisterContactEmployerActivity.class);
                        startActivity(homepage);
                    }
                    Model.user.email = email;
                    Model.user.password = password;
                    Model.user.lastName = lastName.getText().toString();
                    Model.user.firstName = firstName.getText().toString();
                    Model.user.birthDate = new Date(birthDate.getText().toString());
                }
            }
        });
    }

    private String checkBirthDate(String birthDate){
        Date temp = null;

        try {
            temp = new Date(birthDate);
        } catch (Exception ex) {
            return "Le format de date est invalide !";
        }

        if (temp.before(new Date("01/01/1900")))
            return "Vous êtes trop vieux !";

        if (temp.after(new Date("01/01/2000")))
            return "Vous êtes trop jeune !";

        return "ok";
    }
}

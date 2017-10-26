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
import fr.hirsonf.jobbermeister.R;
import fr.hirsonf.jobbermeister.User;

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

        b =  findViewById(R.id.b_next);
        radioGroup =  findViewById(R.id.r_group);
        lastName =  findViewById(R.id.editTextLastName);
        firstName =  findViewById(R.id.editTextFirstName);
        birthDate =  findViewById(R.id.editTextBirthDate);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

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
                    Intent i = getIntent();
                    User user = (User)i.getSerializableExtra("user");
                    user.setLastName(lastName.getText().toString());
                    user.setFirstName(firstName.getText().toString());
                    user.setBirthDate(new Date(birthDate.getText().toString()));

                    if(selectedId == R.id.r_applicant) {
                        Applicant applicant = new Applicant(user);
                        Intent homepage = new Intent(RegisterProfileActivity.this, RegisterContactApplicantActivity.class);
                        homepage.putExtra("applicant", applicant);
                        System.out.println(applicant);
                        startActivity(homepage);
                    } else if (selectedId == R.id.r_employer) {
                        Employer employer = new Employer(user);
                        System.out.println("Employer !");
                        Intent homepage = new Intent(RegisterProfileActivity.this, RegisterContactEmployerActivity.class);
                        homepage.putExtra("employer", employer);
                        System.out.println(employer);
                        startActivity(homepage);
                    }

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

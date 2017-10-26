package fr.hirsonf.jobbermeister;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;

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

                if (birthDate.getText().toString().length() != 10 || birthDate.getText().toString().charAt(2) != '/' || birthDate.getText().toString().charAt(5) != '/') {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterProfileActivity.this);
                    b.setMessage("Le format de la date incorrect");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else if (Integer.valueOf(birthDate.getText().toString().substring(0, 2)) < 1 || Integer.valueOf(birthDate.getText().toString().substring(0, 2)) > 31) {

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
}

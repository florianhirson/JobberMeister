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

public class RegisterDescriptionActivity extends AppCompatActivity {

    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_description);

        Button b = (Button) findViewById(R.id.b_next);
        description = (EditText) findViewById(R.id.t_description);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(description.getText().toString().trim().equals("") ) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterDescriptionActivity.this);
                    b.setMessage("Veuillez remplir la description !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else {
                    ((Applicant) Model.user).description = description.getText().toString();
                    Intent homepage = new Intent(RegisterDescriptionActivity.this, RegisterCriteriaActivity.class);
                    startActivity(homepage);
                }
            }
        });
    }
}

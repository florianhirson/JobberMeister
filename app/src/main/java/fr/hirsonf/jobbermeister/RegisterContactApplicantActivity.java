package fr.hirsonf.jobbermeister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterContactApplicantActivity extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contact_applicant);
        b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(RegisterContactApplicantActivity.this, RegisterDescriptionActivity.class);
                startActivity(homepage);
            }
        });
    }
}
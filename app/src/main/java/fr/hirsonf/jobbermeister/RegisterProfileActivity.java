package fr.hirsonf.jobbermeister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterProfileActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioApplicantButton, radioEmployerButton;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_profile);

        b = (Button) findViewById(R.id.b_next);
        radioGroup = (RadioGroup) findViewById(R.id.r_group);
        radioApplicantButton = (RadioButton) findViewById(R.id.r_applicant);
        radioEmployerButton = (RadioButton) findViewById(R.id.r_employer);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId == R.id.r_applicant) {
                    Intent homepage = new Intent(RegisterProfileActivity.this, RegisterContactApplicantActivity.class);
                    startActivity(homepage);
                } else if (selectedId == R.id.r_employer) {
                    Intent homepage = new Intent(RegisterProfileActivity.this, RegisterContactEmployerActivity.class);
                    startActivity(homepage);
                }


            }
        });


    }
}

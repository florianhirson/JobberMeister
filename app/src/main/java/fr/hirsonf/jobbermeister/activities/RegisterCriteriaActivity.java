package fr.hirsonf.jobbermeister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import fr.hirsonf.jobbermeister.model.Applicant;
import fr.hirsonf.jobbermeister.R;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterCriteriaActivity extends AppCompatActivity {
    Spinner domainSought, typeOfContractSought;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_criteria);

        domainSought =  findViewById(R.id.spinnerDomainSought);
        ArrayAdapter<String> spDomainArrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.domains)); //selected item will look like a spinner set from XML
        spDomainArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        domainSought.setAdapter(spDomainArrayAdapter);

        typeOfContractSought =  findViewById(R.id.spinnerTypeOfContractSought);
        ArrayAdapter<String> spTypeArrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.contracts)); //selected item will look like a spinner set from XML
        spTypeArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        typeOfContractSought.setAdapter(spTypeArrayAdapter);

        Button b = findViewById(R.id.b_next);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Applicant applicant = (Applicant)i.getSerializableExtra("applicant");

               applicant.setDomainSought(domainSought.getSelectedItem().toString());
                applicant.setTypeOfContractSought(typeOfContractSought.getSelectedItem().toString());

                // Intent homepage = new Intent(RegisterCriteriaActivity.this, RegisterDescriptionActivity.class);
                // startActivity(homepage);
                Toast.makeText(RegisterCriteriaActivity.this, (applicant).toString(), Toast.LENGTH_LONG).show();
                Log.e("My Application", applicant.toString());
            }
        });
    }
}

package fr.hirsonf.jobbermeister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by flohi on 25/10/2017.
 */

public class RegisterDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_description);

        Button b = (Button) findViewById(R.id.b_next);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(RegisterDescriptionActivity.this, RegisterCriteriaActivity.class);
                startActivity(homepage);
            }
        });
    }
}

package fr.hirsonf.jobbermeister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by flohi on 26/10/2017.
 */

public class LoginActivity extends AppCompatActivity {

    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.b_login);
        register = findViewById(R.id.b_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(LoginActivity.this, RegisterCredentialsActivity.class);
                startActivity(homepage);
            }
        });

    }
}

package fr.hirsonf.jobbermeister.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.hirsonf.jobbermeister.R;
import fr.hirsonf.jobbermeister.User;

public class RegisterCredentialsActivity extends AppCompatActivity {
    Button b;
    EditText login;
    TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);

        b =  findViewById(R.id.b_next);
        login =  findViewById(R.id.editTextLogin);
        password =  findViewById(R.id.editTextPassword);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login.getText().toString().trim().equals("") || password.getText().toString().trim().equals("")) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterCredentialsActivity.this);
                    b.setMessage("Veuillez completer tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                }  else {
                    User user = new User();
                    user.setLogin(login.getText().toString());
                    user.setPassword(password.getText().toString());

                    Intent homepage = new Intent(RegisterCredentialsActivity.this, RegisterProfileActivity.class);
                    homepage.putExtra("user", user);
                    System.out.println(user);
                    startActivity(homepage);
                }

            }
        });
    }
}

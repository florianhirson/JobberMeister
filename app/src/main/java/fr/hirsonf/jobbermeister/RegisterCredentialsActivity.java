package fr.hirsonf.jobbermeister;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterCredentialsActivity extends AppCompatActivity {

    EditText mail;
    TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);

        Button b = (Button) findViewById(R.id.b_next);
        mail = (EditText) findViewById(R.id.editTextEmail);
        password = (TextInputEditText) findViewById(R.id.editTextPassword);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString().trim().equals("") || password.getText().toString().trim().equals("")) {
                    AlertDialog.Builder b = new AlertDialog.Builder(RegisterCredentialsActivity.this);
                    b.setMessage("Veuillez completer tous les champs !");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog a = b.create();
                    a.show();
                } else {
                    Intent homepage = new Intent(RegisterCredentialsActivity.this, RegisterProfileActivity.class);
                    startActivity(homepage);
                }

            }
        });
    }
}

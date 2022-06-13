package com.example.baterinaexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private Button btnSignup;

    private EditText editSignupLastname;
    private EditText editSignupFirstname;
    private EditText editSignupEmail;
    private EditText editSignupPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initComponents();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lastname = editSignupLastname.getText().toString();
                String firstname = editSignupFirstname.getText().toString();
                String email = editSignupEmail.getText().toString();
                String password = editSignupPassword.getText().toString();

                if (lastname.isEmpty()) {
                    showMessage("Lastname is REQUIRED!");
                    return;
                }
                if (firstname.isEmpty()) {
                    showMessage("Firstname is REQUIRED!");
                    return;
                }
                if (email.isEmpty()) {
                    showMessage("Email is REQUIRED!");
                    return;
                }
                if (password.isEmpty()) {
                    showMessage("Password is REQUIRED!");
                    return;
                }

                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                intent.putExtra("MESSAGE","hello");
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        btnSignup = (Button) findViewById(R.id.buttonSignUp);
        editSignupLastname = (EditText) findViewById(R.id.editSignupLastname);
        editSignupFirstname = (EditText) findViewById(R.id.editSignupFirstname);
        editSignupEmail = (EditText) findViewById(R.id.editSignupEmail);
        editSignupPassword = (EditText) findViewById(R.id.editSignupPassword);
    }

    private void showMessage(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}

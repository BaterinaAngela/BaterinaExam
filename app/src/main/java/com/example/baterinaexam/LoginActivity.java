package com.example.baterinaexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnSignup;

    private EditText editEmail;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                if (email.isEmpty()) {
                    showMessage("Email is REQUIRED!");
                    return;
                }
                if (password.isEmpty()) {
                    showMessage("Password is REQUIRED!");
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("MESSAGE","hello");
                startActivity(intent);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                intent.putExtra("MESSAGE","hello");
                startActivity(intent);
            }
        });

    }

    private void initComponents() {
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnSignup = (Button) findViewById(R.id.buttonSignUp);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
    }

    private void showMessage(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

}




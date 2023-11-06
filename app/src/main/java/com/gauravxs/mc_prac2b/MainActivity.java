package com.gauravxs.mc_prac2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    private EditText editTextStudentId;
    private EditText editTextPassword;
    private Button buttonSubmit;
    private int loginAttempts = 0;
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = editTextStudentId.getText().toString();
                String password = editTextPassword.getText().toString();
                if (studentId.equals("17") && password.equals("sunny123")) {
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    loginAttempts++;
                    if (loginAttempts < MAX_LOGIN_ATTEMPTS) {
                        showAlertDialog("Login Failed", "Incorrect student ID or password. Attempts: " +

                                loginAttempts);
                    } else {
                        buttonSubmit.setEnabled(false);
                        showAlertDialog("Login Disabled", "You have reached the maximum login attempts.");
                    }
                }
            }
        });
    }

    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}
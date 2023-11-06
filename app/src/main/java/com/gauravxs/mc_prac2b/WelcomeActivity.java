package com.gauravxs.mc_prac2b;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private TextView textViewWelcomeMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textViewWelcomeMessage = findViewById(R.id.textViewWelcomeMessage);
        String welcomeMessage = "Welcome, You are logged in Successfully";
        textViewWelcomeMessage.setText(welcomeMessage);
    }
}

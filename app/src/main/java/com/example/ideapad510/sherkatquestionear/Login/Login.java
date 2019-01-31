package com.example.ideapad510.sherkatquestionear.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.Questionnaire.Questionnaire;
import com.example.ideapad510.sherkatquestionear.R;

public class Login extends AppCompatActivity {

    private String username;
    private String password;
    private LoginController loginControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginControler = new LoginController(this);

//        sampleUserPass();
    }

    public void onLoginButtonClicked(View view){
        getTextFromEditTexts();
        if (loginControler.searchInDatabase(username,password)) {
            Intent i = new Intent(Login.this, Questionnaire.class);
            startActivity(i);
            finish();
        }
    }

    private void getTextFromEditTexts(){
        EditText editText = findViewById(R.id.username);
        username = editText.getText().toString();
        editText = findViewById(R.id.password);
        password = editText.getText().toString();
    }

    private void sampleUserPass(){
        loginControler.insertToDatabase("ali","123");
        loginControler.insertToDatabase("hamid","1234");
        loginControler.insertToDatabase("1","1");

    }
}

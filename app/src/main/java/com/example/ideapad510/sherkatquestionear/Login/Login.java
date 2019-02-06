package com.example.ideapad510.sherkatquestionear.Login;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.Questionnaire.Questionnaire;
import com.example.ideapad510.sherkatquestionear.R;

public class Login extends Activity {

    private String username;
    private String password;
    private LoginController loginControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginControler = new LoginController(this);

        new StartAllTables(this);
    }

    public void onLoginButtonClicked(View view){
        getTextFromEditTexts();
        if (loginControler.searchInDatabase(username,password)) {
            Intent i = new Intent(Login.this, Questionnaire.class);
            i.putExtra("user", username);
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
        loginControler.insertToDatabase("ali","123" , "1");
        loginControler.insertToDatabase("hamid","1234" , "2");
        loginControler.insertToDatabase("1","1" , "3");

    }
}

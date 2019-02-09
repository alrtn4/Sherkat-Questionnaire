package com.example.ideapad510.sherkatquestionear.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ideapad510.sherkatquestionear.Questionnaire.Questionnaire;
import com.example.ideapad510.sherkatquestionear.R;

public class Login extends Activity {

    private String username;
    private String password;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginController = new LoginController(this);

//        new StartAllTables(this);
    }

    public void onLoginButtonClicked(View view){
        getTextFromEditTexts();
//        if (loginController.searchInDatabase(username,password)) {
        if (loginController.searchInDatabase2(username,password)) {
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

}

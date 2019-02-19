package com.example.ideapad510.sherkatquestionear.Login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.ForTry;
import com.example.ideapad510.sherkatquestionear.Database.Tables.LoginTable;
import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionController;
import com.example.ideapad510.sherkatquestionear.R;

public class Login extends AppCompatActivity {
	private static FragmentManager fragmentManager;
	//this unused loginController should not be deleted because program crushes
//	LoginController loginController = new LoginController(this);
//	QuestionController questionController = new QuestionController(this);
//	Controller controller = new Controller(this);
	Database database = Database.getInstance(this);
//	LoginTable loginTable = new LoginTable("1", "2", "3", 1);
//	ForTry forTry = new ForTry(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
		setContentView(R.layout.login);
		fragmentManager = getSupportFragmentManager();

		// If savedinstnacestate is null then replace login fragment
		if (savedInstanceState == null) {
			fragmentManager
					.beginTransaction()
					.replace(R.id.frameContainer, new Login_Fragment(),
							Utils.Login_Fragment).commit();
		}

		// On close icon click finish activity
		findViewById(R.id.close_activity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						finish();

					}
				});

//		new StartAllTables(this);

	}




}

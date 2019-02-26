package com.example.ideapad510.sherkatquestionear.Login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.JsonHandler.HttpHandler;
import com.example.ideapad510.sherkatquestionear.JsonHandler.JSONText;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.Controller;
import com.example.ideapad510.sherkatquestionear.JsonHandler.RetroFit.Controller2;
import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.R;
import com.google.gson.JsonSerializer;

import org.json.JSONObject;

public class Login extends AppCompatActivity {

	private static FragmentManager fragmentManager;
	Params params = Params.getInstance();
	String TAG = "login2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
		setContentView(R.layout.login);
		fragmentManager = getSupportFragmentManager();

		params.setContext(this);

		// If savedinstnacestate is null then replace login fragment
		if (savedInstanceState == null) {
			fragmentManager
					.beginTransaction()
					.replace(R.id.frameContainer, new Login_Fragment(),
							Utils.Login_Fragment).commit();
		}

//		System.out.println("hhhhhhhhhhhh");

//		new StartAllTables(this);
		try {
//			System.out.println("hiiiiiiiiiiii");
//			JSONObject jsonObject = new JSONObject(new JSONText().getText());

//			HttpHandler httpHandler = new HttpHandler();
			Controller2 controller = new Controller2();
			controller.start();

//			httpHandler.start("http://jmr.samim.org/JMR-Q/req-app/send-results.php?req=1", jsonObject.toString());
//			new HttpHandler().start("http://jmr.samim.org/JMR-Q/req-app/send-results.php?req=1", new JSONText().getText());
		}
		catch(Exception e) {
			Log.d(TAG, "onCreate: hiiiiiiiiiiiiiiiii    "+e);
		}

	}




}

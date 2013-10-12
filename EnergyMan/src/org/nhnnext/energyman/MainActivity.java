package org.nhnnext.energyman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private final String LOGIN_SERVER_URL = "http://0.0.0.0:80/checkLogin/";
	public static final String PREFS_NAME = "prefs";
	SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		prefs = PreferenceManager.getDefaultSharedPreferences(this);

		final String userEmail = prefs.getString("userEmail", null);
		final String userPassword = prefs.getString("userPassword", null);
		
		if (userEmail == null && userPassword == null) {
		//기존에 로그인 기록이 없다면 로그인 화면을 보여줌
			setContentView(R.layout.activity_login);

			
			Button loginButton = (Button) findViewById(R.id.button_login);
			final EditText editTextID = (EditText) findViewById(R.id.editText_ID);
			final EditText editTextPW = (EditText) findViewById(R.id.editText_PW);

			loginButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					
					if (checkLogin(editTextID.getText().toString(), editTextPW.getText().toString())) {
						Toast.makeText(MainActivity.this, "Login Success",
								Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(getBaseContext(),
								SetupActivity.class);
						startActivity(intent);
						finish();
						
					}else{
						Toast.makeText(MainActivity.this, "Login Fail",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

		} else {
		// 기존에 로그인 기록이 있다면 SetupActivity.class 로 보냄
			/**
			 * Set UP의 여부에 대해서도 저장해두어야할듯 ex ) final String setUpFlag =
			 * prefs.getString("setUpFlag", null);
			 */
			Intent intent = new Intent(getBaseContext(), SetupActivity.class);
			startActivity(intent);
			finish();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private boolean checkLogin(String userEmail, String userPassword) {
		try {
			String data = URLEncoder.encode("userEmail", "UTF-8") + "=" + URLEncoder.encode(userEmail, "UTF-8")
					+ URLEncoder.encode("userPassword", "UTF-8") + "=" + URLEncoder.encode(userPassword, "UTF-8");
			
			URL url = new URL(LOGIN_SERVER_URL);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String result = rd.readLine();
			
			Log.i("Result", result);
			
			wr.close();
			rd.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		// JUST TEST
		return true;
	}
}

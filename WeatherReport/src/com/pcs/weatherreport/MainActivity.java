package com.pcs.weatherreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity  extends Activity{
	
	private EditText userName;
	private EditText passWord;
	private Button loginBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		userName = (EditText) findViewById(R.id.username_edt);
		passWord = (EditText) findViewById(R.id.password_edt);
	    loginBtn = (Button) findViewById(R.id.login_btn);
	     
	   loginBtn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, WeatherReportActivity.class);
			startActivity(intent);
		}
	});
	   
	   
	   
	}

	
	
	

}

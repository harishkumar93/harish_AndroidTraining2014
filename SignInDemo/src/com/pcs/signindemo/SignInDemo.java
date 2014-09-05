package com.pcs.signindemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;


public class SignInDemo extends Activity{
	
	public static final String TAG = "SignInDemo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText uname_edt = (EditText) findViewById(R.id.uname);
		EditText pwd_edt = (EditText) findViewById(R.id.pwd);
		
		String username = uname_edt.getText().toString();
		String pwd = pwd_edt.getText().toString();
		
		Log.i(TAG,"Username: "+username);
		Log.i(TAG,"Password: "+pwd);
	}	

}

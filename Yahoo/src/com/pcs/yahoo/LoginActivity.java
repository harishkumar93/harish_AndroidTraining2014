package com.pcs.yahoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.yahoo.R;

public class LoginActivity extends Activity {

	public static final String TAG = "Android";

	private  Button LoginBtn;
	private EditText UserNameedt;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {        	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yahoo);

		 LoginBtn = (Button)findViewById(R.id.login_id);
		 UserNameedt = (EditText)findViewById(R.id.username);
		



         LoginBtn.setOnClickListener(new OnClickListener()
         {
        	 public void onClick(View v)
        	 {
        		 Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);
        		 intent.putExtra(Constants.LoginExtras.USER_NAME,UserNameedt.getText().toString());
        		 startActivity(intent);
        	 }
         });
			
			
	}



}

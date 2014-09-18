package com.pcs.progressdialog;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.mainactivity);
	
	Button createBtn = (Button)findViewById(R.id.create_btn);
	

	
	createBtn.setOnClickListener(new android.view.View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(MainActivity.this,CreateActivity.class);
			startActivity(intent);
			
	
		}
	});		


	}

}

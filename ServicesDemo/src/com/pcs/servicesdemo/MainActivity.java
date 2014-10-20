package com.pcs.servicesdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	
	private Button startBtn;
	private Button stopBtn;
	public MyService service;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.main);
		
		startBtn = (Button) findViewById(R.id.start_btn);
		stopBtn = (Button) findViewById(R.id.stop_btn);
		
		startBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 startService(new Intent(getBaseContext(), MyService.class));
			}
		});
		
		stopBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stopService(new Intent(getBaseContext(),MyService.class));
				
			}
		});
	}

}

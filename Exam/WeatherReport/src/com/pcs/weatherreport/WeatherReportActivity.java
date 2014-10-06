package com.pcs.weatherreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WeatherReportActivity extends Activity {
	
	private EditText cityName;
	private Button enterBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		
		cityName = (EditText) findViewById(R.id.city_edt);
		enterBtn = (Button) findViewById(R.id.enter_btn);
		enterBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(WeatherReportActivity.this, JsonActivity.class);
			
				
			}
		});
	}
	
	

}

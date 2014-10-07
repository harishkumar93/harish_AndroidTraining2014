package com.pcs.weatherreport;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
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
				
               new WeatherReport(WeatherReportActivity.this).execute();			
				
			}
		});
	}
	
	public class WeatherReport extends AsyncTask<Void, Void, Void>{

		Context context;
		public WeatherReport(WeatherReportActivity weatherReportActivity) {
			
			context = weatherReportActivity;
			
		}

		@Override
		protected Void doInBackground(Void... params) {
		
			return null;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}
		
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		
	}
	
	
	

}

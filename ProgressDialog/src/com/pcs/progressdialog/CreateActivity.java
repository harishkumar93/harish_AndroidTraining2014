package com.pcs.progressdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class CreateActivity  extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
setContentView(R.layout.create);

Button dateBtn = (Button)findViewById(R.id.date_btn);
Button timeBtn = (Button)findViewById(R.id.time_btn);
Button submitBtn = (Button)findViewById(R.id.submit_btn);


dateBtn.setOnClickListener(new android.view.View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		final EditText dateEdt = (EditText) findViewById(R.id.date_edt);
		
		Dialog date_dialog = new DatePickerDialog(CreateActivity.this, new OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
               dateEdt.setText(year +"/" +monthOfYear +"/" +dayOfMonth ) ;  						
			}
		}, year, month, day);
		date_dialog.show();
	}
});

timeBtn.setOnClickListener(new android.view.View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Calendar calendar = Calendar.getInstance();
			final int hour = calendar.get(Calendar.HOUR);
			int minute = calendar.get(Calendar.MINUTE);
			
			final EditText timeEdt = (EditText) findViewById(R.id.time_edt);
			Dialog time_dialog = new TimePickerDialog(CreateActivity.this, new OnTimeSetListener() {
				
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					
					timeEdt.setText(hour + ":" +minute);
				}
			}, hour, minute, true);
			
		time_dialog.show();
		}
	}); 
submitBtn.setOnClickListener(new android.view.View.OnClickListener() {

	@Override
	public void onClick(View v) {
		ProgressDialog progress = new ProgressDialog(CreateActivity.this);
		progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progress.setMessage(getResources().getString(R.string.loading_dialog));
		progress.setMax(100);
		progress.setIndeterminate(true);
		progress.show();
		if()
		
	
	}
		
	});



	}	
}

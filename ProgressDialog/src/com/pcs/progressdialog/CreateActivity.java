package com.pcs.progressdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TimePicker;

public class CreateActivity  extends Activity{
	private Button dateBtn;
	private Button timeBtn;
	
	private EditText nameEdt;
	private EditText emailEdt;
	private EditText phoneEdt;
	private EditText dateEdt;
	private EditText timeEdt;
	private ProgressBar progressBar;
	private String nameTxt;
	private String emailTxt;
	private String phoneTxt;
	private String dateTxt;
	private String timeTxt;
	private Button uBtn;
	private Button eBtn;
	private Button pBtn;
	
	private int a=0,b=0,c=0,d=0,e=0,sum=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
setContentView(R.layout.create);

 dateBtn = (Button)findViewById(R.id.date_btn);
 
 timeBtn = (Button)findViewById(R.id.time_btn);
 uBtn = (Button)findViewById(R.id.u_btn);
 eBtn = (Button)findViewById(R.id.e_btn);
 pBtn = (Button)findViewById(R.id.p_btn);

 progressBar = (ProgressBar)findViewById(R.id.progress_bar);
nameEdt = (EditText)findViewById(R.id.name_edt);
 emailEdt = (EditText)findViewById(R.id.email_edt);
 phoneEdt = (EditText)findViewById(R.id.phone_edt);
 dateEdt = (EditText)findViewById(R.id.date_edt);
timeEdt = (EditText)findViewById(R.id.time_edt);

 nameTxt = nameEdt.getText().toString();
 emailTxt = nameEdt.getText().toString();
phoneTxt = nameEdt.getText().toString();
 dateTxt = nameEdt.getText().toString();
 timeTxt = nameEdt.getText().toString();
 /*
  * Takes input as text field and press enter button to view progress bar
  * 
  */

uBtn.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		
		a=1;
		refresh();
	}
});
/*
 * Takes input as text field and press enter button to view progress bar
 * 
 */
	
eBtn.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		b=1;
		refresh();
	}
});

/*
 * Takes input in the number field and press enter button to view progress bar
 */

pBtn.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		c=1;
		refresh();
	}
});

/*
* takes input  asdate field and press enter button to view progress bar
 * We can take the date dynamically,
 * on clicking the DatePickerDialog
 */


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
               d=1;
            	   refresh();
               
			}
		}, year, month, day);
		date_dialog.show();
		
	}
	
});

/*
 * Takes input as date  and press enter button to view progress bar

 * We can take the time dynamically when we click time button
 * by using  TimePickerDialog
 */

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
					e=1;
					refresh();
				}
			}, hour, minute, true);
			
		time_dialog.show();
		}
	}); 

/*
 * Refresh is used to update the progress bar dynamically
 */


	}
	
	protected void refresh()
	{
		sum=a+b+c+d+e;
		int progress=sum*20;
		progressBar.setProgress(progress);
}
}
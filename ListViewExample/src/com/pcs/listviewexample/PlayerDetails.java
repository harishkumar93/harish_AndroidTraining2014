package com.pcs.listviewexample;

import com.pcs.constants.Constants;
import com.pcs.listviewexample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PlayerDetails extends Activity{

	private EditText nameEdt;
	private EditText jerseyEdt;
	private EditText countryEdt;
	private EditText streamEdt;
	private Button doneBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);
		nameEdt = (EditText)findViewById(R.id.name_edt);
		jerseyEdt = (EditText)findViewById(R.id.jersey_edt);
		countryEdt = (EditText)findViewById(R.id.country_edt);
		streamEdt = (EditText)findViewById(R.id.stream_edt);
		doneBtn = (Button)findViewById(R.id.done); 
		doneBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PlayerDetails.this,ListViewExample.class);
				intent.putExtra(Constants.IntentExtras.NAME, nameEdt.getText().toString());
				intent.putExtra(Constants.IntentExtras.JERSEY, jerseyEdt.getText().toString());
				intent.putExtra(Constants.IntentExtras.COUNTRY,countryEdt.getText().toString());
				intent.putExtra(Constants.IntentExtras.STREAM, streamEdt.getText().toString());
				setResult(RESULT_OK, intent);			
				finish();				
			}
		});
		
		
}
}

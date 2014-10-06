package com.pcs.parcelableactivity;


import com.pcs.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements Parcelable {
	
	private EditText eNameEdt;
	private EditText eIdEdt;
	private EditText eDesignationEdt;
	private Button loginBtn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		eNameEdt = (EditText) findViewById(R.id.eName_edt);
		eIdEdt = (EditText) findViewById(R.id.eId_edt);
        eDesignationEdt = (EditText) findViewById(R.id.eDesignation_edt);
        
        loginBtn = (Button) findViewById(R.id.login_btn);
        
        loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
				intent.putExtra(Constants.EMPLOYEE_NAME, getResources().getString(R.id.eName_edt));
				intent.putExtra(Constants.EMPLOYEE_ID, getResources().getString(R.id.eId_edt));
				intent.putExtra(Constants.EMPLOYEE_DESIGNATION, getResources().getString(R.id.eDesignation_edt));
				
				
			}
		});
        
	}

	@Override
	public int describeContents() {
	
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.setDataPosition(R.id.eName_edt);
		dest.setDataPosition(R.id.eId_edt);
		dest.setDataPosition(R.id.eDesignation_edt);
		
			
	}

}

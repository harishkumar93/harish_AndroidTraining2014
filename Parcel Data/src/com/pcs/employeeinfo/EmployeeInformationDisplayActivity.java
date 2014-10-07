package com.pcs.employeeinfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.pcs.constants.Constants;
import com.pcs.model.Employee;
import com.pcs.employeeinfo.R;

public class EmployeeInformationDisplayActivity extends Activity{
	
	private TextView displayEdt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		/***
		 * Declaring the display layout
		 */
		setContentView(R.layout.display);
		
		displayEdt = (TextView)findViewById(R.id.display_employee);
		 
		Employee employee = getIntent().getParcelableExtra(Constants.IntentExtras.EMPLOYEE_INFO);
		if(employee!=null)
			
		{
			displayEdt.setText(employee.toString());
		}
		
	}

}

package com.pcs.employeeinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.pcs.constants.Constants;
import com.pcs.model.Employee;
import com.pcs.employeeinfo.R;

public class EmployeeInformationActivity extends Activity{
	
	/***
	 * three Edit texts one for Employee id, name and Designation which were declared in main layout
	 */
	private EditText eId;
	private EditText eName;
	private EditText eDesignation;
	private Button displayBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		/**
		 * Assign the main layout here
		 */
		setContentView(R.layout.main);

		 displayBtn = (Button)findViewById(R.id.display_btn);

		eId =(EditText)findViewById(R.id.eid_edt);
		eName =(EditText)findViewById(R.id.ename_edt);
		eDesignation =(EditText)findViewById(R.id.edesg_edt);
		
		/**
		 *on clicking the display button it should navigate to the other activity
		 */


		displayBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				/**
				 * Explicit intent is declared for this purpose such that it navigates to display activity
				 */

				Intent mintent = new Intent(EmployeeInformationActivity.this,EmployeeInformationDisplayActivity.class);
				
				/***
				 * Create an employee object to get the data
				 */
				Employee obj = new Employee();

				obj.setId(eId.getText().toString());
				obj.setName(eName.getText().toString());
				obj.setDesignation(eDesignation.getText().toString());
				
				/***
				 * the declared intent will retrieve the information from the Constants Class
				 */

				mintent.putExtra(Constants.IntentExtras.EMPLOYEE_INFO, obj);
				
				/***
				 * Start the activity
				 */
				startActivity(mintent);

			}
		});

	}


}

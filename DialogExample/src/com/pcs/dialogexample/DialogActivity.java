package com.pcs.dialogexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


	public class DialogActivity extends Activity{
		private TextView printTxt;
		private Button clickBtn;
		private Button enterBtn;
		private Button cancelBtn;
		private EditText pwdEdt;
		private EditText mailEdt;
		private AlertDialog.Builder builder;
		private LayoutInflater inflater;
		private AlertDialog alertDialog;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			clickBtn = (Button)findViewById(R.id.click_btn);
			printTxt = (TextView)findViewById(R.id.print_txt);
			/***
			 * Opens the dialog prompt when user clicks clickBtn
			 * dialog prompt contains 2 EditTexts email and password
			 */
			clickBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					inflater = LayoutInflater.from(DialogActivity.this);
					
					View dialogView = inflater.inflate(R.layout.dialog, null);
					
					 builder = new AlertDialog.Builder(DialogActivity.this);
					
					builder.setView(dialogView);
					
					
					builder.setTitle(R.string.dialog_title);
					pwdEdt = (EditText)dialogView.findViewById(R.id.pwd_edt);
					mailEdt = (EditText)dialogView.findViewById(R.id.mail_edt);
					enterBtn = (Button)dialogView.findViewById(R.id.enter_btn);
					cancelBtn = (Button)dialogView.findViewById(R.id.cancel_btn);
					
					/***
					 * When enterBtn clicked details are stored in TextView and toast message will print
					 */
					enterBtn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
						  printTxt.setText("Email Id:"+mailEdt.getText().toString()+"\n Password:**********");
						  Toast.makeText(DialogActivity.this, "Email Id:"+mailEdt.getText().toString()+"\n Password:*********", Toast.LENGTH_LONG).show();
						  alertDialog.dismiss();
						}
					});
					/**
					 * When CancelBtn Clicked toast message printed and return to home page
					 */
					cancelBtn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							Toast.makeText(DialogActivity.this, R.string.none, Toast.LENGTH_LONG).show();
							alertDialog.dismiss();
						}
					});
					
					alertDialog = builder.create();
					alertDialog.show();
					
				}

				
			});
			
		}

	}

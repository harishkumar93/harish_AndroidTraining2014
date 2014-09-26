package com.pcs.samplenotification;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	/***
	 * Two buttons which were used to view notifications and to download
	 */
	
	private Button notificationBtn;
	private Button downloadBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		/***
		 * Assign the layout in which the above to buttons were present
		 */
		setContentView(R.layout.main);
		
		/***
		 * assign the button_id's to the declared buttons
		 */
		
		notificationBtn = (Button)findViewById(R.id.notification_btn);
		downloadBtn = (Button)findViewById(R.id.download_btn);
		
		/***
		 * Create Onclicklistener to notification Button to pass the data
		 */
		
		notificationBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				/***
				 * Create an intent and set an action to it and send it by using sendBroadcast
				 */
				
				Intent intent = new Intent();
				intent.setAction("com.pcs.BROAD_CAST");
				sendBroadcast(intent);
				
				
			}
		});
		
		/***
		 * Create Onclicklistener to Download Button to pass the data
		 * 
		 */
		
		downloadBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/***
				 * Create an intent and set an action to it and send it by using sendBroadcast
				 */
				
				Intent intent = new Intent();
				intent.setAction("com.pcs.DOWNLOAD");
				sendBroadcast(intent);
				
			}
		});
		
		
	}
	

}

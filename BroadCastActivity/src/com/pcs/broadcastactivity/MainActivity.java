package com.pcs.broadcastactivity;
	
	
	
	import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

	public class MainActivity extends Activity {
	
		
		private Button notificationBtn;
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);			
			setContentView(R.layout.main);	
			notificationBtn = (Button)findViewById(R.id.notification_btn);
			notificationBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {					
					Intent intent = new Intent();
					intent.setAction("com.pcs.BROAD_CAST");
					sendBroadcast(intent);					
				}
			});
			
		}
		

	}



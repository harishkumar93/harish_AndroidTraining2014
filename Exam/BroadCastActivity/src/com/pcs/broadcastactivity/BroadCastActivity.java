package com.pcs.broadcastactivity;

	
	import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

	
	public class BroadCastActivity extends BroadcastReceiver {
		
		
		
		private static final int REQUEST_1 = 1;

		public void onReceive(Context context, Intent intent) {
			
			 Toast.makeText(context, "Drag to view Notifications", Toast.LENGTH_LONG).show();
			 
			 NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(context); 
			 NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
			 
			 
			 notifyBuilder.setContentTitle(context.getResources().getString(R.string.install_title));
			 notifyBuilder.setContentText(context.getResources().getString(R.string.install_txt));
			 notifyBuilder.setSmallIcon(R.drawable.ic_launcher);
			 
			 
			 Intent notificationIntent = new Intent(context, MainActivity.class); 
			 PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUEST_1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			 notifyBuilder.setContentIntent(pendingIntent);
			 notifyBuilder.setAutoCancel(true);
			 
			 notificationIntent.setFlags(notificationIntent.FLAG_ACTIVITY_NEW_TASK | notificationIntent.FLAG_ACTIVITY_CLEAR_TASK);	 
			 notificationManager.notify(REQUEST_1, notifyBuilder.build());
			 
			 
			 
			 
		}

	}



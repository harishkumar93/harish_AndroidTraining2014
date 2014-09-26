package com.pcs.samplenotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/***
 * Create a class which extends BroadcastReciever
 * @author user
 *
 */
public class BroadCastActivity extends BroadcastReceiver {
	
	
	
	private static final int REQUEST_1 = 1000;

	public void onReceive(Context context, Intent intent) {
		 Toast.makeText(context, "BroadCast Success", Toast.LENGTH_LONG).show();
		 NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(context);
		 
		     /***
			 * create a notification manager which takes a systems service
			 */
		 
		 NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
		 /***
		  * create an object for NotificationCompat which has three default items,
		  * setSmallIcon(), setContentTitle(), and setContentText().
		  */
		 
		 notifyBuilder.setContentTitle(context.getResources().getString(R.string.loading_title));
		 notifyBuilder.setContentText(context.getResources().getString(R.string.loading_txt));
		 notifyBuilder.setSmallIcon(R.drawable.message);
		 
		 
		 Intent notificationIntent = new Intent(context, MainActivity.class);
		 
		 PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUEST_1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		 
		 notifyBuilder.setContentIntent(pendingIntent);
		 notifyBuilder.setAutoCancel(true);
		 
		 notificationIntent.setFlags(notificationIntent.FLAG_ACTIVITY_NEW_TASK | notificationIntent.FLAG_ACTIVITY_CLEAR_TASK);
		 
		 notificationManager.notify(REQUEST_1, notifyBuilder.build());
		 
		 
		 
		 
	}

}

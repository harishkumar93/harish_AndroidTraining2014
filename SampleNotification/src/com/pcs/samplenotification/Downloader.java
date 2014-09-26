package com.pcs.samplenotification;




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
public class Downloader extends BroadcastReceiver{
	private static final int REQUEST_2=2000;
	/***
	 * create a notification manager which takes a systems service
	 */
	NotificationManager notificationManger;

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Toast.makeText(context, "Download Started", Toast.LENGTH_LONG).show();
		notificationManger = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
/***
 * create an object for NotificationCompat which has three default items,
 * setSmallIcon(), setContentTitle(), and setContentText().
 */
		final NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(context);
		
		notifyBuilder.setSmallIcon(R.drawable.download);
		notifyBuilder.setContentTitle(context.getResources().getString(R.string.downloader_title));
		notifyBuilder.setContentText(context.getResources().getString(R.string.downloader_txt));
		
		/***
		 * create a new intent object and pass this to the main activity such that after the 
		 * execution of this part it navigates to the first screen
		 */
		
		Intent resultIntent = new Intent(context,MainActivity.class);


		PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUEST_2, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		notifyBuilder.setContentIntent(pendingIntent);

		notifyBuilder.setAutoCancel(true);
		resultIntent.setFlags(resultIntent.FLAG_ACTIVITY_CLEAR_TASK|resultIntent.FLAG_ACTIVITY_NEW_TASK);
		
		
		/***
		 * This thread is to show the progress bar
		 */
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int value;
				for(value=1;value<100;value=value+15)
				{
					notifyBuilder.setProgress(100, value, false);
					notificationManger.notify(REQUEST_2,notifyBuilder.build());
					try {
                        // Sleep for 2 seconds
                        Thread.sleep(2*1000);
                    } catch (InterruptedException e) {
                    }

				}
				 notifyBuilder.setContentText("Download complete")
		         // Removes the progress bar
		                 .setProgress(0,0,false);

				notificationManger.notify(REQUEST_2,notifyBuilder.build());	
			}
		}).start();
		
		
	}

}

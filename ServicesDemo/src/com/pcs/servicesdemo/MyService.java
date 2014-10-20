package com.pcs.servicesdemo;

import java.util.Calendar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		throw new UnsupportedOperationException("Not yet implemented");

	}

	public void onCreate() {

		Toast.makeText(this, getResources().getString(R.string.create_txt), Toast.LENGTH_LONG).show();

	}

	public int onStartCommand(Intent intent, int flags, int startId) {

		Toast.makeText(this, getResources().getString(R.string.started_txt), Toast.LENGTH_LONG).show();
		Calendar cal=Calendar.getInstance();
		int YEAR = cal.get(Calendar.YEAR);
		int MONTH = cal.get(Calendar.MONTH);
		int DATE = cal.get(Calendar.DAY_OF_MONTH);
		Toast.makeText(this, DATE +"/" +MONTH +"/"+YEAR, Toast.LENGTH_LONG).show();


		return super.onStartCommand(intent, flags, startId);

	}

	public void onDestroy() {

		Toast.makeText(this,getResources().getString(R.string.destroy_txt), Toast.LENGTH_LONG).show();

	}

}

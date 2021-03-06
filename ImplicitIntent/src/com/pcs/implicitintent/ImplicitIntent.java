package com.pcs.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImplicitIntent extends Activity implements OnClickListener{
	private Button callBtn;
	private Button browseBtn;
	private Button musicBtn;
	private Button galleryBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.implicit);
		callBtn = (Button) findViewById(R.id.call_btn);
		browseBtn = (Button)findViewById(R.id.browse_btn);
		musicBtn = (Button) findViewById(R.id.music_btn);
		galleryBtn = (Button) findViewById(R.id.gallery_btn);

		callBtn.setOnClickListener(this);
		browseBtn.setOnClickListener(this);
		musicBtn.setOnClickListener(this);
		galleryBtn.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {

		case R.id.call_btn:

			intent = new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:9492524524"));
			startActivity(Intent.createChooser(intent, getResources().getString(R.string.cal)));
			break;


		case R.id.browse_btn :

			intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://www.facebook.com"));
			startActivity(intent);
			break;

		case R.id.music_btn :

			intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("JaiHo.mp3"));
			startActivity(Intent.createChooser(intent, getResources().getString(R.string.musi)));
			break;

		case R.id.gallery_btn :

			intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("android.jpg"));
			startActivity(Intent.createChooser(intent, getResources().getString(R.string.gall)));
			break;

		default:
			break;
		}	
	}


}

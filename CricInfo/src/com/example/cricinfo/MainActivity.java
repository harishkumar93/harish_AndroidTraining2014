package com.example.cricinfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private static final int  LENGTH_LONG = 0;
	private Button aus_btn;
	private Button ind_btn;
	private Button eng_btn;
	private Button rsa_btn;
	private Button newz_btn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		aus_btn = (Button)findViewById(R.id.aus_flag);
		ind_btn= (Button)findViewById(R.id.ind_flag);
		eng_btn = (Button)findViewById(R.id.eng_flag);
		rsa_btn = (Button)findViewById(R.id.rsa_flag);
		newz_btn = (Button)findViewById(R.id.newz_flag);

		aus_btn.setOnClickListener(this);
		ind_btn.setOnClickListener(this);
		eng_btn.setOnClickListener(this);
		rsa_btn.setOnClickListener(this);
		newz_btn.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v) {
		View background = findViewById(R.id.background);

		v.getId();
		

		switch(v.getId())
		{
		case R.id.aus_flag :
			background.setBackgroundResource(R.drawable.aus);
			Toast.makeText(MainActivity.this, getResources().getString(R.string.a),LENGTH_LONG).show();
			break;

		case R.id.ind_flag :
			background.setBackgroundResource(R.drawable.ind);
			Toast.makeText(MainActivity.this, getResources().getString(R.string.b),LENGTH_LONG).show();
			break;

		case R.id.eng_flag :
			background.setBackgroundResource(R.drawable.eng);
			Toast.makeText(MainActivity.this, getResources().getString(R.string.c),LENGTH_LONG).show();
			break;

		case R.id.rsa_flag :
			background.setBackgroundResource(R.drawable.rsa);
			Toast.makeText(MainActivity.this, getResources().getString(R.string.d),LENGTH_LONG).show();
			break;

		case R.id.newz_flag :
			background.setBackgroundResource(R.drawable.newz);
			Toast.makeText(MainActivity.this, getResources().getString(R.string.e),LENGTH_LONG).show();
			break;
		}

	}




}



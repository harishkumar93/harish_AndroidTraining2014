package com.pcs.samplefragment;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends Activity {
	
	private Button indBtn;
	private Button ausBtn;
	private Button saBtn;
	private Button pakBtn;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void selectFragment(View view)
	{
		indBtn = (Button) findViewById(R.id.ind_btn);
		ausBtn = (Button) findViewById(R.id.aus_btn);
		saBtn = (Button) findViewById(R.id.sa_btn);
		pakBtn =  (Button) findViewById(R.id.pak_btn);
		Fragment fragment= null;

		if(view == indBtn) {
			fragment  = new IndiaFragment();

		}
		else if(view == ausBtn) {
			fragment = new AustraliaFragment();
		}

		else if(view == saBtn) {
			fragment = new SaFragment();
		}


		else if(view == pakBtn) {
			fragment = new Pakisthanfragment();
		}

		FragmentManager fm = getFragmentManager();
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		fragmentTransaction.replace(R.id.click_fragment, fragment);
		fragmentTransaction.commit();

	}

}








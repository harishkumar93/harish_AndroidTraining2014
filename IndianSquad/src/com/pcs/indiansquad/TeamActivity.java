package com.pcs.indiansquad;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.pcs.constants.Constants;
import com.pcs.indianteam.IndianTeam;

public class TeamActivity extends Activity {
	private TextView crick;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.team);
		crick = (TextView)findViewById(R.id.cricket);
		IndianTeam teamindia = getIntent().getParcelableExtra(Constants.IntentExtras.INDIAN);
		if(teamindia!=null)
		{
			crick.setText(teamindia.toString());
		}
	}

}

package com.pcs.indiansquad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.pcs.constants.Constants;
import com.pcs.indianteam.IndianTeam;

public class IndianSquadActivity extends Activity {
	private Button squadBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.india);

		squadBtn = (Button) findViewById(R.id.squad_btn);

		squadBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(IndianSquadActivity.this,TeamActivity.class);

				IndianTeam team = new IndianTeam();
				team.setFirstMember(getResources().getString(R.string.first));
				team.setSecondMember(getResources().getString(R.string.second));
				team.setThirdMember(getResources().getString(R.string.third));
				team.setFourthMember(getResources().getString(R.string.fourth));
				team.setFifthMember(getResources().getString(R.string.fifth));
				team.setSixthMember(getResources().getString(R.string.sixth));
				team.setSeventhMember(getResources().getString(R.string.seventh));
				team.setEigthMember(getResources().getString(R.string.eigth));
				team.setNinthMember(getResources().getString(R.string.ninth));
				team.setTenthMember(getResources().getString(R.string.tenth));
				team.setElevenMember(getResources().getString(R.string.eleven));
				team.setTwelveMember(getResources().getString(R.string.twelve));
				team.setThirteenMember(getResources().getString(R.string.thirteen));
				team.setFourteenMember(getResources().getString(R.string.fourteen));
				team.setFifteenMember(getResources().getString(R.string.fifteen));
				team.setSixteenMember(getResources().getString(R.string.sixteen));
				intent.putExtra(Constants.IntentExtras.INDIAN, team);
				startActivity(intent);
			}
		});

	}

}

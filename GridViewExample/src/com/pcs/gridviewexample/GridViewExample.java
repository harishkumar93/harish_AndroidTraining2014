package com.pcs.gridviewexample;

import java.util.ArrayList;

import com.pcs.constants.Constants;
import com.pcs.customactivity.CustomAdapter;
import com.pcs.listviewexample.R;
import com.pcs.playerslist.Player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;



public class GridViewExample  extends Activity {
	private GridView gs;
	private static final int RC_A=101;
	private ArrayList<Player> playerslist;
	private Player players;
	private Button addBtn;
	private CustomAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview);
		gs = (GridView)findViewById(R.id.grid);
		addBtn = (Button)findViewById(R.id.adds);
		playerslist = new ArrayList<Player>();
		players = new Player();
		adapter = new CustomAdapter(GridViewExample.this, playerslist);
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GridViewExample.this,PlayerDetails.class);
				startActivityForResult(intent,RC_A);

			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(data!=null)

		{
			Player players = new Player();
			String name = data.getStringExtra(Constants.IntentExtras.NAME);
			String jersey = data.getStringExtra(Constants.IntentExtras.JERSEY);
			String country = data.getStringExtra(Constants.IntentExtras.COUNTRY);
			String stream = data.getStringExtra(Constants.IntentExtras.STREAM);
			players.setPlayerName(name);
			players.setJerseyNumber(jersey);
			players.setCountry(country);
			players.setStream(stream);
			playerslist.add(players);
			
			gs.setAdapter(adapter);
		}
	}

		
		
		
		
		
		
		
		
		
	}

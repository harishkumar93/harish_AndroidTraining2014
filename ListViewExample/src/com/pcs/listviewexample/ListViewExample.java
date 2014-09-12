package com.pcs.listviewexample;

import java.util.ArrayList;

import com.pcs.customactivity.CustomAdapter;
import com.pcs.playerslist.Player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;



public class ListViewExample  extends Activity {
	private ListView list_view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		list_view = (ListView)findViewById(R.id.list);
		
		ArrayList<Player> users = new ArrayList<Player>();
		CustomAdapter adapter = new CustomAdapter(ListViewExample.this, users);
		
		Player players = new Player();
		
		players.setPlayerName("M.S.Dhoni");
		players.setJerseyNumber("7");
		players.setCountry("India");
		players.setStream("Batsmen");
		users.add(players);
		players = new Player();
		players.setPlayerName("Sachin Tendulkar");
		players.setJerseyNumber("10");
		players.setCountry("India");
		players.setStream("Batsmen");
		users.add(players);
		players = new Player();
		players.setPlayerName("Adam Gilchrist");
		players.setJerseyNumber("18");
		players.setCountry("Australia");
		players.setStream("Batsmen");
		users.add(players);
		players = new Player();
		players.setPlayerName("Glenn McGrath");
		players.setJerseyNumber("56");
		players.setCountry("Australia");
		players.setStream("Bowler");
		users.add(players);
		
		list_view.setAdapter(adapter);

list_view.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            Toast.makeText(ListViewExample.this, "" + position, Toast.LENGTH_SHORT).show();
        }
    });
		
		
		
		
		
		
		
		
		
	}
	
	


}

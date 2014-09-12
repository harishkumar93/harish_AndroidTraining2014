package com.pcs.customactivity;

import java.util.ArrayList;

import com.pcs.listviewexample.ListViewExample;
import com.pcs.playerslist.Player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter  extends BaseAdapter{
	private Context mcontext;
	private ArrayList<Player> playerslist;
 
	public CustomAdapter(ListViewExample listViewExample,
			ArrayList<Player> users) {
		mcontext = listViewExample;
		playerslist = users;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return playerslist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return playerslist.get(position);
		
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv = new TextView(mcontext);
		tv.setText("PlayerName : "+playerslist.get(position).getPlayerName()+ " \n" 
				+"JerseyNumber:" +playerslist.get(position).getJerseyNumber() + "\n"
				+"Country : "+playerslist.get(position).getCountry()+ " \n"
				+"Stream: "+playerslist.get(position).getStream()+ " \n"
			);
		return tv;
	}

	
}

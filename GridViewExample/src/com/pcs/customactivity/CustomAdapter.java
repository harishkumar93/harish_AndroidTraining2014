package com.pcs.customactivity;

import java.util.ArrayList;

import com.pcs.gridviewexample.GridViewExample;
import com.pcs.listviewexample.R;
import com.pcs.playerslist.Player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter  extends BaseAdapter{
	private Context mcontext;
	private ArrayList<Player> playerslist;
	private LayoutInflater layoutInflater;

	public CustomAdapter(GridViewExample listViewExample,
			ArrayList<Player> users) {
		mcontext = listViewExample;
		playerslist = users;
		layoutInflater = LayoutInflater.from(mcontext);
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
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		Player players = (Player) getItem(position);
		if(convertView==null)
		{
			convertView = layoutInflater.inflate(R.layout.details, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.player_image);
			holder.nameTxt = (TextView)convertView.findViewById(R.id.player_name);
			holder.jerseyTxt = (TextView)convertView.findViewById(R.id.player_jersey);
			holder.countryTxt = (TextView)convertView.findViewById(R.id.player_country);
			holder.streamTxt = (TextView)convertView.findViewById(R.id.player_stream);
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder)convertView.getTag();
		}
		holder.imageView.setBackgroundResource(R.drawable.player);
		holder.nameTxt.setText(players.getPlayerName());
		holder.jerseyTxt.setText(players.getJerseyNumber());
		holder.countryTxt.setText(players.getCountry());
		holder.streamTxt.setText(players.getStream());
		convertView.setPadding(4, 4, 4, 4);
		return convertView;
	}
	public class ViewHolder
	{
		public ImageView imageView;
		public TextView nameTxt;
		public TextView jerseyTxt;
		public TextView countryTxt;
		public TextView streamTxt;

	}
public void addPlayers(ArrayList<Player> players){
	if(playerslist!=null)
	{
		playerslist = new ArrayList<Player>(players);
	}
	if(players!=null)
	{
		for (Player player : players) {
			playerslist.add(player);
		}
		notifyDataSetChanged();
	}
		else
			throw new IllegalArgumentException("Players Array List should not be null");
	}
public void addPlayer(Player player)
{
	if(playerslist!=null)
	{
		playerslist.add(player);
		notifyDataSetChanged();
	}
	else
		throw new IllegalArgumentException("Player Information should not be null");
}
}
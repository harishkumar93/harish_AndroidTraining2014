package com.pcs.customactivity;

import java.util.ArrayList;

import com.pcs.listviewexample.ListViewExample;
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

	public CustomAdapter(ListViewExample listViewExample,
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
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Player players = (Player) getItem(position);
		ViewHolder holder = null;

		if(convertView==null)
		{
			convertView = layoutInflater.inflate(R.layout.details, null);
			holder = new ViewHolder();
			holder.imageView = (ImageView) convertView.findViewById(R.id.player_image);

			holder.nameTxt = (TextView)convertView.findViewById(R.id.player_name);
			holder.jerseyTxt = (TextView)convertView.findViewById(R.id.player_jersey);
			holder.countryTxt = (TextView)convertView.findViewById(R.id.player_country);
			holder.streamTxt = (TextView)convertView.findViewById(R.id.player_stream);
		}
		if(position==0)
		{
			holder.imageView.setBackgroundResource(R.drawable.dhoni);


		}

		else if(position==1)
		{
			holder.imageView.setBackgroundResource(R.drawable.sachin);


		}
		else if(position==2)
		{
			holder.imageView.setBackgroundResource(R.drawable.gilly);


		}
		else if(position==3)
		{
			holder.imageView.setBackgroundResource(R.drawable.mcgrath);


		}

		holder.nameTxt.setText("Player Name:-"+players.getPlayerName());
		holder.jerseyTxt.setText("Jersey No:-"+players.getJerseyNumber());
		holder.countryTxt.setText("Country:-"+players.getCountry());
		holder.streamTxt.setText("Stream:-"+players.getStream());


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

}

package com.pcs.customadapter;

import java.util.ArrayList;

import com.pcs.jsonlist.R;
import com.pcs.model.UserDetails;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ListView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	
	private Context mContext;
	private ArrayList<UserDetails>  user;
	private LayoutInflater layoutInflater;
	

	public CustomAdapter(Context context, ArrayList<UserDetails> users) {
		
		mContext = context;
		user = users;
		
		layoutInflater = LayoutInflater.from(context);
	}
		
		public int getCount() {
			return user.size();
		}

		//returns position of object
		@Override
		public UserDetails getItem(int position) {
			return user.get(position);
			
			
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView,ViewGroup parent) {
			ViewHolder holder = null;
			
			
			if(convertView==null)
			{
				convertView =layoutInflater.inflate(R.layout.display, null);
				holder = new ViewHolder();

				holder.nameTxt = (TextView)convertView.findViewById(R.id.name_txt);
				holder.emailTxt = (TextView)convertView.findViewById(R.id.email_txt);
				holder.phoneTxt = (TextView)convertView.findViewById(R.id.phone_txt);
				holder.eidTxt = (TextView)convertView.findViewById(R.id.id_txt);
				holder.streamTxt = (TextView)convertView.findViewById(R.id.stream_txt);
		
				convertView.setTag(holder);
			}
			else {
				holder = (ViewHolder)convertView.getTag();
			}
				
			UserDetails userdetails = getItem(position); 
			
			holder.nameTxt.setText(userdetails.getUserName());
			holder.emailTxt.setText(userdetails.getEmail());
			holder.phoneTxt.setText(userdetails.getPhoneNumber());
			holder.eidTxt.setText(userdetails.getId());
			holder.streamTxt.setText(userdetails.getStream());
			holder.nameTxt.setTextSize(15);
			convertView.setPadding(5, 10, 5, 10);
			return convertView;
		}
		public class ViewHolder{
			public TextView nameTxt;
			public TextView emailTxt;
			public TextView phoneTxt;
			
			public TextView streamTxt;
			public TextView eidTxt;
		}
	
}


	
	
package com.pcs.jsonlist;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pcs.customadapter.CustomAdapter;
import com.pcs.model.UserDetails;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity{
	private Button clickBtn ;
	private ListView listView ;
	private ProgressDialog progressBar; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
			clickBtn = (Button)findViewById(R.id.click_btn);
			listView = (ListView) findViewById(R.id.list_view);
			
			clickBtn.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					
					new DownloadPage(MainActivity.this, listView).execute();				
					
				}
			});
		}
	
		

		
	private  class DownloadPage extends AsyncTask<String, Integer, String>
	{
		private ProgressDialog progressBar;
		private Context context;
		private StringBuilder stringBuilder;
		private ListView listview;
		private ArrayList<UserDetails>users;
		private CustomAdapter adapter;
		private UserDetails user;
		
		public DownloadPage(Activity activity, ListView listView) {
			context = activity;
			progressBar = new ProgressDialog(context);
			listview = listView;
					
		}
		
		
		protected void onPreExecute()
		{
			
			progressBar.setTitle(getResources().getString(R.string.json_download));
			progressBar.setMessage("Loading Details");
			progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressBar.show();
			super.onPreExecute();
		}
		@Override
		protected String doInBackground(String... params) {
		
			URL url;
			try {
				url = new URL("http://192.168.4.6/users");
				URLConnection con = url.openConnection();
				con.connect();
				InputStream inputStream = con.getInputStream();
				InputStreamReader isReader = new InputStreamReader(inputStream);
				BufferedReader reader = new BufferedReader(isReader);
				stringBuilder = new StringBuilder();
				String line = null;
				
				while((line=reader.readLine())!=null)
				{
					
					stringBuilder.append(line);
				}

			} 
			catch (MalformedURLException e1) {
				e1.printStackTrace();
			}catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(stringBuilder.toString()==null)
			{
				return null;
				
			}
			else
				
				return stringBuilder.toString();

		}
		@Override
		protected void onProgressUpdate(Integer... values) {

			super.onProgressUpdate(values[0]);
		}
		@Override
		protected void onPostExecute(String result) {
		
			
			try {
				JSONObject jobj = new JSONObject(result);
				JSONArray jsonArray = jobj.getJSONArray("users_list");
				int size = jsonArray.length();
				
				users = new ArrayList<UserDetails>();
				adapter = new CustomAdapter(context, users);
				
				for (int i = 0; i < size; i++) {
					
					
						user = new UserDetails(); 
					 JSONObject obj = new JSONObject(); 
					 obj=jsonArray.getJSONObject(i);
					
						
				if(obj.has("id"))
				{
					  user.setId(obj.getString("id"));
					 
				}
				if(obj.has("name"))
				{
					  user.setUserName(obj.getString("name"));

					
				}
				
				if(obj.has("email"))
				{
					  user.setEmail(obj.getString("email"));

			
				}
				
				if(obj.has("phone_number"))
				{
					 user.setPhoneNumber(obj.getString("phone_number"));

					
				}
				
				
				if(obj.has("stream"))
				{
					  user.setStream(obj.getString("stream"));

				
				}
				users.add(user);
				listview.setAdapter(adapter);
				
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progressBar.dismiss();
		}
		}



	}
	
	





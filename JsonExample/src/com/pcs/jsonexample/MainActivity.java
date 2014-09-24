package com.pcs.jsonexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{
	private Button jsonBtn;
	private TextView idTxt;
	private TextView genderTxt;
	private TextView lastNameTxt;
	private TextView firstNameTxt;

	private TextView nameTxt;
	private StringBuilder stringBuilder;
	private Context context;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		idTxt = (TextView)findViewById(R.id.id_txt);
		nameTxt = (TextView)findViewById(R.id.name_txt);
		firstNameTxt = (TextView)findViewById(R.id.firstName_txt);
		lastNameTxt = (TextView)findViewById(R.id.lastName_txt);
		genderTxt = (TextView)findViewById(R.id.gender_txt);
		jsonBtn = (Button)findViewById(R.id.json_button);
		jsonBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DownloadPage(MainActivity.this).execute();				
			}
		});

	}


	private  class DownloadPage extends AsyncTask<String, Integer, String>
	{
		private ProgressDialog progressBar;
		public DownloadPage(MainActivity mainActivity) {
			context = mainActivity;
			progressBar = new ProgressDialog(context);
			progressBar.setTitle(getResources().getString(R.string.json_download));
			progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			
		}

		@Override
		protected void onPreExecute() {
			progressBar.setMessage(getResources().getString(R.string.download));
			progressBar.show();
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... args)
		{
			URL url;
			try {
				url = new URL( "http://graph.facebook.com/12345");
				URLConnection con = url.openConnection();
				con.connect();
				InputStream inputStream = con.getInputStream();
				InputStreamReader isReader = new InputStreamReader(inputStream);
				BufferedReader reader = new BufferedReader(isReader);
				stringBuilder = new StringBuilder();
				String line = null;
				
				while((line=reader.readLine())!=null)
				{
					progressBar.setProgress(100);
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
				progressBar.dismiss();
			}
			return stringBuilder.toString();

		}

		@Override
		protected void onProgressUpdate(Integer... values) {

			super.onProgressUpdate(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			JSONObject jsonObj;
			String obj = null;
			try {
				jsonObj = new JSONObject(result);
				if(jsonObj.has("id"))
				{
					 obj = jsonObj.getString("id");
					 idTxt.setText(obj);
				}
				if(jsonObj.has("name"))
				{
					 obj = jsonObj.getString("name");
					 nameTxt.setText(obj);
				}
				
				if(jsonObj.has("first_name"))
				{
					 obj = jsonObj.getString("first_name");
					 firstNameTxt.setText(obj);
				}
				
				if(jsonObj.has("last_name"))
				{
					 obj = jsonObj.getString("last_name");
					lastNameTxt.setText(obj);
				}
				
				
				if(jsonObj.has("gender"))
				{
					 obj = jsonObj.getString("gender");
					 genderTxt.setText(obj);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progressBar.dismiss();
		}
	}
}
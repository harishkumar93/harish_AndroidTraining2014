package com.pcs.menuexample;


import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity  extends Activity{
	 
	private Button musicBtn;

	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		musicBtn = (Button)findViewById(R.id.music_btn);
		/***
		 * Registration is mandatory for Context menu
		 * But it is not required for Options menu
		 */
		registerForContextMenu(musicBtn);
	}
	 
	 
	 
	 @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		 MenuInflater menuInflater = getMenuInflater();
			menuInflater.inflate(R.menu.contextmenu, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
		
		
		/**
		 * Prints a toast message when ever we click an item in Context Menu
		 */
		
	}
	 @Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.context_addPlaylist :
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_add), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_selected :
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_select), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_multiple :
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_multiple), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_delete:
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_delete), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_deleteMultiple :
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_deleteMultiple), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_list :
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_list), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_title :
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_title), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_recent :
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_recent), Toast.LENGTH_LONG).show();
			break;
			
		case R.id.context_details:
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_details), Toast.LENGTH_LONG).show();
			break;
			

		default:
			break;
		}
		 
		return super.onContextItemSelected(item);
	}
	 
	 @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 MenuInflater menuInflater = getMenuInflater();
			menuInflater.inflate(R.menu.optionmenu, menu);
		
			
		 
		 return super.onCreateOptionsMenu(menu);

	 }

		/**
		 * Prints a toast message when ever we click an item in Option Menu
		 */
	 @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 
		 switch (item.getItemId()) {
		case R.id.option_artist:
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_artist), Toast.LENGTH_LONG).show();		
			break;
			
		case R.id.option_albums:
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_albums), Toast.LENGTH_LONG).show();		
			break;
			
		case R.id.option_playlists:
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_playlists), Toast.LENGTH_LONG).show();		
			break;
			
		case R.id.option_songs:
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_songs), Toast.LENGTH_LONG).show();		
			break;
			
		case R.id.option_recordings:
			Toast.makeText(MainActivity.this, getResources().getString(R.string.res_recordings), Toast.LENGTH_LONG).show();		
			break;

		default:
			break;
		}
		 
		 
				return super.onOptionsItemSelected(item);
	}
	 
}

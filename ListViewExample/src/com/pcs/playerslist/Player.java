package com.pcs.playerslist;

import android.widget.AdapterView;

public class Player {
	private String playerName;
	private String jerseyNumber;
	private String country;
	private String stream;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(String jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}


	public static Player get(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

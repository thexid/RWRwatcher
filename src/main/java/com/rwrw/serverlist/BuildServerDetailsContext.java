package com.rwrw.serverlist;

/**
 * Holds all information related to a single server's information that we put onto the server list on the main scene
 * 
 * @author XiD
 *
 */
public class BuildServerDetailsContext {
	public String name;
	public String location;
	public String mode;
	public String map;
	public String players;
	public String bots;
	public String ping;
	
	public BuildServerDetailsContext() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}
	public String getBots() {
		return bots;
	}
	public void setBots(String bots) {
		this.bots = bots;
	}
	public String getPing() {
		return ping;
	}
	public void setPing(String ping) {
		this.ping = ping;
	}
}
package com.rwrw.serverlist;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Responsible for generation of all JavaFX Nodes related to the display of the server list
 * 
 * @author XiD
 */
public class ServerListNodeBuilder {
	
	private static int rowIndex = 1;

	/**
	 * Builds a static list of server headers Label nodes:
	 * 
	 * Server Name | Server Version | Mode | Map | Players | Bots | Ping
	 * 
	 * @return
	 */
	public List<Node> buildServerListHeaders() {
		List<Node> response = new ArrayList<>();

		Label serverName = new Label("Server name");
		GridPane.setConstraints(serverName, 0, 0);
		GridPane.setMargin(serverName, new Insets(0, 0, 0, 10));
		response.add(serverName);
		
		Label players = new Label("Players");
		GridPane.setConstraints(players, 1, 0);
		response.add(players);

		Label map = new Label("Map");
		GridPane.setConstraints(map, 2, 0);
		response.add(map);

		Label mode = new Label("Mode");
		GridPane.setConstraints(mode, 3, 0);
		response.add(mode);
		
		Label location = new Label("Location");
		GridPane.setConstraints(location, 4, 0);
		GridPane.setMargin(location, new Insets(0, 10, 0, 0));
		response.add(location);
		
		//Reset the global rowIndex counter now that we've generated the header row
		rowIndex = 1;

		return response;
	}

	public List<Node> buildServerDetails(BuildServerDetailsContext serverInfo) {
		List<Node> response = new ArrayList<>();

		Label serverName = new Label(serverInfo.getName());
		GridPane.setConstraints(serverName, 0, rowIndex);
		GridPane.setMargin(serverName, new Insets(0, 0, 0, 10));
		response.add(serverName);


		Label players = new Label(serverInfo.getPlayers());
		GridPane.setConstraints(players, 1, rowIndex);
		response.add(players);

		Label map = new Label(serverInfo.getMap());
		GridPane.setConstraints(map, 2, rowIndex);
		response.add(map);
		
		
		Label mode = new Label(serverInfo.getMode());
		GridPane.setConstraints(mode, 3, rowIndex);
		response.add(mode);

		Label location = new Label(serverInfo.getLocation());
		GridPane.setConstraints(location, 4, rowIndex);
		GridPane.setMargin(location, new Insets(0, 10, 0, 0));
		response.add(location);

		//Increment the row index so we ensure the next record will be on it's own row
		rowIndex++;

		return response;
	}
}

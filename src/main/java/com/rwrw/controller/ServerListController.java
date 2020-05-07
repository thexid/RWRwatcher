package com.rwrw.controller;

import java.util.List;

import com.rwrw.api.RWRStatsAPI;
import com.rwrw.serverlist.BuildServerDetailsContext;
import com.rwrw.serverlist.ServerListNodeBuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ServerListController {
	private ServerListNodeBuilder serverListNodeBuilder;
	private RWRStatsAPI rwrStatsAPI;
	private final Stage primaryStage;
	
	public ServerListController(Stage primaryStage) {
		serverListNodeBuilder = new ServerListNodeBuilder();
		rwrStatsAPI = new RWRStatsAPI();
		this.primaryStage = primaryStage;
	}
	
	@FXML
	public void refreshServers() {
        
        //Clear all existing rows from the server list
        serverList.getChildren().clear();
        
        //Add the header row
        serverList.getChildren().addAll(serverListNodeBuilder.buildServerListHeaders());
        
        //Call the API for server information
        List<BuildServerDetailsContext> servers = rwrStatsAPI.retrieveServerList();
       
        //Add each server as a row to the layout
        servers.forEach(serverInfo -> serverList.getChildren().addAll(serverListNodeBuilder.buildServerDetails(serverInfo)));
        
        primaryStage.sizeToScene();
        
    }
	
	@FXML
	private Button refreshServers;
	
	@FXML
	private GridPane serverList;
}

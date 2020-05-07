package com.rwrw;

import com.rwrw.controller.ServerListController;
import com.rwrw.systemtray.SystemTrayBehavior;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Running with Rifles Watcher: The second coming
 */
public class RWRW extends Application {
	int stateWindow = 1;
	private ServerListController serverListController;
	private SystemTrayBehavior systemTrayBehavior;

	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) throws Exception {

		//Set up the basic application initialization: starting scene, controller
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/serverlist.fxml"));
		serverListController = new ServerListController(primaryStage);
		loader.setController(serverListController);
		Parent root = loader.load();
		
		//Some default sizing and display
		primaryStage.setScene(new Scene(root));
		primaryStage.setMinHeight(200);
		primaryStage.setMinWidth(200);
		primaryStage.setTitle("Running With Rifles Watcher");
		primaryStage.sizeToScene();
		
		//Set up our system tray behavior
		systemTrayBehavior = new SystemTrayBehavior(primaryStage, serverListController);
		javax.swing.SwingUtilities.invokeLater(systemTrayBehavior::addAppToTray);
		
		//Don't shut down the application unless they explicitly do so in the system tray
		Platform.setImplicitExit(false);
		
		//Assume the user wants to see the main window if they start the application fresh, so 
		//populate data and show the scene
		serverListController.refreshServers();
    	primaryStage.show();

	}
	
	

	public static void main(String[] args) {
		launch();
	}

}
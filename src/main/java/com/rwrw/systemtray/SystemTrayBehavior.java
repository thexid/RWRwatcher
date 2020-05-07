package com.rwrw.systemtray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;

import com.rwrw.controller.ServerListController;

import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Responsible for all System Tray behavior with the application.
 * 
 * @author XiD
 *
 */
public class SystemTrayBehavior {
	
	private Stage primaryStage;
	private ServerListController mainSceneController;
	
	public SystemTrayBehavior(Stage primaryStage, ServerListController mainSceneController) {
		this.primaryStage = primaryStage;
		this.mainSceneController = mainSceneController;
	}

	/**
	 * Add the application to the system tray and add menu/click functionality to the tray icon
	 */
	public void addAppToTray() {
		//Grab RWR icon so we can use it as our tray icon
		URL url = getClass().getResource("/img/rwricon.png");
		Image image = Toolkit.getDefaultToolkit().getImage(url);
		
		final TrayIcon trayIcon = new TrayIcon(image, "RWRW");
		final SystemTray tray = SystemTray.getSystemTray();
		
		// if the user double-clicks on the tray icon, show the main app stage.
        trayIcon.addActionListener(event -> Platform.runLater(this::showStageAndUpdateServers));

        // Add open item to the system tray menu
        java.awt.MenuItem openItem = new java.awt.MenuItem("Open RWRW");
        openItem.addActionListener(event -> Platform.runLater(this::showStageAndUpdateServers));

        // Add exit item to the system tray menu
        java.awt.MenuItem exitItem = new java.awt.MenuItem("Exit");
        exitItem.addActionListener(event -> {
            Platform.exit();
            tray.remove(trayIcon);
        });

        // Create popup menu for the tray icon and add our two options (open + exit)
        final java.awt.PopupMenu popup = new java.awt.PopupMenu();
        popup.add(openItem);
        popup.addSeparator();
        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);
        
        try {
        	tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("Unable to init system tray");
            e.printStackTrace();
        }
        
	}
	
	private void showStageAndUpdateServers() {
        if (primaryStage != null) {
        	mainSceneController.refreshServers();
        	primaryStage.show();
        	primaryStage.toFront();
        }
    }
}

package com.rwrw.api.mapper;

import java.util.ArrayList;
import java.util.List;

import com.rwrw.api.model.Server;
import com.rwrw.serverlist.BuildServerDetailsContext;

/**
 * Maps the information coming back from the API to the front end server representation object.
 * @author XiD
 *
 */
public class ServerResponseMapper {

	/**
	 * Map the API "RWR server" response object to the front end RWR server object
	 * @param serverResponse
	 * @return
	 */
	public List<BuildServerDetailsContext> mapAPIResponseToFrontend(List<Server> serverResponse) {
		
		List<BuildServerDetailsContext> servers = new ArrayList<>();
		for (Server apiServer : serverResponse) {
			BuildServerDetailsContext server = new BuildServerDetailsContext();
			server.setName(apiServer.getName());
			server.setLocation(apiServer.getLocation().getName());
			server.setMap(apiServer.getMap().getName());
			if (apiServer.getDatabase() != null) {
				server.setMode(apiServer.getDatabase().getName());
			}
			server.setPlayers(generatePlayers(apiServer));
			servers.add(server);
		}
		
		return servers;
	}
	
	private String generatePlayers(Server apiServer) {
		return apiServer.getPlayers().getCurrent() + "/" + apiServer.getPlayers().getMax();
		
	}
}

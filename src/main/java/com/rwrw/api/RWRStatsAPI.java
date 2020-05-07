package com.rwrw.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rwrw.api.mapper.ServerResponseMapper;
import com.rwrw.api.model.Server;
import com.rwrw.serverlist.BuildServerDetailsContext;

public class RWRStatsAPI {
	private String authToken = "b6cbd439-f0e1-4dd1-b327-22f80e48b1b9";
	private static final String API_ROOT_URL = "https://rwrstats.com/api";
	private WebTarget rwrsAPI;
	private ServerResponseMapper serverResponseMapper;
	
	public RWRStatsAPI() {
		Client client = ClientBuilder.newClient();
		rwrsAPI = client.target(API_ROOT_URL);
		serverResponseMapper = new ServerResponseMapper();
	}

	public List<BuildServerDetailsContext> retrieveServerList() {
		//Create our request to send to the API
		Invocation.Builder invocationBuilder = rwrsAPI
				.path("/servers")
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Token " + authToken);
		Response response = invocationBuilder.get();
		
		//Map response into object for frontend display
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			List<Server> serverResponse = jsonMapper.readValue(response.readEntity(String.class), new TypeReference<List<Server>>() {});
			List<BuildServerDetailsContext> servers = serverResponseMapper.mapAPIResponseToFrontend(serverResponse);
			return servers;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO properly handle errors or throw all exceptions up
		List<BuildServerDetailsContext> servers = new ArrayList<>();

		return servers;
	}
}

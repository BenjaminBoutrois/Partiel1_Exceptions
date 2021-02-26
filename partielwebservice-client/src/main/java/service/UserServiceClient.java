package service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import domaine.Student;
import domaine.User;

public class UserServiceClient implements IUserServiceClient  {
	
	
	private static final String url = "http://localhost:8004/SpringMVC/servlet/user/";
		
	public UserServiceClient() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Methode de connexion d'un utilisateur
	 * @param user
	 * @return
	 */
	@Override
	public User login(User user)  {
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url).path("login");
		
		Response response = webTarget.request("application/json").post(Entity.entity(user, MediaType.APPLICATION_JSON));
	
		if(response.getStatus()!=200)
			System.out.println("login error : "+response);
		String output = response.readEntity(String.class);
		//System.out.println(output);
		ObjectMapper mapper = new ObjectMapper();
		User userResponse=null;
		try {
			JsonNode jsonNode = mapper.readTree(output);
			
			 userResponse = mapper.readValue( jsonNode.get("user").toString(),User.class);
			  
			  System.out.println("the user found : "+userResponse.toString()); 
			  return userResponse;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userResponse;
		
		
		  
		 

		
	}
	
	
	/**
	 * Methode pour recuperer un user
	 * @return
	 */
	@Override
	public User getUser() {
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url).path("get");
		
		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(User.class);
	}

}

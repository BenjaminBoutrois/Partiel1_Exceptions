package service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import domaine.Course;
import domaine.Student;

public class CoursServiceClient implements ICoursServiceClient  {
	
	private static final String url = "http://localhost:8004/SpringMVC/servlet/course/";
	
	public CoursServiceClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methode pour recupere la liste des cours
	 * @return
	 */
	@Override
	public List<Course> getAllCours(){
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);
		
		
		Client client = ClientBuilder.newClient(clientConfig);		
		WebTarget webTarget = client.target(url).path("getAll");
		Response response = webTarget.request("application/json").get();
		System.out.println("sdfghjkl"+response);
		List<Course> listeCours = response.readEntity(new GenericType<List<Course>>(){});
			System.out.println("cours : " +listeCours);

		 return listeCours;
		
	}
	
	/**
	 * Methode pour rechercher un cours par son id
	 * @param id
	 * @return
	 */
	@Override
	public Course getCoursById(Long id) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("detail/"+id);
		
		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(Course.class);
		
	}
	
	/**
	 * Methode pour créer un cours
	 * @param cours
	 * @return
	 */
	@Override
	public Response createCours(Course cours) {
		
		Client client  = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("create");
		Response response = webTarget.request("application/json").post(Entity.entity(cours, MediaType.APPLICATION_JSON));
		return response;
	}
	
	/**
	 * Methode pour modifie un cours
	 * @param id
	 * @param cours
	 * @return
	 */
	@Override
	public Response updateCours(Long id , Course cours) {
		
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("update/"+id);
		Response response = webTarget.request("application/json").put(Entity.entity(cours, MediaType.APPLICATION_JSON));
		return response;
	}
	
	/**
	 * Methode pour supprimer un cours
	 * @param id
	 * @return
	 */
	@Override
	public Response deleteCours(Long id) {
		
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget =  client.target(url).path("delete/"+id);
		Response response = webTarget.request("application/json").delete();
		return response;
		
	}


}

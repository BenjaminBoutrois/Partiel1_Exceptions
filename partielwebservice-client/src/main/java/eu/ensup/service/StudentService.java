package eu.ensup.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import eu.ensup.domaine.Student;

@Service
public class StudentService implements IStudentService
{
	private static final String url = "http://localhost:8004/SpringMVC/servlet/student/";

	public StudentService()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methode pour recuperer la liste des etudiants
	 * 
	 * @return
	 */
	@Override
	public List<Student> getListStudent()
	{
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);

		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(url).path("getAll");

		Response response = webTarget.request("application/json").get();

		List<Student> listEtudiant = response.readEntity(new GenericType<List<Student>>()
		{
		});
		System.out.println("etudiants : " + listEtudiant);

		return listEtudiant;
	}

	/**
	 * Methode pour crée un étudiant
	 * 
	 * @param student
	 * @return
	 */

	@Override
	public Response createStudent(Student student)
	{
		Response response = null;

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(url).path("create");

		ObjectMapper objectMapper = new ObjectMapper();
		String input;

		try
		{
			input = objectMapper.writeValueAsString(student);
			response = webTarget.request("application/json").post(Entity.json(input));

		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * Methode pour recuperer un etudiant par son id
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Student getStudentById(Long id)
	{
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url).path("detail/" + id);

		Response response = webTarget.request("application/json").get();

		return response.readEntity(Student.class);
	}

	/**
	 * ethode de recherche d'etudiant par son nom et prenom
	 * 
	 * @param first_name
	 * @param last_name
	 * @return
	 */
	@Override
	public List<Student> getStudentByFirstAndLastName(String first_name, String last_name)
	{
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url).path("research/" + first_name + "/" + last_name);

		Response response = webTarget.request("application/json").get();
		List<Student> listEtudiant = response.readEntity(new GenericType<List<Student>>()
		{
		});

		return listEtudiant;
	}

	/**
	 * Methode de suppression d'etudiant
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Response deleteStudent(Long id)
	{
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(url).path("delete/" + id);

		Response response = webTarget.request("application/json").delete();

		return response;
	}

	/**
	 * Methode de mise a jour des informations d'un etudiant
	 * 
	 * @param id
	 * @param etudiant
	 * @return
	 */
	@Override
	public Response updateStudent(Long id, Student etudiant)
	{
		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(url).path("update/" + id);

		Response response = webTarget.request("application/json")
				.put(Entity.entity(etudiant, MediaType.APPLICATION_JSON));

		return response;
	}
}

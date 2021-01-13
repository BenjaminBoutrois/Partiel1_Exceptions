package eu.ensup.partielspringbootweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partielspringbootweb.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	 User findByLoginAndPassword(String login,String password);
}

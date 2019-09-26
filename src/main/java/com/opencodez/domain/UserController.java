package com.opencodez.domain;



/*import repositories.ModelRepository;*/

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opencodez.domain.Users;
import com.opencodez.repo.UserRepository;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
	
	  @Autowired
	  private UserRepository repository;
	  
	  @RequestMapping(value = "/all", method = RequestMethod.GET)
	  public List<Users> getAlluser() {
		System.out.println("wwwwwwwwwwwwwwwwwww");
	    return repository.findAll();
	  }
	  
	  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	  public String testPrint() {
		  String s = "hello world";
		  System.out.println(s);
		  return s;
	  }

	  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	  public Users getModelById(@PathVariable("name") String name) {
	    return repository.findFirstByName(name);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyModelById(@PathVariable("id") String id, @Valid @RequestBody Users user) {
		user.setId(id);
	    repository.save(user);
	  }
	  
	  @RequestMapping(value = "/all", method = RequestMethod.POST)
	  public Users createModel(@Valid @RequestBody Users user) {
		//user.setId(user.getId());
	    repository.save(user);
	    return user;
	  }
	  
	  @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	  public void deleteModel(@PathVariable String name) {
	    repository.delete(repository.findFirstByName(name));
	  }

}

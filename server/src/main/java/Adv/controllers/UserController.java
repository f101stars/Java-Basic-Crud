package Adv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Adv.models.User;
import Adv.services.IServices.IUserService;
@CrossOrigin(origins = "http://localhost:3000/")

@RestController
public class UserController {
	@Autowired
	private IUserService service;

	@PostMapping("/users/add")
	public Boolean add(@RequestBody User u) {
		return service.add(u);
	}
	
	@PostMapping("/users/find")
	public boolean find(@RequestBody User u)
	{
		return service.find(u.getEmail(), u.getPassword());
	}
	
	@GetMapping("/users")
	public List<User> getAll(){
		return service.getAll();		
	}
	
}

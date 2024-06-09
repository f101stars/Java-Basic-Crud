package Adv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Adv.models.AdvEntrances;
import Adv.models.AdvTime;
import Adv.models.User;
import Adv.services.IServices.IAdvTimeService;
import Adv.services.IServices.IUserService;
import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class AdvTimeController {
	@Autowired
	private IAdvTimeService service;
	
	@PostMapping("/adv/time/add")
	public Boolean add(@RequestBody AdvTime u) {
		return service.add(u);
	}
	
	@GetMapping("/adv/time/current/{location}")
	public String currentAdv(@PathVariable int location)
	{
		return service.currentAdvInPlace(location);
	}
	@GetMapping("/adv/time")
	public List<AdvTime> getAll(){
		return service.getAll();		
	}

}

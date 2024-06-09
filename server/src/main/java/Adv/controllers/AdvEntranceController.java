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
import Adv.services.IServices.IAdvEntranceService;
import Adv.services.IServices.IAdvTimeService;
import Adv.services.IServices.IUserService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class AdvEntranceController {
	@Autowired
	private IAdvEntranceService service;
	
	@PostMapping("/adv/entrance/add")
	public Boolean add(@RequestBody AdvEntrances u) {
		return service.add(u);
	}
	
	@PostMapping("/adv/entrance/current/{location}")
	public String currentAdv(@PathVariable int location)
	{
		return service.currentAdvInPlace(location);
	}
	@GetMapping("/adv/entrance")
	public List<AdvEntrances> getAll(){
		return service.getAll();		
	}

}

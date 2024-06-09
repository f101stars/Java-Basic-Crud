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
import Adv.models.baseAdv;
import Adv.services.IServices.IAdvEntranceService;
import Adv.services.IServices.IAdvService;

@CrossOrigin(origins="http://localhost:3000")

@RestController
public class AdvController {
	@Autowired
	private IAdvService service;
	
	@PostMapping("/adv/add")
	public Boolean add(@RequestBody baseAdv u) {
		return service.add(u);
	}
	
	@PostMapping("/adv/current/{location}")
	public String currentAdv(@PathVariable int location)
	{
		return service.currentAdvInPlace(location);
	}
	@GetMapping("/adv")
	public List<baseAdv> getAll(){
		return service.getAll();		
	}

}

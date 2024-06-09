package Adv.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import Adv.models.*;
//import Adv.services.services.*;
//import Adv.services.IServices.*;
//import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@ComponentScan("Adv.controllers")
@ComponentScan("Adv.services")
@EntityScan("Adv")
@EnableJpaRepositories("Adv.doa")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	
	}

}

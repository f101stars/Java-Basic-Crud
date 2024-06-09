package Adv.services.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adv.doa.UserRepository;
import Adv.models.User;
import Adv.services.IServices.IUserService;
@Service
public class UserService implements IUserService{
@Autowired
	private UserRepository rep;
	@Override
	public boolean add(User u) {
		if(rep.existsById(u.getEmail()))
			return false;
		rep.save(u);
		return true;
	}

	@Override
	public boolean find(String email, String password) {
		try{
			User u = rep.findById(email).get();
			if(u!=null && u.getPassword().equals(password))
			return true;
			return false;

		}
		catch (Exception e) {
return false;		}
//		System.out.println(u.getEmail()+"pass:"+u.getPassword());
//		System.out.println();
		
	}

	@Override
	public List<User> getAll() {
		List<User>users=new ArrayList<>();
		rep.findAll().forEach(u->users.add(u));
		return users;
		
	}

}

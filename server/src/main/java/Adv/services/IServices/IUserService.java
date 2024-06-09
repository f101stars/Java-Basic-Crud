package Adv.services.IServices;

import java.util.List;

import Adv.models.User;

public interface IUserService {
	boolean add(User u);
	boolean find(String email, String password);
	List<User> getAll();
}

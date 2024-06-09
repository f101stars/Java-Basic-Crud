package Adv.services.IServices;

import java.util.List;

import Adv.models.AdvEntrances;
import Adv.models.baseAdv;

public interface IAdvService {
	boolean add(baseAdv t);
	String currentAdvInPlace(int location);
	List<baseAdv> getAll();

}

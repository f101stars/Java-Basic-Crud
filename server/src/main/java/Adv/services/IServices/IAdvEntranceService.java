package Adv.services.IServices;

import java.util.List;

import Adv.models.AdvEntrances;
import Adv.models.AdvTime;

public interface IAdvEntranceService {
	boolean add(AdvEntrances t);
	String currentAdvInPlace(int location);
	List<AdvEntrances> getAll();
}

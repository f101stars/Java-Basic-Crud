package Adv.services.IServices;

import java.util.List;

import Adv.models.AdvTime;

public interface IAdvTimeService {
	boolean add(AdvTime t);
	String currentAdvInPlace(int location);
	List<AdvTime> getAll();
}

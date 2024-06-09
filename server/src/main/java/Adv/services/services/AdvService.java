package Adv.services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adv.doa.AdvRepository;
import Adv.doa.EntrancesRepository;
import Adv.models.AdvEntrances;
import Adv.models.AdvTime;
import Adv.models.baseAdv;
import Adv.services.IServices.IAdvEntranceService;
import Adv.services.IServices.IAdvService;
import Adv.services.IServices.IAdvTimeService;
@Service
public class AdvService implements IAdvService{
	@Autowired
	private AdvRepository rep;
	@Autowired
	private IAdvTimeService AdvTimeService;
	@Autowired
	private IAdvEntranceService AdvEntranceService;
	


	@Override
//	public boolean add(baseAdv t) {
////		if(t instanceof AdvTime)
////			return AdvTimeService.add((AdvTime)t);
////		else 
////			return AdvEntranceService.add((AdvEntrances)t);
//		try {
//			System.out.println((AdvTime)t);
//			return AdvTimeService.add((AdvTime)t);
//		}catch(Exception e){
//			System.out.println(e);
//		}
//		
//		try {
//			System.out.println((AdvEntrances)t);
//			return AdvEntranceService.add((AdvEntrances)t);
//		}catch(Exception e){
//			System.out.println(e);
//			return false;
//		}
//		
//		
//		
//		
//	}
	public boolean add(baseAdv t) {
	    if (t == null) {
	        // Handle null object
	        return false;
	    }
	    
	    if (t instanceof AdvTime) {
	        System.out.println("Adding AdvTime...");
	        return AdvTimeService.add((AdvTime) t);
	    } else if (t instanceof AdvEntrances) {
	        System.out.println("Adding AdvEntrances...");
	        return AdvEntranceService.add((AdvEntrances) t);
	    } else {
	        // Handle unknown subtype
	        System.out.println("Unknown subtype: " + t.getClass().getSimpleName());
	        return false;
	    }
	}
	@Override
	public String currentAdvInPlace(int location) {

			return AdvTimeService.currentAdvInPlace(location)+AdvEntranceService.currentAdvInPlace(location);

	}

	@Override
	public List<baseAdv> getAll() {
		List<baseAdv> advs= new ArrayList<>();
		advs.addAll(AdvTimeService.getAll());
		advs.addAll(AdvEntranceService.getAll());
		return advs;
		
	}

}

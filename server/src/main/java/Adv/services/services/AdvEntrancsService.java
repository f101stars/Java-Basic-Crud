package Adv.services.services;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adv.doa.EntrancesRepository;
import Adv.doa.TimeRepository;
import Adv.models.AdvEntrances;
import Adv.models.AdvTime;
import Adv.services.IServices.IAdvEntranceService;
import Adv.services.IServices.IAdvTimeService;

@Service
public class AdvEntrancsService implements IAdvEntranceService {

	@Autowired
	private EntrancesRepository rep;

	@Override
	public String currentAdvInPlace(int location) {
		ArrayList<AdvEntrances> l = new ArrayList<>();
		rep.findAll().forEach(a -> l.add(a));
		for (AdvEntrances a : l) {
			if (a.getLocation() == location && a.isActive()) {
				if (a.getDesiredEntrances() - a.getUsedEntrances() <= 0) {
					a.setActive(false);
					return "";
				}
				return a.getImg();
			}
		}
		return "";
	}

	@Override
	public boolean add(AdvEntrances t) {
		t.setUsedEntrances(0);
		t.setActive(true);
		if (rep.existsById(t.getId()))
			return false;

		rep.save(t);
		return true;
	}

	@Override
	public List<AdvEntrances> getAll() {
		List<AdvEntrances> a = new ArrayList<>();
		rep.findAll().forEach(u -> {
			if ((2*u.getDesiredEntrances() - u.getUsedEntrances() )<= 0) {
				u.setActive(false);
				System.out.println(u.getDesiredEntrances() - u.getUsedEntrances());
			} else {
				u.setUsedEntrances(u.getUsedEntrances() + 1);

				a.add(u);

			}
			rep.save(u);
		});

		return a;
	}

}

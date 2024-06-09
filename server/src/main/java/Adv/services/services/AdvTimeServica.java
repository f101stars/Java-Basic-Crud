package Adv.services.services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adv.doa.TimeRepository;
import Adv.models.AdvTime;
import Adv.models.User;
import Adv.services.IServices.IAdvTimeService;

@Service
public class AdvTimeServica implements IAdvTimeService {
	@Autowired
	private TimeRepository rep;

	@Override
	public boolean add(AdvTime t) {
		t.setTimeStart(LocalDate.now());
		if (rep.existsById(t.getId()))
			return false;
		rep.save(t);
		return true;
	}

	@Override
	public String currentAdvInPlace(int location) {

		ArrayList<AdvTime> l = new ArrayList<>();
		rep.findAll().forEach(a -> l.add(a));
		for (AdvTime a : l) {

			if (a.getLocation() == location && a.isActive()) {
				if ((ChronoUnit.MINUTES.between(a.getTimeStart(), LocalDate.now()) >= (a.getDesiredMinutes()))) {
					a.setActive(false);
					return "פג תוקף התמונה הקודמת במקום זה";
				}
				return a.getImg();
			}
		}

		return "לא קיימת תמונה במקום זה";
	}

	@Override
	public List<AdvTime> getAll() {
		List<AdvTime> a = new ArrayList<>();
		rep.findAll().forEach(u -> a.add(u));
		
		return a;

	}
}
package com.pcj.myworkspace.opendata.sun;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SunDailyController {

	private SunDailyRepository repo;

	public SunDailyController(SunDailyRepository repo) {
		this.repo = repo;
	}

	@RequestMapping(value = "/opendata/sun/daily", method = RequestMethod.GET)
	public List<SunDaily> getListByDataType() {
		Order[] orders = { new Order(Sort.Direction.DESC, "locdate"), new Order(Sort.Direction.ASC, "location") };

		return repo.findAll(PageRequest.of(0, 389, Sort.by(orders))).toList();
	}

}

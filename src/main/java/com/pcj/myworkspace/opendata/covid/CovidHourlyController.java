package com.pcj.myworkspace.opendata.covid;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidHourlyController {
	private CovidHourlyRepository repo;

	public CovidHourlyController(CovidHourlyRepository repo) {
		this.repo = repo;
	}

	@RequestMapping(value = "/opendata/covid/hourly", method = RequestMethod.GET)
	public List<CovidHourly> getListByDataType() {
		Order[] orders = { new Order(Sort.Direction.DESC, "stateDt"), new Order(Sort.Direction.ASC, "stateTime") };
		return repo.findAll(PageRequest.of(0, 24, Sort.by(orders))).toList();
	}

}

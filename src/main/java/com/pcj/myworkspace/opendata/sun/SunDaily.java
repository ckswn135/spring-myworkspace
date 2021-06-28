package com.pcj.myworkspace.opendata.sun;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@IdClass(SunDailyId.class)
public class SunDaily {

	@Id
	private String locdate;
	@Id
	private String location;

	private String sunrise;
	private String sunset;
	private String moonrise;
	private String moonset;

	public SunDaily(SunDailyResponse.Item item) {
		this.locdate = item.getLocdate();
		this.location = item.getLocation();
		this.sunrise = item.getSunrise();
		this.sunset = item.getSunset();
		this.moonrise = item.getMoonrise();
		this.moonset = item.getMoonset();
	}
}

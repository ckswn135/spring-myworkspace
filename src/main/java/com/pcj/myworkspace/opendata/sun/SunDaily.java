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

	private String longitude;
	private String longitudeNum;
	private String latitude;
	private String latitudeNum;
	private String sunrise;
	private String suntransit;
	private String sunset;
	private String moonrise;
	private String moontransit;
	private String moonset;
	private String civilm;
	private String civile;
	private String nautm;
	private String naute;
	private String astm;
	private String aste;

	public SunDaily(SunDailyResponse.Item item) {
		this.locdate = item.getLocdate();
		this.location = item.getLocation();
		this.longitude = item.getLongitude();
		this.longitudeNum = item.getLongitudeNum();
		this.latitude = item.getLatitude();
		this.latitudeNum = item.getLatitudeNum();
		this.sunrise = item.getSunrise();
		this.suntransit = item.getSuntransit();
		this.sunset = item.getSunset();
		this.moonrise = item.getMoonrise();
		this.moontransit = item.getMoontransit();
		this.moonset = item.getMoonset();
		this.civilm = item.getCivilm();
		this.civile = item.getCivile();
		this.nautm = item.getNautm();
		this.naute = item.getNaute();
		this.astm = item.getAstm();
		this.aste = item.getAste();
	}
}

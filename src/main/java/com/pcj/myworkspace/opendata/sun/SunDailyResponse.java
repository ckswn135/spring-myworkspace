package com.pcj.myworkspace.opendata.sun;

import java.util.List;

import lombok.Data;

@Data
public class SunDailyResponse {
	private Response response;

	@Data
	public class Response {
		private Body body;
	}

	@Data
	public class Body {
		private Items items;
	}

	@Data
	public class Items {
		private List<Item> item;
	}

	@Data
	public class Item {
		private String locdate;
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
	}
}

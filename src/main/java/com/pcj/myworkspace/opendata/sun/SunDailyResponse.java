package com.pcj.myworkspace.opendata.sun;

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
		private Item item;
	}

	@Data
	public class Item {
		private String locdate;
		private String location;

		private String sunrise;
		private String sunset;
		private String moonrise;
		private String moonset;
	}
}

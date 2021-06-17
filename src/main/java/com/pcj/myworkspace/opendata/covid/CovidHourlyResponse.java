package com.pcj.myworkspace.opendata.covid;

import java.util.List;

import lombok.Data;

@Data
public class CovidHourlyResponse {
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

		private String stateDt;
		private String stateTime;

		private String decideCnt;
		private String clearCnt;
		private String examCnt;
		private String deathCnt;
		private String careCnt;
		private String resutlNegCnt;
		private String accExamCnt;
		private String accExamCompCnt;
		private String accDefRate;
		private String createDt;
		private String updateDt;
	}

}

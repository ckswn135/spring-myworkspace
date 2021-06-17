package com.pcj.myworkspace.opendata.covid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@IdClass(CovidHourlyId.class)
public class CovidHourly {

	@Id
	@Column(columnDefinition = "CHAR(8)")
	private String stateDt;
	@Id
	@Column(columnDefinition = "CHAR(6)")
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

	public CovidHourly(CovidHourlyResponse.Item item) {

		this.stateDt = item.getStateDt();
		this.stateTime = item.getStateTime();
		this.decideCnt = item.getDecideCnt();
		this.clearCnt = item.getClearCnt();
		this.examCnt = item.getExamCnt();
		this.deathCnt = item.getDeathCnt();
		this.careCnt = item.getCareCnt();
		this.resutlNegCnt = item.getResutlNegCnt();
		this.accExamCnt = item.getAccExamCnt();
		this.accExamCompCnt = item.getAccExamCompCnt();
		this.accDefRate = item.getAccDefRate();
		this.createDt = item.getCreateDt();
		this.updateDt = item.getUpdateDt();

	}

}

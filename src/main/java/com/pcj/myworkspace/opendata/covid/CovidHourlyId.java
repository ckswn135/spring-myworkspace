package com.pcj.myworkspace.opendata.covid;

import java.io.Serializable;

import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CovidHourlyId.class)
public class CovidHourlyId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7414612998756427385L;
	private String stateDt;
	private String stateTime;

}

package com.pcj.myworkspace.opendata.sun;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SunDailyId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4867030583894689011L;
	private String locdate;
	private String location;

}

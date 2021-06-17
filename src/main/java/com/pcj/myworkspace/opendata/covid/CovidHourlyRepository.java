package com.pcj.myworkspace.opendata.covid;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidHourlyRepository extends JpaRepository<CovidHourly, CovidHourlyId> {

}

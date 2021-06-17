package com.pcj.myworkspace.opendata.covid;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CovidHourlyService {
	CovidHourlyRepository repo;

	@Autowired
	public CovidHourlyService(CovidHourlyRepository repo) {
		this.repo = repo;
	}

	@Scheduled(cron = "0 0 0 1 * *")
	public void getCovidHourlyData() throws IOException {
		String serviceKey = "qklD6o8bjQAtb2TTSJsXPqdwGVXBZUO2qedHkI6qieXUey97W7Lvjp3oguxcUBn9c59qgZ%2B5vWIkcO0eJELVZA%3D%3D";

		StringBuilder builder = new StringBuilder();
		builder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19");
		builder.append("/getCovid19InfStateJson");
		builder.append("?serviceKey=" + serviceKey);
		builder.append("&pageNo=1");
		builder.append("&numOfRows=24");
		builder.append("&startCreateDt=20210601");

		System.out.println(builder.toString());

		URL url = new URL(builder.toString());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		byte[] result = con.getInputStream().readAllBytes();

		String data = new String(result, "UTF-8");
		System.out.println(data);

		JSONObject jObject = XML.toJSONObject(data);

		CovidHourlyResponse response = new Gson().fromJson(jObject.toString(), CovidHourlyResponse.class);

		for (CovidHourlyResponse.Item item : response.getResponse().getBody().getItems().getItem()) {
			repo.save(new CovidHourly(item));
		}

	}
}

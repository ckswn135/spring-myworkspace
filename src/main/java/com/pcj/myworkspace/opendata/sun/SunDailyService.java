package com.pcj.myworkspace.opendata.sun;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class SunDailyService {

	SunDailyRepository repo;

	@Autowired
	public SunDailyService(SunDailyRepository repo) {
		this.repo = repo;
	}

	@SuppressWarnings("deprecation")
//	@Scheduled(fixedRate = 1000 * 60 * 30)
	@Scheduled(cron = "0 0 0/1 * * *")
	public void requestSunDailyData() throws IOException {
		System.out.println(new Date().toLocaleString() + "--실행--");
		getSunDailyData(URLEncoder.encode("서울", "UTF-8"));
		getSunDailyData(URLEncoder.encode("부산", "UTF-8"));
		getSunDailyData(URLEncoder.encode("인천", "UTF-8"));
		getSunDailyData(URLEncoder.encode("대구", "UTF-8"));
		getSunDailyData(URLEncoder.encode("대전", "UTF-8"));
		getSunDailyData(URLEncoder.encode("광주", "UTF-8"));
		getSunDailyData(URLEncoder.encode("울산", "UTF-8"));
		getSunDailyData(URLEncoder.encode("제주", "UTF-8"));
		getSunDailyData(URLEncoder.encode("동해", "UTF-8"));
		getSunDailyData(URLEncoder.encode("경주", "UTF-8"));
		getSunDailyData(URLEncoder.encode("강릉", "UTF-8"));
		getSunDailyData(URLEncoder.encode("포항", "UTF-8"));
		getSunDailyData(URLEncoder.encode("울산", "UTF-8"));
		getSunDailyData(URLEncoder.encode("여수", "UTF-8"));
	}

	private void getSunDailyData(String location) throws IOException {
		Date nowDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.add(Calendar.DATE, +7);
		String timeNow = simpleDateFormat.format(cal.getTime());

		String serviceKey = "qklD6o8bjQAtb2TTSJsXPqdwGVXBZUO2qedHkI6qieXUey97W7Lvjp3oguxcUBn9c59qgZ%2B5vWIkcO0eJELVZA%3D%3D";

		StringBuilder builder = new StringBuilder();
		builder.append("http://apis.data.go.kr/B090041/openapi/service/RiseSetInfoService");
		builder.append("/getAreaRiseSetInfo");
		builder.append("?serviceKey=" + serviceKey);
		builder.append("&locdate=" + timeNow);
		builder.append("&location=" + location);

		System.out.println(builder.toString());

		URL url = new URL(builder.toString());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		byte[] result = con.getInputStream().readAllBytes();

		String data = new String(result, "UTF-8");

		JSONObject jObject = XML.toJSONObject(data);
		System.out.println(jObject.toString());

		SunDailyResponse response = new Gson().fromJson(jObject.toString(), SunDailyResponse.class);
		System.out.println(response);

		SunDailyResponse.Item item = response.getResponse().getBody().getItems().getItem();
		repo.save(new SunDaily(item));
	}
}

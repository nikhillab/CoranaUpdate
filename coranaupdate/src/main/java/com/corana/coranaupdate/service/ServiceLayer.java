package com.corana.coranaupdate.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.corana.coranaupdate.dao.Data;

@Service
public class ServiceLayer {

	@Autowired
	private Data data;

	@Value(value = "${VIRUS_DATA_URL}")
	private String VIRUS_DATA_URL;

	private List<String[]> latestData = null;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<String[]> MyGETRequest() throws IOException {

		URL urlForGetRequest = new URL(VIRUS_DATA_URL);

		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();

		conection.setRequestMethod("GET");

		// conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample

		int responseCode = conection.getResponseCode();

		String responseMessage = conection.getResponseMessage();

		System.out.println(responseMessage);

		if (responseCode == HttpURLConnection.HTTP_OK) {
			if (latestData==null) {
				setDataValue(conection);
			} else {
				latestData.clear();
				setDataValue(conection);
			}

		} else {
			System.out.println("GET NOT WORKED");
		}

		return latestData;
	}

	private void setDataValue(HttpURLConnection conection) {
		List<String[]> latestDataNow = data.getData(conection);
		latestData = latestDataNow;
	}

	public long lengthOfData() {
		LocalDate dateBefore = LocalDate.of(2020, Month.JANUARY, 22);

		Date date = new Date();
		String format = simpleDateFormat.format(date);
		LocalDate dateAfter = LocalDate.parse(format);

		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		System.out.println(noOfDaysBetween);
		return noOfDaysBetween;
	}
}

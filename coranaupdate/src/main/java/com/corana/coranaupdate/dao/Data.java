package com.corana.coranaupdate.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Data {
	
	private List<String[]> result = new ArrayList<String[]>();

	
	public List<String[]> getData(HttpURLConnection conection) {
		String readLine = null;


		try (BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));){

			StringBuffer response = new StringBuffer();

			while ((readLine = in.readLine()) != null) {
					String[] split = readLine.split(",");
					result.add(split);
//					response.append(readLine);
//					response.append('\n');
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
//		    print result
//		    System.out.println("JSON String Result " + response.toString());
//			Path pathFileToWrite = Paths.get("./data.txt");
//
//			List<String> list = Arrays.asList("Apple", "Boy", "Cat", "Dog", "Elephant");
//
//			Files.write(pathFileToWrite, response.toString().getBytes());
// 			GetAndPost.POSTRequest(response.toString());
//		for (String[] strings : result) {
//			for (String strings2 : strings) {
//				System.out.print(strings2 + " ");
//			}
//			System.out.println();
//		}
		
		return result;
	}

}

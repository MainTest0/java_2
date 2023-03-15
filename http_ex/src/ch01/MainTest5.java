package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest5 {

	public static void main(String[] args) {

//		문제  1
//		https://jsonplaceholder.typicode.com/users 한사람만 가져오기
		// addr빼고 company 빼고
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			Gson gson = new Gson();
			
			Type listType = new TypeToken<List<User>>() {}.getType();
			
			String line = null;
			StringBuffer sb = new StringBuffer();
			while( (line = reader.readLine()) != null ) {
				sb.append(line);
			}
			String str = sb.toString();
			
			//ArrayList<User> todoList =  gson.fromJson(str, listType);
			
			System.out.println(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of main

}// end of class

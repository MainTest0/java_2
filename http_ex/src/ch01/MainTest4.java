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

public class MainTest4 {

	public static void main(String[] args) {
		
		// 데이터 통으로 받는 방법 알아보기
		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/todos");
			// 다운 캐스팅
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			// 좀더 많은 긴 문자열을 던져주는 녀석의 데이터 받기
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			// Gson 라이브러리 일단 올려보기
			Gson gson = new Gson();
			
			// 실행될 때 데이터타입을 만들어주는 기법 - 리플렉션 기법(리플렉트.java)
			// TypeToken은 Gson라이브러리안에 있음
			// List는 ArrayList타입중에 제일 상위 객체
			// ArraaList 안에 Object를 파싱하기 위해서 데이터타입 선언 -> ArrayList<Object>
			Type listType = new TypeToken<List<Todo>>() {}.getType();
			
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.toString();
			
			// 엄청 긴 문자열이 여기 들어감
			ArrayList<Todo> todoList = gson.fromJson(result, listType);
			
			// for each문
			for (Todo todo : todoList) {
				System.out.println(todo);
			}
			
			// 데이터 타입 선언할 때 int 랑 int 배열이랑은 완전히 다른녀석
			// todo라는 클래스 하나가 ArrayList안에 Todo라는 object가 들어있다.
			//	ArrayList<Todo>todoList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}// end of main

}// end of class

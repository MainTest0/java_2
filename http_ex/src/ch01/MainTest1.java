package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest1 {

	public static void main(String[] args) {

		// Client가 sever(웹서버)로 요청을 보낼거고 
		// 웹서버는 데이터베이스에 접속해서 확인하고 클라이언트까지
		// 다시 던져줌
		// 데이터베이스에서 쿼리문 읽고 결과집합을 클라이언트한테 보냄
		
		// 기본 자바 표준 기술(HTTP) 클래스를 이용하여
		// http통신을 통해서 데이터를 요청하고 응답받아보는
		// 기술을 확인해본다.
		
		// http통신은 소켓통신 기반으로 만들어져 있다.
		// 차이점
		// 소켓통신은 연결이 지속되어있다
		// 소켓통신을 만들기위해 클라이언트, 서버, 연결담당소켓
		//	 커넥션리스 - 요청받고 응답하고 끊어지고 (http통신)
		
		// https://jsonplaceholder.typicode.com/todos
		// http 통신 준비물
		// url 클래스
		// httpURLConnection 클래스 필요
		try {
//			URL url = new URL("https://jsonplaceholder.typicode.com/todos");
//			URL url = new URL("https://www.naver.com");
			
			// 하나의 데이터만 출력
			// 이걸로 todo클래스 만들어서 ArrayList로 모델링하기
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/2");
			// 다운캐스팅
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.connect();
			
			int statusCode = conn.getResponseCode();
			System.out.println(statusCode);
			// 데이터 읽어보기
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
//			System.out.println(reader.read());
//			System.out.println(reader.read());
//			System.out.println(reader.read());
//			System.out.println(reader.read());
//			System.out.println(reader.read());
			
//			String line = reader.readLine();
//			line = line + reader.readLine();
			
			StringBuffer sb = new StringBuffer();
			String line = null;
			
			// readLine했을 때 null을 만나면 더이상 읽을 데이터가 없어
			// null이 아닐동안 반복
			while( ( line = reader.readLine() ) != null) {
				// 한줄 읽으면 \n
				sb.append(line + "\n");		//null이 나올 때 까지 계속 더하기
			}
			//StringBuffer 타입을 String 타입으로 변환
			String resultStr = sb.toString();
			System.out.println(resultStr);
			
			// title값만 반환하기
//			System.out.println(resultStr.substring(30, 79));
			System.out.println(resultStr.split("title"));
			
			// Gson 라이브러리 가져오고 설정하는 방법 -> 기억하기
			// Gson에 많은 클래스들이있는데
			// Gson의 대표적인 사용법 및 개념 확인하기
			Gson gson = new Gson();
			Todo todo = new Todo();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// end of main

}// end of class

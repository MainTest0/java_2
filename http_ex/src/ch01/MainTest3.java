package ch01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainTest3 {

	public static void main(String[] args) {

		// 문제 
		// https://jsonplaceholder.typicode.com/posts/19 클래스로 모델링, 파싱해보기

		// URL
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/19");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.connect();
			
			// StringCode		I/O
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			while( (line = reader.readLine()) != null) {
				sb.append(sb);
			}
			String str = sb.toString();
			
			// POST	<- 단 ch01 패키지에서 만들기
			System.out.println(str);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// 값을 담았다면 콘솔창에 출력까지 연습하기
		
		
	}// end of main
}// end of class

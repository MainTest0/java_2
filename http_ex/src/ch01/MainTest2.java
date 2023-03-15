package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest2 {

	public static void main(String[] args) {

		// 데이터 긁기
		// http 통신하기위해 필요한 준비물
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/50");
			// url 클래스에서 connection 꺼낼수있음
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// http 요청할 때 2가지 방식
			// 1. GET 방식
			// 2. POST 방식
			// get 방식으로 던질거야
			conn.setRequestMethod("GET");
			// 브라우저에 주소치고 엔터누르는거랑 같음
			// 요청했다가 응답을 받게됩니다.
			conn.connect();
			// 접속 성공했는지(결과 : 200) 볼려고 int 변수에 담음
			int statusCode = conn.getResponseCode();
			System.out.println("statusCode : " + statusCode);
			// 200은 통신성공, 404는 요청url이 없다.(잘못된 요청이다.)
			
			// 방어적코드
			if(statusCode == 200) {
				System.out.println("통신성공");
				// connect 하게되면 conn httpurlconnection에 stream이 연결됨
				// 데이터를 받기위해서는 inputstream이 먼저 필요함
//				conn.getInputStream();
				
				// 한바이트씩 처리하는 녀석을 2바이트로 확장할거임
				// 기반 스트림 + 보조 스트림 -> 데코레이션 패턴이라고 한다.
				// 상속은 밑에서 위로 바텀업방식
				// 얘들은 기반 + 보조 + 보조 옆으로 가는 방식
//				new InputStreamReader(conn.getInputStream());
				
				// 한번에 많이 담을 수 있게 기능확장하기
				// 데코레이션 패턴으로 기능확장
//				new BufferedReader(new InputStreamReader(conn.getInputStream()));
				BufferedReader reader =  new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				String line = reader.readLine();
				//----------------null 쓰는 이유 물어보기
				// null 쓰는 이유 : reader.readLine이 '{' 하나 먹고 while 문에 들어가서
				// null 써서 못먹게 함
				String line = null;
				
				// 읽어들여야할 데이터가 여러줄에 걸치니까 반복해야함
				// 몇번 반복해야할지 모름
				
				StringBuffer sb = new StringBuffer();
				while( (line = reader.readLine()) != null ) {
					//stringbuffer에 문자열 더하는 방법
					sb.append(line + "\n");
				}
				String str = sb.toString();
				// 확인해보기
//				System.out.println(sb.toString());
				
				// Json Parsing 써보기 -> 문자열 -> Java Object로 변환
				// 파싱해주는 기능은 Gson
				Gson gson = new Gson();
				// 쓰는 방법은 gson 객체안에 기능이 만들어져있음
				// json에서부터 파싱해줄 문자열을 넣어주면됨
				// 위에 변수로 받아놓음
				// 2번째는 어떤 클래스로 변환할지 알려줘야함
//				gson.fromJson(sb.toString(),  null);
				
				// 모델링해야하는데 todo클래스로 모델링 해놓았음
				// todo는 실행시킬 때 만들어라 (동적)
				// 런타임시점 때 바꾸는거
				Todo todo = gson.fromJson(str, Todo.class);
				
				// 파싱 잘됬는지 확인하기
				System.out.println("id : " + todo.getId());
				System.out.println("userId : " + todo.getUserId());
				System.out.println("title : " + todo.getTitle());
				System.out.println("completed : " + todo.getIsCompleted());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// end of main

}// end of class

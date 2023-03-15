package ch02;

import com.google.gson.JsonObject;

public class JsonMainTest2 {
	
	public static void main(String[] args) {
		// jsonObject 만드는 방법
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty("name", "티모");
		jsonObject.addProperty("나이", 25);
		jsonObject.addProperty("직업", "CEO");
		jsonObject.addProperty("취미", "노래");
		jsonObject.addProperty("결혼여부", false);
		
		System.out.println(jsonObject);
		
		// jsonObject에서 키 값 꺼내는 방법
		System.out.println(jsonObject.get("name"));
		System.out.println(jsonObject.get("취미"));
		System.out.println(jsonObject.get("나이"));
		System.out.println(jsonObject.get("직업"));
		System.out.println(jsonObject.get("결혼여부"));
		
		JsonObject js = new JsonObject();
		
		//=============================================
		
		js.addProperty("userId", 1);
		js.addProperty("id", 2);
		js.addProperty("title", "quis ut nam facilis et officia qui");
		js.addProperty("completed", false);
		
		System.out.println(js);
		
		System.out.println(js.get("userId"));
		System.out.println(js.get("id"));
		System.out.println(js.get("title"));
		System.out.println(js.get("completed"));
		
		
	}// end of main
}// end of class

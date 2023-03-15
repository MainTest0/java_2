package ch02;

import com.google.gson.JsonObject;

public class JsonMainTest1 {

	public static void main(String[] args) {

		// json 형식의 문자열을 만드는 방법
		// 1. 직접 형식을 지켜서 만들어주기
		String myjson = "{\r\n"
				+ "	\"name\" : \"티모\"\r\n"
				+ "}";
		// 위 형식을 쉽게 만들어 주는 게 jsonObject
		JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("name", "티모");
		System.out.println(jsonObject);
		
	}// end of main

} // end of class

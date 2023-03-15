package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest3 {

	public static void main(String[] args) {

		JsonArray jsonArray = new JsonArray();
		// 위 상태가 [] 찍은 상태
		System.out.println(jsonArray);
		
		// [] 여기에 jsonObject 넣고싶다.
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "티모");
		System.out.println("=====================");
		System.out.println(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		System.out.println("=====================");
		System.out.println(jsonArray);

		JsonArray ja = new JsonArray();
		JsonObject jo1 = new JsonObject();
		JsonObject jo2 = new JsonObject();
		JsonObject jo3 = new JsonObject();
		
		jo1.addProperty("userId", 1);
		jo1.addProperty("id", 1);
		jo1.addProperty("title", "delectus aut autem");
		jo1.addProperty("completed", false);
		
		jo2.addProperty("userId", 1);
		jo2.addProperty("id", 2);
		jo2.addProperty("title", "quis ut nam facilis et officia qui");
		jo2.addProperty("completed", false);
		
		jo3.addProperty("userId", 1);
		jo3.addProperty("id", 3);
		jo3.addProperty("title", "fugiat veniam minus");
		jo3.addProperty("completed", false);
		System.out.println("========================");
		ja.add(jo1);
		ja.add(jo2);
		ja.add(jo3);
		System.out.println(ja+"\n");
		
		// jsonArray에서 jsonObject 꺼내는 방법
//		JsonObject targetObject = jsonArray.get(3).getAsJsonObject();
		// 3번째가 없는데 시켰을 때 에러 -> 런타임 시점 에러(일단 실행되니까)
		// 문법오류는 컴파일 시점 에러
		JsonObject targetObject = jsonArray.get(2).getAsJsonObject();
		System.out.println(targetObject);
		String strName = targetObject.get("name").getAsString();
		System.out.println(strName);
		
	}// end of main

}// end of class

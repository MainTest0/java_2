package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class test {

	public static void main(String[] args) {

		JsonArray ja1 = new JsonArray();
		JsonArray ja2 = new JsonArray();
		JsonArray ja3 = new JsonArray();
		JsonObject jo1 = new JsonObject();
		JsonObject jo2 = new JsonObject();
		JsonObject jo3 = new JsonObject();

		jo1.addProperty("name", "홍길동");
		jo1.addProperty("age", 20);
		jo1.addProperty("address", "부산");

		jo2.addProperty("name", "이순신");
		jo2.addProperty("age", 33);
		jo2.addProperty("address", "서울");

		jo3.addProperty("name", "세종대왕");
		jo3.addProperty("age", 59);
		jo3.addProperty("address", "세종시");

		ja1.add(jo1);
		ja1.add(jo2);
		ja1.add(jo3);

		System.out.println(ja1);

		System.out.println("=======================");

		JsonObject joex2 = new JsonObject();
		JsonArray jaex2_1 = new JsonArray();
		JsonObject joex2_1 = new JsonObject();
		JsonObject joex2_2 = new JsonObject();

		jaex2_1.add(joex2_1);
		jaex2_1.add(joex2_2);

		joex2.add("todoList : ", jaex2_1);
		joex2.add("todoList : ", jaex2_1);

		joex2_1.addProperty("id", 1);
		joex2_1.addProperty("title", "청소");
		joex2_1.addProperty("complete", false);
		joex2_2.addProperty("id", 2);
		joex2_2.addProperty("title", "영어공부");
		joex2_2.addProperty("complete", false);

		System.out.println(joex2);

	} // end of main

} // end of class

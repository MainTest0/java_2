package url_db_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import url_db_test.controller.UrlController;
import url_db_test.dao.UrlDAO;

public class MainTest {
	public static void main(String[] args) {
		 
		UrlDAO dao = new UrlDAO();
//		int result = dao.update(1, 1, "quidem molestiae enim");
//		
//		System.out.println(result);

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
//			int result = conn.getResponseCode();
//			System.out.println(result);

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			Gson gson = new Gson();
			Type listType = new TypeToken<List<UrlDTO>>() {}.getType();

			String line = null;
			StringBuffer sb = new StringBuffer();

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.toString();
			// 한개만 파싱
//			System.out.println(result);
			
			UrlController con = new UrlController();
			
//			UrlDTO dto = gson.fromJson(result, UrlDTO.class);
//			ArrayList<UrlDTO> arr;
//			con.save(dto.getUserId(), dto.getId(), dto.getTitle());
			
			// 전체 파싱 url 고쳐야함
			ArrayList<UrlDTO> dtoList = gson.fromJson(result, listType);
			
			for (UrlDTO urlDTO : dtoList) {
				System.out.println(urlDTO);
				String a = con.save(urlDTO.getUserId(), urlDTO.getId(), urlDTO.getTitle());
				System.out.println(a);
			}

		} catch (Exception e) {
			System.out.println("main 오류");
			e.printStackTrace();
		}
		
	}// end of main

}

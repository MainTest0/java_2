package individualProject.parsing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import individualProject.UserDTO;

public class Parsing {

	private URL url;
	

	public Parsing() {
		try {
			url = new URL("https://jsonplaceholder.typicode.com/posts");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.getRequestMethod();
			conn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			Gson gson = new Gson();
			Type listType = new TypeToken<List<UserDTO>>() {}.getType();
			
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			while( (line = reader.readLine()) != null ) {
				sb.append(line);
			}
			String result = sb.toString();
			
			ArrayList<UserDTO> dtoList = gson.fromJson(result, listType);
			
			for (UserDTO userDTO : dtoList) {
				System.out.println(userDTO);
			}
			

		} catch (Exception e) {
			System.out.println("Parsing에서 오류");
			e.printStackTrace();
		}
	}

}

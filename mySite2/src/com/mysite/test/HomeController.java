package com.mysite.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController  {
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	   public ModelAndView student() throws IOException {
		   ModelAndView model = new ModelAndView("home");
				
				String url="https://24uvpa476j.execute-api.us-east-1.amazonaws.com/default/readDB";
				try 
				{
		
					InputStream is = new URL(url).openStream();
					
					String jsonString = readInputStream(is);

					ObjectMapper mapper = new ObjectMapper();
					
					System.out.println(jsonString);
					System.out.println(jsonString);
					
					List<Map<String, Object>> myObjects = 
					          mapper.readValue(jsonString , new TypeReference<List<Map<String, Object>>>(){});
					
					
					model.addObject("personList",myObjects);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	

			return model;
	   }

	
	 	public static String readInputStream(InputStream in) throws IOException, JSONException {
		    
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
		      
		      StringBuilder jsonString = new StringBuilder();
		      int cp;
		      while ((cp = rd.read()) != -1) {
			      jsonString.append((char) cp);
			    }
		      System.out.println("results===" + jsonString.toString());
		    return jsonString.toString();
		      
		    } finally {
		      in.close();
		    }
		  }
	 	
}
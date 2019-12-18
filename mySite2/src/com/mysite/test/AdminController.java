package com.mysite.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AdminController {
	
	
   @RequestMapping(value = "/admin", method = RequestMethod.GET)
   public ModelAndView student() {
	   
	   ModelAndView mav = new ModelAndView("admin");
	   
      return mav;
	   
   }
   
   @RequestMapping(value = "/admin", method = RequestMethod.POST)
   
      public String addStudent(HttpServletRequest request) throws Exception {
	   
	   Map<String, String[]> parameterMap = request.getParameterMap();

	  
	  ObjectMapper mapper = new ObjectMapper();
	  String jsonInString = mapper.writeValueAsString(parameterMap);
	  
	  
//	  System.out.println("jsonInString == " + jsonInString);
	  
	   String url="https://739jwy3n0c.execute-api.us-east-1.amazonaws.com/default/insertDB";
	   
		try 
		{
			String status = insertJsonFromUrl(url,jsonInString);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		return "redirect:/";
   }
   

   
   public static String insertJsonFromUrl(String url,String jsonInString) throws IOException, JSONException {
	  
	   try{
	        
	   String  postUrl= url;// put in your url
	   HttpClient httpClient = HttpClientBuilder.create().build();
	   HttpPost post = new HttpPost(postUrl);
	   StringEntity postingString = new StringEntity(jsonInString);//gson.tojson() converts your pojo to json
	   post.setEntity(postingString);
	   post.setHeader("Content-type", "application/json");
	   HttpResponse  response = httpClient.execute(post);
	   
	   /*Checking response */
       if (response != null) {
           InputStream in = response.getEntity().getContent(); //Get the data in the entity
           String jsonString = readInputStream(in);
   	       
   	      return jsonString;
    
       }
	   } catch (Exception e) {
    	   
       }
	   
	   return "";
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
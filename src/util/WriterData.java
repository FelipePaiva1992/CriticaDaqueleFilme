package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class WriterData {

	public static void writeJsonArray(JSONArray data, HttpServletResponse response){
	 	PrintWriter out;
		try {
			out = response.getWriter();
		 	response.setContentType("application/json");
	        response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
	        out.print(data);
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeJsonObject(JSONObject data, HttpServletResponse response){
	 	PrintWriter out;
		try {
			out = response.getWriter();
		 	response.setContentType("application/json");
	        response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
	        out.print(data);
	        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void writeStrings(String data,HttpServletResponse response){
		PrintWriter out;
		try {
			out = response.getWriter();
	        out.print(data);
	        out.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

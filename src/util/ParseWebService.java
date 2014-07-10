/**
 * @author fpaiva
 */


package util;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseWebService {
	
	
	/**
	 * Recebe o json em string para pegar apenas os valores pertinentes a sua aplicação
	 * @param stringJson com um JSon em formato String
	 * @return JSONObject com os valores adicionados a ele
	 */
	public JSONArray parseJson(String stringJson) {
			
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		            	   
		try {
			jsonObject = new JSONObject(stringJson);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int totalResultados = 0;
		try {
			totalResultados = Integer.parseInt(jsonObject.getString("total"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(totalResultados != 0){
			for(int i = 0; i < totalResultados; i++){
				JSONObject object = new JSONObject();
				try {
					object.put("nmFilme", jsonObject.getJSONArray("movies").getJSONObject(i).get("title").toString());
					object.put("anoFilme", jsonObject.getJSONArray("movies").getJSONObject(i).get("year").toString());
					object.put("critFilmeCriticos", jsonObject.getJSONArray("movies").getJSONObject(i).getJSONObject("ratings").get("critics_score").toString());
					object.put("critFilmePublico", jsonObject.getJSONArray("movies").getJSONObject(i).getJSONObject("ratings").get("audience_score").toString());
					object.put("posterLink", jsonObject.getJSONArray("movies").getJSONObject(i).getJSONObject("posters").get("detailed").toString());
				} catch (JSONException e) {
					break;
				}
				
				jsonArray.put(object);
			}
		}    
			
		return jsonArray;
	
	}
    
    

}

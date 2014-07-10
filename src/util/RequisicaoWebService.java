/**
 * @author fpaiva
 */

package util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Properties;

import org.json.JSONArray;




public class RequisicaoWebService {

	/**
	 * Metodo recebe os valores da Servlet o converte em uma url e executa o webService
	 * @param origem, destino parametros vão variar dependendo da aplicação
	 * @return JSONObject da classe ParseWebService
	 * @throws IOException
	 */
	public JSONArray request(String nomeFilme) throws IOException{
		
		//Cria a url passando os parametros do web service
		String url = this.criaUrl(nomeFilme);

		//Chama o metodo passando a url que você pegou no metodo anterior
		//Ele retorna o json em formato String
		String jsonString = this.chamarWebService(url);
		
		//instancia o ParseWebService
		ParseWebService parse = new ParseWebService();
		
		//O retorno varia de acordo com o uso, por exemplo se o webService retorna varios resultado, você comoca em um JsonArray, ou em um Array.
		//no caso só existe um retorno, então vai retornar um unico objeto json.
		//Chama o metodo pasando o retorno do metodo anterior, que é o json em formato String
		JSONArray jsonArray = parse.parseJson(jsonString);
		
		return jsonArray;
	}

	
	/**
	 * Metodo recebe os parametros do metodo request e os converte em uma url do webService pre definido
	 * @param origem, destino  parametros vão variar dependendo da aplicação
	 * @return String contendo a url do webService já com os parametros
	 * @throws UnsupportedEncodingException
	 */
	public String criaUrl(String nomeFilme) throws UnsupportedEncodingException {
		
		// a string da url (O basico sem os parametros)
		String urlString = "http://api.rottentomatoes.com/api/public/v1.0/movies.json";
	
		
		
		// os parametros a serem adicionados (varia de acordo com o webservice que você esta usando)
		Properties parametrosDirecoes = new Properties();
		//O "URLEncoder.encode" pega a sua string e arruma os seus espaços( porque no navegador o espaco é " %20 " ) 
		parametrosDirecoes.setProperty("apikey", "kuce8w8u8tc2729deza3ds8x");
		parametrosDirecoes.setProperty("q",URLEncoder.encode(nomeFilme, "UTF-8"));

		// o iterador, para criar a URL
		Iterator<?> i = parametrosDirecoes.keySet().iterator();
		// o contador
		int counter = 0;

		// enquanto ainda existir parametros
		while (i.hasNext()) {

			// pega o name
			String name = (String) i.next();
			// pega o value
			String value = parametrosDirecoes.getProperty(name);

			// adiciona com um conector (? ou &)
			// o primeiro é ?, depois são &
			urlString += (++counter == 1 ? "?" : "&")
				+ name
				+ "="
				+ value;

		}
		
		return urlString;

	}
	
	
	/**
	 * Metodo recebe uma url e a executa, retornando um json em formato string
	 * @param urlString
	 * @return String contendo um json formato string
	 * @throws IOException
	 */
	public String chamarWebService (String urlString) throws IOException{
		
	URL url = new URL(urlString);

	//Cria uma conexaõ com a url
	HttpURLConnection connection =  (HttpURLConnection) url.openConnection(); 
	
	//Seta os paramentros de quando se chama o metodo (idioma, formato) Isso você encontra na documentaçaõ do HTTP  
	connection.setRequestProperty("Accept", "application/json");
	connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
	connection.setRequestProperty("Accept-Language", "pt-BR");
	connection.setRequestMethod("GET");
	
	// seta a variavel para ler o resultado  
	connection.setDoInput(true);  
	connection.setDoOutput(true);  
	
	// conecta com a url destino  
	try {
		connection.setRequestProperty("User-Agent", "Chrome/27.0.1453.110");
		connection.connect();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
			//abre a conexão pra input  
			BufferedReader br =  
			    new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			// le ate o final  
			StringBuffer newData = new StringBuffer(10000);  
			String s = "";  
			while (null != ((s = br.readLine()))) {  
			    newData.append(s);  
			}  
			br.close(); 
			return new String(newData);
	 
	}

}

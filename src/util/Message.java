package util;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Message {

	private ArrayList<String> fieldsInvalidMessages;
	private ArrayList<String> sucessMessages;
	
	private int totalErrors = 0;
	
	public Message(){
		this.fieldsInvalidMessages = new ArrayList<String>();
		this.sucessMessages = new ArrayList<String>();
	}
	
	//VERIFICA SE NENHUMA MENSAGEM DE ERRO FOI INCLUIDA
	public boolean allValid(){
	
		if(this.fieldsInvalidMessages.size() > 0){
			return false;
		}
		else{
			return true;
		}
	}

	//ADICIONA MENSAGEM DE ERRO E A ORIGEM DO ERRO
	public void addErrorMessage(String nmField, String message){
		nmField = nmField.trim();
		message = message.trim();
		
		this.fieldsInvalidMessages.add(nmField+" "+message+"\n");
		
		totalErrors++;
	}
	
	
	//ADICIONA MENSAGEM DE SUCESSO
	public void addSucessMessage(String message){
		message = message.trim();
		sucessMessages.add(message+"\n");
	}	
	
	//RETORNA MENSAGEM GERADA EM FORMATO STRING
	public String getGenerateMessageString(){
		
		StringBuilder messageContent = new StringBuilder();
		
		for(String field : this.fieldsInvalidMessages){
			messageContent.append(field.toString());
		}
		
		for(String sucess : this.sucessMessages){
			messageContent.append(sucess.toString());
		}

		return messageContent.toString();

	}	
	
	//RETORNA MENSAGEM GERADA EM FORMATO JSON (DEVE PASSAR A KEY PARA O OBJETO JSON)
	public JSONObject getGenerateMessageJSONObj(String msgKey, String totalErrorsKey){
		
		JSONObject jobj = new JSONObject();
		
		StringBuilder messageContent = new StringBuilder();
		
		for(String field : this.fieldsInvalidMessages){
			messageContent.append(field.toString());
		}
		
		for(String sucess : this.sucessMessages){
			messageContent.append(sucess.toString());
		}

		
		try {
			jobj.put(msgKey, messageContent.toString());
			jobj.put(totalErrorsKey, totalErrors);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jobj;
	}

	public int getTotalErrors() {
		return totalErrors;
	}	
	
	
}

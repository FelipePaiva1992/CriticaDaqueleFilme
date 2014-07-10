package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import util.GenericController;
import util.RequisicaoWebService;

public class ListarFlmesPorNome extends GenericController{

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
		
		String nomeFilme = request.getParameter("nomeFilme");
		RequisicaoWebService requisicaoWebService = new RequisicaoWebService();
		JSONArray jsonArray = null;
		try {
			jsonArray = requisicaoWebService.request(nomeFilme);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}


	
}

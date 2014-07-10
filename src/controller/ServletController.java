package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import util.WriterData;




@WebServlet("/ServletController")
public class ServletController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	    
	int	 iAcao = 0;
	String sAcao = null;
	
		public ServletController() {super();}
	
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			sAcao = request.getParameter("acao");
			Object data = null;
			
			if(sAcao != null)iAcao = Integer.parseInt(sAcao);
			
			switch (iAcao) {				
			
			case Acoes.LISTAR_FILME_NOME:
				data = new ListarFlmesPorNome().execute(request, response);
				WriterData.writeJsonArray((JSONArray)data, response);
				break;
	
			}
			
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			sAcao = request.getParameter("acao");
//			Object data = null;
//			
//			if(sAcao != null)iAcao = Integer.parseInt(sAcao);
//			
//			switch (iAcao) {
//				case Acoes.LOGIN_USUARIO:
//				data = new AcessoUsuario().execute(request, response);
//				WriterData.writeJsonObject((JSONObject)data, response);
//				break;
//			}
		}
	
}

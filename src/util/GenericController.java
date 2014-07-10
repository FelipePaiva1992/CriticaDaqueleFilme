package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class GenericController {


	
	/**
	 * Metodos  execute(...)
	 * 
	 * 
	 * 
	 * */
	//public Object execute(HttpServletRequest request){return null;}
	
	public abstract Object execute(HttpServletRequest request, HttpServletResponse response);
	
	//public Object execute(){return null;};
}

package com.udodov.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class Calculation
 */
@WebServlet("/Calculation19_23")
public class Calculation19_23 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbUtil dbUtil;
	
	@Resource (name = "jdbc/materials")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			dbUtil = new DbUtil(dataSource);
		}catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		String theCommand = request.getParameter("command");
		
		switch(theCommand) {
		case "SCHEME19":
			scheme19(request, response);
			break;
		case "SCHEME20":
			scheme20(request, response);
			break;
		case "SCHEME21":
			scheme21(request, response);
			break;
		case "SCHEME22":
			scheme22(request, response);
			break;
		case "SCHEME23":
			scheme23(request, response);
			break;
			
		default:
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/index.html");
			dispatcher.forward(request, response);
			
		}
		
	} catch (Exception exc) {
		throw new ServletException(exc);
	}

	}

	private void scheme19(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	       double M = 0; 
	       double d = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme19.jsp");
		try {
		    M  = Double.parseDouble(request.getParameter("moment")); 
	        d = Double.parseDouble(request.getParameter("diameter"));
	        k = Double.parseDouble(request.getParameter("leg"));
	        
	        request.setAttribute("MOMENT", M);
	        request.setAttribute("DIAMETER", d);	        
	        request.setAttribute("LEG", k);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (2.54*M)/(d*k*(Math.sqrt(2.0)*d + k));
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme20(HttpServletRequest request, HttpServletResponse response) throws Exception {

		   double P = 0; 
		   double l = 0;
	       double d = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme20.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
		    l = Double.parseDouble(request.getParameter("length"));
	        d = Double.parseDouble(request.getParameter("diameter"));
	        k = Double.parseDouble(request.getParameter("leg"));
	        
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("DIAMETER", d);	        
	        request.setAttribute("LEG", k);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (2.54*P*l)/(d*k*(Math.sqrt(2.0)*d + k)) + (1.41*P)/(3.14*d*k);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme21(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double M = 0; 
	       double l = 0;
	       double h = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme21.jsp");
		try {
		    M  = Double.parseDouble(request.getParameter("moment")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        h = Double.parseDouble(request.getParameter("width"));
	        k = Double.parseDouble(request.getParameter("leg"));
	        
	        request.setAttribute("MOMENT", M);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("WIDTH", h);
	        request.setAttribute("LEG", k);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (4.24*M)/(l*k*(l+3*h));
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme22(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double l1 = 0;
	       double h = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme22.jsp");
		try {
			P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        l1 = Double.parseDouble(request.getParameter("length1"));
	        h = Double.parseDouble(request.getParameter("width"));
	        k = Double.parseDouble(request.getParameter("leg"));
	        
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LENGTH1", l1);
	        request.setAttribute("WIDTH", h);
	        request.setAttribute("LEG", k);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (4.24*P*l1)/(l*k*(l+3*h)) + (0.707*P)/(k*(l+h));
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme23(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		   double P = 0; 
		   double Q = 0; 
	       double l = 0;
	       double l1 = 0;
	       double b = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme23.jsp");
		try {
			P  = Double.parseDouble(request.getParameter("power1")); 
			Q  = Double.parseDouble(request.getParameter("power2")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        l1 = Double.parseDouble(request.getParameter("length1"));
	        b = Double.parseDouble(request.getParameter("width"));
	        k = Double.parseDouble(request.getParameter("leg"));
	        
	        request.setAttribute("POWER1", P);
	        request.setAttribute("POWER2", Q);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LENGTH1", l1);
	        request.setAttribute("WIDTH", b);
	        request.setAttribute("LEG", k);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
		   double result1 = (Q*(l1+l/2))/(0.7*k*b*(l+b/6)) + P/(0.7*k*(2*l+b));
	       
	       double result2 = Q/(0.7*k*(b+2*l));
	       
	       String electrode = request.getParameter("electrode");
	       
	       Double electrodeStrength = dbUtil.getMaterialStrength(electrode);
	       
	       String margin1 = String.format("%.2f", electrodeStrength / result1);
	       
	       String margin2 = String.format("%.2f", electrodeStrength / result2);
	       
	       request.setAttribute("RESULT1", String.format("%.2f",result1));
	       request.setAttribute("RESULT2", String.format("%.2f",result2));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN1", margin1);
	       request.setAttribute("MARGIN2", margin2);
			
			dispatcher.forward(request, response);
	}

}

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
@WebServlet("/Calculation7_12")
public class Calculation7_12 extends HttpServlet {
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
		case "SCHEME7":
			scheme7(request, response);
			break;
		case "SCHEME8":
			scheme8(request, response);
			break;
		case "SCHEME9":
			scheme9(request, response);
			break;
		case "SCHEME10":
			scheme10(request, response);
			break;
		case "SCHEME11":
			scheme11(request, response);
			break;
		case "SCHEME12":
			scheme12(request, response);
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

	private void scheme7(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double M = 0; 
	       double l = 0;
	       double h = 0;
	       double h1 = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme7.jsp");
		try {
		    M  = Double.parseDouble(request.getParameter("moment")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        h = Double.parseDouble(request.getParameter("width"));
	        h1 = Double.parseDouble(request.getParameter("width1"));
	        request.setAttribute("MOMENT", M);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("WIDTH", h);
	        request.setAttribute("WIDTH1", h1);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (3*h*M)/(l*h1*(3*h*h-6*h*h1+4*h1*h1));
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme8(HttpServletRequest request, HttpServletResponse response) throws Exception {

		   double P = 0; 
	       double l = 0;
	       double h1 = 0;
	       double h2 = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme8.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        h1 = Double.parseDouble(request.getParameter("width1"));
	        h2 = Double.parseDouble(request.getParameter("width2"));
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("WIDTH1", h1);
	        request.setAttribute("WIDTH1", h2);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = P/(l*(h1 + h2));
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme9(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	   	   double M = 0; 
	       double l = 0;
	       double h = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme9.jsp");
		try {
		    M  = Double.parseDouble(request.getParameter("moment")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        h = Double.parseDouble(request.getParameter("width"));
	        request.setAttribute("MOMENT", M);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("WIDTH", h);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (6*M)/(l*h*h);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme10(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme10.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        k = Double.parseDouble(request.getParameter("leg"));
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LEG", k);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (0.707*P)/(l*k);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme11(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double M = 0; 
	       double l = 0;
	       double h = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme11.jsp");
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
	       double result = (1.41*M)/(l*h*k);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme12(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double l1 = 0;
	       double h = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme12.jsp");
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
	       double result = (1.41*P*l1)/(l*h*k) + (0.707*P)/(k*l);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	

}

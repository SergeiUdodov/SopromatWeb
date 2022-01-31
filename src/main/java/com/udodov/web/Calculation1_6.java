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
@WebServlet("/Calculation1_6")
public class Calculation1_6 extends HttpServlet {
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
		case "SCHEME1":
			scheme1(request, response);
			break;
		case "SCHEME2":
			scheme2(request, response);
			break;
		case "SCHEME3":
			scheme3(request, response);
			break;
		case "SCHEME4":
			scheme4(request, response);
			break;
		case "SCHEME5":
			scheme5(request, response);
			break;
		case "SCHEME6":
			scheme6(request, response);
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

	private void scheme1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double h = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme1.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        h = Double.parseDouble(request.getParameter("width"));
	        request.setAttribute("POWER", P);	       
	        request.setAttribute("WIDTH", h);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = P/(2*h);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		   double P = 0; 
	       double l = 0;
	       double k1 = 0;
	       double k2 = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme2.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        k1 = Double.parseDouble(request.getParameter("leg1"));
	        k2 = Double.parseDouble(request.getParameter("leg2"));
	        request.setAttribute("POWER", P);	       
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LEG1", k1);
	        request.setAttribute("LEG2", k2);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (1.41*P)/(l*(k1+k2));
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double k1 = 0;
	       double k2 = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme3.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        k1 = Double.parseDouble(request.getParameter("leg1"));
	        k2 = Double.parseDouble(request.getParameter("leg2"));
	        request.setAttribute("POWER", P);	       
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LEG1", k1);
	        request.setAttribute("LEG2", k2);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (1.41*P)/(l*(k1+k2));
	       
	       String electrode = request.getParameter("electrode");
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme4(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme4.jsp");
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

	private void scheme5(HttpServletRequest request, HttpServletResponse response) throws Exception {
			double M = 0; 
	       double l = 0;
	       double h = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme5.jsp");
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

	private void scheme6(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double h = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme6.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        h = Double.parseDouble(request.getParameter("width"));
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("WIDTH", h);
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = P/(l*h);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	

}

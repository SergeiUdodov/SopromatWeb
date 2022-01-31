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
@WebServlet("/Calculation13_18")
public class Calculation13_18 extends HttpServlet {
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
		case "SCHEME13":
			scheme13(request, response);
			break;
		case "SCHEME14":
			scheme14(request, response);
			break;
		case "SCHEME15":
			scheme15(request, response);
			break;
		case "SCHEME16":
			scheme16(request, response);
			break;
		case "SCHEME17":
			scheme17(request, response);
			break;
		case "SCHEME18":
			scheme18(request, response);
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

	private void scheme13(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double l1 = 0;
	       double h = 0;
	       
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme13.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        l1 = Double.parseDouble(request.getParameter("length1"));
	        h = Double.parseDouble(request.getParameter("width"));
	       
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LENGTH1", l1);
	        request.setAttribute("WIDTH", h);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double resultNorm = (6*P*l1)/(l*h*h);
	       
	       double resultTang = P/(l*h);
	       
	       String electrode = request.getParameter("electrode");
	       
	       Double electrodeStrength = dbUtil.getMaterialStrength(electrode);
	       
	       String marginNorm = String.format("%.2f", electrodeStrength / resultNorm);
	       
	       String marginTang = String.format("%.2f", electrodeStrength / resultTang);
	       
	       
	       request.setAttribute("RESULT_NORM", String.format("%.2f",resultNorm));
	       request.setAttribute("RESULT_TANG", String.format("%.2f",resultTang));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN_NORM", marginNorm);
	       request.setAttribute("MARGIN_TANG", marginTang);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme14(HttpServletRequest request, HttpServletResponse response) throws Exception {

		   double M = 0; 
	       double l = 0;
	       double h = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme14.jsp");
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
	       double result = (6*M)/(l*l*h);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme15(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double M = 0; 
	       double l = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme15.jsp");
		try {
		    M  = Double.parseDouble(request.getParameter("moment")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        k = Double.parseDouble(request.getParameter("leg"));
	        
	        request.setAttribute("MOMENT", M);
	        request.setAttribute("LENGTH", l);	        
	        request.setAttribute("LEG", k);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double result = (4.24*M)/(l*l*k);
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme16(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double l1 = 0;
	       double k = 0;
	       
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme16.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        l1 = Double.parseDouble(request.getParameter("length1"));
	        k = Double.parseDouble(request.getParameter("leg"));
	       
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LENGTH1", l1);
	        request.setAttribute("LEG", k);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double resultTang1 = (4.24*P*l1)/(l*l*k);
	       
	       double resultTang2 = (0.707*P)/(l*k);
	       
	       String electrode = request.getParameter("electrode");
	       
	       Double electrodeStrength = dbUtil.getMaterialStrength(electrode);
	       
	       String marginTang1 = String.format("%.2f", electrodeStrength / resultTang1);
	       
	       String marginTang2 = String.format("%.2f", electrodeStrength / resultTang2);
	       
	       
	       request.setAttribute("RESULT_TANG1", String.format("%.2f",resultTang1));
	       request.setAttribute("RESULT_TANG2", String.format("%.2f",resultTang2));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN_TANG1", marginTang1);
	       request.setAttribute("MARGIN_TANG2", marginTang2);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme17(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double P = 0; 
	       double l = 0;
	       double l1 = 0;
	       double h = 0;
	       
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme17.jsp");
		try {
		    P  = Double.parseDouble(request.getParameter("power")); 
	        l = Double.parseDouble(request.getParameter("length"));
	        l1 = Double.parseDouble(request.getParameter("length1"));
	        h = Double.parseDouble(request.getParameter("width"));
	       
	        request.setAttribute("POWER", P);
	        request.setAttribute("LENGTH", l);
	        request.setAttribute("LENGTH1", l1);
	        request.setAttribute("WIDTH", h);
	        
	        
		} catch (NumberFormatException e) {
			
			String message = "Ошибка! Введите числовые значения в поля исходных данных<br>"
					+ "В десятичных дробях используйте " + "\".\"" + " вместо " + "\",\"" + " в качестве разделителя";
			request.setAttribute("MESSAGE", message);
			dispatcher.forward(request, response);
			
		}
	       double resultNorm = (6*P*l1)/(l*l*h);
	       
	       double resultTang = P/(l*h);
	       
	       String electrode = request.getParameter("electrode");
	       
	       Double electrodeStrength = dbUtil.getMaterialStrength(electrode);
	       
	       String marginNorm = String.format("%.2f", electrodeStrength / resultNorm);
	       
	       String marginTang = String.format("%.2f", electrodeStrength / resultTang);
	       
	       
	       request.setAttribute("RESULT_NORM", String.format("%.2f",resultNorm));
	       request.setAttribute("RESULT_TANG", String.format("%.2f",resultTang));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN_NORM", marginNorm);
	       request.setAttribute("MARGIN_TANG", marginTang);
			
			
			dispatcher.forward(request, response);
		
	}

	private void scheme18(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		   double M = 0; 
	       double d = 0;
	       double k = 0;
	       
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/scheme18.jsp");
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
	       double result = (1.27*M)/(d*k*(Math.sqrt(2.0)*d + k));
	       
	       String electrode = request.getParameter("electrode");
	       
	       String margin = String.format("%.2f",dbUtil.getMaterialStrength(electrode) / result);
	       
	       
	       request.setAttribute("RESULT", String.format("%.2f",result));
	       request.setAttribute("ELECTRODE", electrode);
	       request.setAttribute("MARGIN", margin);
			
			
			dispatcher.forward(request, response);
		
	}

}

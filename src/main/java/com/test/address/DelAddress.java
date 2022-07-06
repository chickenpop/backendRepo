package com.test.address;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/address/deladdress.do")
public class DelAddress extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		
		AddressDAO dao = new AddressDAO();
		
		int result = dao.delAddress(seq);
		
		PrintWriter writer = resp.getWriter();
		
		writer.printf("{ \"result\" : \"%d\" }", result);
		
		writer.close();
		
	}

}


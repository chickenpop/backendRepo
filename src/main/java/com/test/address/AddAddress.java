package com.test.address;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/address/addaddress.do")
public class AddAddress extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		AddressDAO dao = new AddressDAO();
		AddressDTO dto = new AddressDTO();
		
		dto.setName(req.getParameter("name"));
		dto.setAge(req.getParameter("age"));
		dto.setGender(req.getParameter("gender"));
		dto.setTel(req.getParameter("tel"));
		dto.setAddress(req.getParameter("address"));
		
		int result = dao.putAddress(dto);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		writer.printf("{ \"result\": \"%d\" }", result);
		
		writer.close();
		
	}

}


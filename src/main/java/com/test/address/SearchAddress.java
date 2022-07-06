package com.test.address;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/address/serachaddress.do")
public class SearchAddress extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String gender = req.getParameter("gender");
		
		AddressDAO dao = new AddressDAO();
		ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
			
		
		if("전체".equals(gender)) {
			list = dao.getAddress();
		} else {
			gender = (gender.equals("남자") ? "m" : "f");
			list = dao.searchAddress(gender);
		}
		
		for (AddressDTO dto : list) {
			dto.setGender(dto.getGender().equals("m") ? "남자" : "여자");
		}
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		String temp = "[";
		
		for (AddressDTO dto : list) {
			temp += "{";
			temp += String.format("\"seq\": %s,", dto.getSeq());
			temp += String.format("\"name\": \"%s\",", dto.getName());
			temp += String.format("\"age\": %s,", dto.getAge());
			temp += String.format("\"gender\": \"%s\",", dto.getGender());
			temp += String.format("\"tel\": \"%s\",", dto.getTel());
			temp += String.format("\"address\": \"%s\"", dto.getAddress());
			temp += "},";
		}
		
		if (list.size() > 0) {
			temp = temp.substring(0, temp.length() - 1);
		}
		
		temp += "]";
		
		System.out.println(temp);
		
		writer.print(temp);
		writer.close();
		
		
	}

}


package com.study.memo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memo/addok.do")
public class Addok extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		DTO dto = new DTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setTitle(title);
		dto.setContent(content);
		
		DAO dao = new DAO();
		int result = dao.add(dto);
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/memo/addok.jsp");

		dispatcher.forward(req, resp);
	}

}

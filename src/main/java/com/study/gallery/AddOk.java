package com.study.gallery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/gallery/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String path = req.getRealPath("images");
		String content = "";
		
		int result = 0; // DB 결과
		int size = 1024 * 1024 * 100; //100MB
		String filename = "";	// 이미지 파일명
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
				  	req, 
				  	path,	
				  	size, 
				  	"UTF-8", 
				  	new DefaultFileRenamePolicy()
			);
			
			filename = multi.getFilesystemName("attach");
			content = multi.getParameter("content");

			System.out.println(filename + " " + content);
			
			DTO dto = new DTO();
			DAO dao = new DAO();
			
			dto.setFilename(filename);
			dto.setContent(content);
			
			// 업로드한 이미지명 > DB 저장
			
			result = dao.add(dto);
			
		} catch(Exception e) {
			System.out.println("gallery addok.jsp");
		}
		
		if (result == 1) {
			
			resp.sendRedirect("/jsppro/gallery/list.do");
			
		} else {
			
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<script>");
			writer.println("alert('failed');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body>");
			writer.println("</html>");
			
			writer.close();			
		}
		
	}

}

package com.study.gallery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.study.memo.DBUtil;

public class DAO {

	Connection conn;
	Statement stat;
	PreparedStatement pstat;
	ResultSet rs;
	
	public DAO() {
		conn = DBUtil.open();
	}

	public int add(DTO dto) {
		
		System.out.println("add dto");
		
		try {
			
			Connection conn = null;
			PreparedStatement pstat = null;
			
			conn = DBUtil.open();
			
			String sql = "INSERT INTO tblGallery (seq, filename, content, regdate) values (GALLERYSEQ.nextval, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getFilename());
			pstat.setString(2, dto.getContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DAO.add");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
}

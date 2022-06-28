package com.study.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {

	private Connection conn;
	private PreparedStatement pstat;
	private Statement stat;
	private ResultSet rs; 

	public DAO() {
		conn = DBUtil.open();
	}

	public int add(DTO dto) {

		try {
			
			System.out.println(dto.getId());
			System.out.println(dto.getPw());
			System.out.println(dto.getTitle());
			System.out.println(dto.getContent());
			
			String sql = "insert into tblMemo(seq, id, pw, title, content, regdate) values(seqMemo.nextVal, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getTitle());
			pstat.setString(4, dto.getContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DAO.add");
			e.printStackTrace();
		}		
		
		return 0;
	}
	
}




















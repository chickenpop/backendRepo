package com.study.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		} finally {
			
			try {
				pstat.close();
				conn.close();
			} catch (Exception e2) {
				System.out.println("DAO.add 자원 해제 중 오류 발생");
			}
			
		}		
		
		return 0;
	}

	public ArrayList<DTO> read() {

		
		try {
			
			String sql = "select * from tblMemo";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<DTO> list = new ArrayList<DTO>();
			
			while(rs.next()) {
				
				DTO dto = new DTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
			
				System.out.println(dto);
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("DAO.read");
			e.printStackTrace();
		} finally {
			
			try {
				
				rs.close();
				stat.close();
				conn.close();
				
			} catch (Exception e2) {
				System.out.println("DAO.read 자원해제 중 오류 발생");
			}
			
		}
		
		
		return null;
	}

	public int del(String seq) {

		try {
			
			String sql = "delete from tblMemo where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DAO.del");
			e.printStackTrace();
		} finally {
			
			try {
				
				pstat.close();
				conn.close();
				
			} catch (Exception e2) {
				System.out.println("DAO.del 자원해제 중 오류 발생");
			}
			
		}
		
		
		return 0;
	}
	
}




















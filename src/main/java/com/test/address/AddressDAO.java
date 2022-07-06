package com.test.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.study.memo.DBUtil;

public class AddressDAO {

	private Connection conn;
	private PreparedStatement pstat;
	private Statement stat;
	private ResultSet rs; 

	public AddressDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<AddressDTO> getAddress() {

		try {
			
			String sql = "SELECT seq, name, age, address, gender, tel FROM tblAddress";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
			
			while(rs.next()) {
				
				AddressDTO dto = new AddressDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
			
				list.add(dto);
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AddressDAO.getAddress");
			e.printStackTrace();
		} 
		
		return null;
	}

	public int putAddress(AddressDTO dto) {

		try {
			
			String sql = "INSERT INTO tblAddress (seq, name, age, address, gender, tel) values (seqAddress.nextVal, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getAddress());
			pstat.setString(4, dto.getGender());
			pstat.setString(5, dto.getTel());
			
			int result = pstat.executeUpdate();
			
			pstat.close();
			conn.close();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("AddressDAO.putAddress");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<AddressDTO> searchAddress(String gender) {

		try {
			
			String sql = String.format("SELECT seq, name, age, address, gender, tel FROM tblAddress WHERE gender = '%s'", gender);
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
			
			while(rs.next()) {
				
				AddressDTO dto = new AddressDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				
				list.add(dto);
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("AddressDAO.searchAddress");
			e.printStackTrace();
		}
		
		return null;
	}

	public int delAddress(String seq) {

		try {
			
			String sql = "DELETE FROM tblAddress WHERE seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AddressDAO.delAddress");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
}

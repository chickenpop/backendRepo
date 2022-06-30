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
	
	
	
}

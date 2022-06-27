package com.study.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// ***** DAO의 업무 메소드는 하나의 업무 메소드에서 하나의 업무만 진행해야한다
public class DAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public DAO() {
		conn = DBUtil.open();
	}
	
}




















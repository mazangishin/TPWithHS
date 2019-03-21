package com.tg.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/board/create")
public class BoardCreate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.sendRedirect("./createForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "TEAMP"; 
		String password = "SORK1EMD";
		
		
		String sql = "";
		  
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			sql = "INSERT INTO BOARD";
			sql += " (NO, TITLE, CONTENT, MNO, CRE_DATE, MOD_DATE)";
			sql += " VALUES(BOARD__NO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE)";
			 
			pstmt = conn.prepareStatement(sql);
			
			int no = 0;
			int mNo = ;
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Date creDate = null;
			Date modDate = null;
			
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, mNo);
			
			rs = pstmt.executeQuery();
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
	
			
			
			
			BoardDto boardDto = null;
			while(rs.next()) {
				no = rs.getInt("NO");
				mNo = rs.getInt("MNO");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				creDate = rs.getDate("CRE_DATE");
				modDate = rs.getDate("MOD_DATE");
			
				boardDto = new BoardDto(no, mNo, title, content, creDate, modDate);
				
				
			}
			
			req.setAttribute("boardDto", boardDto);
			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("./board/readView.jsp");
			RequestDispatcher dispatcher = req.getRequestDispatcher("./list");
			
			dispatcher.forward(req, res);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/error.jsp");
			dispatcher.forward(req, res);
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}
			
			if(pstmt != null) {
				try { 
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

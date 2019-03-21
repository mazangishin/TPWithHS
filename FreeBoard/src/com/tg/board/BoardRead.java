package com.tg.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/board/read")
public class BoardRead extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
			
			sql = "SELECT B.NO, M.EMAIL, B.TITLE, B.CONTENT, B.CRE_DATE, B.MOD_DATE";
			sql += " FROM BOARD B, MEMBER M";
			sql += " WHERE B.MNO = M.MNO";
			sql += " AND NO = ?";
			sql += " ORDER BY NO ASC"; 
			 
			pstmt = conn.prepareStatement(sql);
			
			int no = Integer.parseInt(req.getParameter("no"));
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
	
			
			String writer = "";
			String title = "";
			String content = "";
			Date creDate = null;
			Date modDate = null;
			
			BoardDto boardDto = null;
			while(rs.next()) {
				no = rs.getInt("NO");
				writer = rs.getString("EMAIL");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				creDate = rs.getDate("CRE_DATE");
				modDate = rs.getDate("MOD_DATE");
			
				boardDto = new BoardDto(no, writer, title, content, creDate, modDate);
				
				
			}
			
			req.setAttribute("boardDto", boardDto);
			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("./board/readView.jsp");
			RequestDispatcher dispatcher = req.getRequestDispatcher("./readView.jsp");
			
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
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
}


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
@WebServlet(value="/board/update")
public class BoardUpdate extends HttpServlet{

	
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
			
			sql = "SELECT NO, MNO, TITLE, CONTENT, CRE_DATE, MOD_DATE";
			sql += " FROM BOARD";
			sql += " WHERE NO = ?";
			
			 
			pstmt = conn.prepareStatement(sql);
			
			int no = Integer.parseInt(req.getParameter("no"));
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
	
			
			String mNo = "";
			String title = "";
			String content = "";
			Date creDate = null;
			Date modDate = null;
			
			BoardDto boardDto = null;
			while(rs.next()) {
				no = rs.getInt("NO");
				mNo = rs.getString("MNO");
				title = rs.getString("TITLE");
				content = rs.getString("CONTENT");
				creDate = rs.getDate("CRE_DATE");
				modDate = rs.getDate("MOD_DATE");
			
				boardDto = new BoardDto(no, mNo, title, content, creDate, modDate);
				
				
			}
			
			req.setAttribute("boardDto", boardDto);
			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("./board/readView.jsp");
			RequestDispatcher dispatcher = req.getRequestDispatcher("./updateForm.jsp");
			
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
//		res.sendRedirect("./createForm.jsp");
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
			
			sql += "UPDATE BOARD";
			sql += " SET TITLE = ?, CONTENT = ?, MOD_DATE = SYSDATE";
			sql += " WHERE NO = ?";
			 
			pstmt = conn.prepareStatement(sql);
			
			int no = Integer.parseInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			System.out.println(req.getParameter("no"));
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			
			pstmt.executeUpdate();
			res.sendRedirect("./list");
//			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("./list");
//			
//			dispatcher.forward(req, res);
			
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


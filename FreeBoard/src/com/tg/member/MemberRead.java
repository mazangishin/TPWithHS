package com.tg.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/member/read")
public class MemberRead extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "TEAMP";
		String password = "SORK1EMD";
		
		HttpSession session = req.getSession();
		MemberDto member = (MemberDto)session.getAttribute("member");
		
		String email = member.getEmail();
		String pwd = member.getPassword();
		
//		HttpSession session = req.getSession();//세션가져옴
//	    MDto memberDto2.getEmail= (MDto)session.getAttribute("member");//형변환
		
		String sql = "";
		int colIndex = 1;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE";
			sql += " FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			sql += " AND PASSWORD = ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);
			
			rs = pstmt.executeQuery();
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			ArrayList<MemberDto> memberInfo = new ArrayList<MemberDto>();
			
			int memberNo = 0;
			String memberName = "";
			String memberemail = "";
			Date createDate = null;
			
			while(rs.next()) {
			memberNo = rs.getInt("MNO");
			memberName = rs.getString("MNAME");
			memberemail = rs.getString("EMAIL");
			createDate = rs.getDate("CRE_DATE");
			
			MemberDto memberDto = new MemberDto
					(memberNo, memberName, memberemail, createDate);
			memberInfo.add(memberDto);
			}
			
			req.setAttribute("member", memberInfo);
			
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/member/readMember.jsp");
			
			dispatcher.include(req, res);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 예외처리 페이지로 위임
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/error.jsp");

			dispatcher.forward(req, res);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

	}

}

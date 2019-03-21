package com.tg.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value= "/member/update")
public class UpdateMember extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "TEAMP";
		String password = "SORK1EMD";
		
		HttpSession session = req.getSession();
		MemberDto member = (MemberDto)session.getAttribute("member");

		int mNo = member.getMemberNo();

		String sql = "";
		

		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");

			conn = DriverManager.getConnection(url, user, password);

			sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE";
			sql += " FROM MEMBER";
			sql += " WHERE MNO = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, mNo);

			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";
			Date creDate = null;
		//	String memberPwd = "";

			MemberDto memberDto = null;
			if(rs.next()) {
				mNo = rs.getInt("MNO");
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
			//	memberPwd = rs.getString("PASSWORD");
				creDate = rs.getDate("CRE_DATE");
				
				memberDto = new MemberDto();
				
				memberDto.setMemberNo(mNo);
				memberDto.setMemberName(mName);
				memberDto.setEmail(email);
			//	memberDto.setPassword(memberPwd);
				memberDto.setCreateDate(creDate);
			}

			req.setAttribute("memberDto", memberDto);
			
			res.setCharacterEncoding("UTF-8");
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("./updateMemberForm.jsp");
			
			dispatcher.forward(req, res);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 나중에 예외 처리
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
		} // finally 종료
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";

		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String name = req.getParameter("name");
		
		HttpSession session = req.getSession();
		MemberDto member = (MemberDto)session.getAttribute("member");

		int mNo = member.getMemberNo();

		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "UPDATE MEMBERS";
			sql += " SET EMAIL = ?, MNAME = ?";
			sql += " WHERE MNO = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setInt(3, mNo);

			pstmt.executeUpdate();

			res.sendRedirect("./view");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		} 

	}

}

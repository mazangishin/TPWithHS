package com.tg.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/auth/login")
public class LogInServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();

		MemberDto memberDto = (MemberDto) session.getAttribute("member");

		if (memberDto == null) {
			RequestDispatcher rd = req.getRequestDispatcher("./loginForm.jsp");
			rd.forward(req, res);
		} else {
			String contextPathStr = req.getContextPath() + "/member/read";
			res.sendRedirect(contextPathStr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "TEAMP";
		String password = "SORK1EMD";

		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		String name = "";

		String sql = "";
		int colIndex = 1;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "SELECT MNAME, EMAIL";
			sql += " FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			sql += " AND PASSWORD = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);
			
			rs = pstmt.executeQuery();
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			if (rs.next()) {
				email = rs.getString("email");
				name = rs.getString("mname");

				MemberDto memberDto = new MemberDto(name, email);

				HttpSession session = req.getSession();
				session.setAttribute("member", memberDto);

				res.sendRedirect("../member/read");
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("./loginFail.jsp");

				dispatcher.forward(req, res);
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");

			dispatcher.forward(req, res);

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
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

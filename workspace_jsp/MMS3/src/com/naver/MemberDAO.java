package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.PStmtKey;
import org.apache.tomcat.jni.OS;

public class MemberDAO {
	public DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {

			e.printStackTrace();
		}
	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member ORDER BY id ASC";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				list.add(new MemberDTO(id, name, age, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (id, name, age, pw) VALUES (?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getPassword());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// 나올 값은 1개뿐이기에 MemberDTO로 받는다.
	public MemberDTO selectById(String id) {
		MemberDTO list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				list = new MemberDTO(id, name, age, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	public MemberDTO updateui(String id) {
		return selectById(id);
	}

	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 비밀번호가 맞아야 삭제가 되므로 where 절에서 조건을 주어야 한다.
		String sql = "UPDATE member SET name = ?, age = ? WHERE id = ? and pw = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getPassword());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	public boolean login(LoginDTO loginDTO) {
		boolean isOk = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id = ? and pw = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginDTO.getId());
			pstmt.setString(2, loginDTO.getPw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
//				String id = rs.getString("id");
//				String pw = rs.getString("pw");
//				if (id.equals(loginDTO.getId()) && pw.equals(loginDTO.getPw())) {
				isOk = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return isOk;
	}
}

package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	// 드라이버 이름
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";

	// DB의 URL
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// 사용자 이름, 대문자도 가능은 하다.
	private final String USERNAME = "ca2";

	// 비밀번호, 처음 입력했던 대소문자 통일해야 함
	private final String PASSWORD = "ca2";

	public MemberDAO() {
		try {
			// 드라이버 로딩
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	// 삭제
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_member WHERE id = ?";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 수정
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_member SET name = ?, age = ? WHERE id = ?";
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 조회, selectAll은 필요한게 많으니 특별히 생각하자. ResultSet까지 생각해야 함
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_member";
		// 데이터 넘겨받을 상자 필요
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			pstmt = conn.prepareStatement(sql);

			// DB를 모르는 사람은 rs를 모르므로 list로 바꿔줘야 한다.
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				// list에 값 저장
				list.add(new MemberDTO(id, name, age));
			}
		} catch (Exception e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	// 입력
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_member (id, name, age) values (?, ? ,?)";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			pstmt = conn.prepareStatement(sql);
			// pstmt에 값을 넣어주기
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
	// 드라이버 이름
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";

	// DB의 URL
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// 사용자 이름, 대문자도 가능은 하다.
	private final String USERNAME = "ca2";

	// 비밀번호, 처음 입력했던 대소문자 통일해야 함
	private final String PASSWORD = "ca2";

	public AccountDAO() {
		try {
			// 드라이버 로딩
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	public void transfer(String sender, String reciever, int money) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql1 = "UPDATE account SET balance = balance - ? WHERE name = ?";
		String sql2 = "UPDATE account SET balance = balance + ? WHERE name = ?";
		boolean isOk = false;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// auto commit 해제
			// 해제가 되어야 rollback() 메소드가 먹힘
			conn.setAutoCommit(false);
			
			// pstmt1에 대한 요청 작성, 돈 보내기
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, money);
			pstmt1.setString(2, sender);
			pstmt1.executeUpdate();

			// 여기까지 왔다는건 pstmt1이 null이 아니라는 것이므로 닫아준다.
			pstmt1.close();

			// 유사 정전사태. 예외가 일어나므로 트랜잭션 상황이 일어난다.
			// rollback을 통해 다시 원상태로 돌려야한다.
//			System.out.println(4 / 0);
			
			// pstmt2에 대한 요청 작성, 돈 받기
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, money);
			pstmt2.setString(2, reciever);
			pstmt2.executeUpdate();

			// 여기까지 왔다는건 정상적으로 실행되었다는 뜻
			isOk = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// isOk가 true가 된다 = 문제가 없다 = commit
				if (isOk) {
					conn.commit();

					// isOk가 false다 = 문제가 있다 = rollback
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				// pstmt1 대신 2만 여기서 닫아준다.
				if (pstmt2 != null) {
					pstmt2.close();
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

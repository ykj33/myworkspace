package com.naver;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

public class TestDAO {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver"; // full package명
	// Data Source Explorer에서 URL 찾아서 넣기, 구분자는 :
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "ca2";
	private final String PASSWORD = "ca2";

	public TestDAO() {
		try {
			Class.forName(DRIVER_NAME); // forName으로 Driver를 만든다.
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 예외 메시지는 출력되어야 하지만 고객에게 줄 때는 넘버링해서 매뉴얼화한 후 넘긴다.
			System.out.println("드라이버 로딩 실패"); // 실패시 에러메시지를 띄워준다.
		}
	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_member WHERE id = ?";
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			pstmt = conn.prepareStatement(sql);
			System.out.println("요청서 성공");
			pstmt.setString(1, id);
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

	// 수정
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 무조건 인덱스는 코드 상 왼쪽부터 1번
		String sql = "UPDATE tbl_member SET name = ?, age = ?, WHERE id = ?";
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결 성공");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("커넥션 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 괄호 안은 where 절에 들어가는 컬럼이 무엇인가를 의미
	// 이것보단 컬럼 당 하나씩 메소드를 만들어서 쓰는 방법이 더 권장된다.
	public List<MemberDTO> selectWhat(String what, String value) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();

			// 그냥 String으로 쓰면 너무 난잡해지고 어려우므로 StringBuffer를 이용
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * FROM tbl_member WHERE ");
			sb.append(what);

			// 숫자가 아닌 값은 앞 뒤로 ''를 넣어주어야 하므로 '를 넣어줌
			sb.append("= '");
			sb.append(value);
			sb.append("'");

			// sql에 sb를 넣어주기
			sql = sb.toString();

			// query를 날릴 때 sql을 같이 날린다.
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// statement에선 파라미터로 준 값이라도 다 가져온다.
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				list.add(new MemberDTO(id, name, age));
			}
			System.out.println("커넥션 성공");
		} catch (Exception e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
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

	// id로 검색하기
	// id는 primary key이기 때문에 어차피 1개만 조회되므로 list를 굳이 쓸 필요가 없다.
	public MemberDTO selectById(String id) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_member WHERE id = ?";
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// 어차피 들어갈 값은 1개이므로 while이 아니라 if로 돌리는게 더 빠르다.
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, name, age);
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

		return dto;
	}

	// 이름으로 검색하기
	public List<MemberDTO> selectByName(String name) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_member WHERE name = ?";
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 성공");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				int age = rs.getInt("age");
				// name은 이미 파라미터로 값을 받아오기에 값을 넣어주지 않아도 된다.
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

	// 조회
	// return 값이 있으므로 void가 아니다.
	public List<MemberDTO> selectAll() {

		// 값을 반환할 상자를 만들어놓음
		// 데이터가 없더라도 null이 아니다.
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * 나이 FROM tbl_member";

		// select는 executeQuery()를 사용한다.
		// ResultSet 타입으로 받고, close까지 해야 한다.
		// 그러기 위해 먼저 선언하고 준비시켜놓아야 한다.
		ResultSet rs = null;

		// 그러나 DB를 모르는 사람도 알 수 있어야 한다. 그래서 List를 쓴다.
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결 성공");
			pstmt = conn.prepareStatement(sql);

			// rs에 쿼리를 날림
			rs = pstmt.executeQuery();

			// rs에 있는 값을 list에 넣어주기
			while (rs.next()) {

				// 테이블 어디에 들어가야 하는지 모르므로 파라미터로 컬럼 명을 넣어준다.
				// 별칭이 중요하므로 별칭이 있을 시 별칭을 넣어준다.
				// select * 이 아닌 컬럼명을 넣어준다면 그 순서대로 인덱스 번호를 넣어주어도 된다.
				String id = rs.getString("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");

				// list에 add 하기 위해 MemberDTO객체를 만들어 값을 넣어준다.
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("커넥션 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// 받은 값을 전해주어야 하므로 반환한다.
		return list;
	}

	// 입력
	public void insert(MemberDTO dto) {

		// java.sql에 있는 Connection
		Connection conn = null;

		// PreparedStatement 생성, 요청할 객체 생성
		PreparedStatement pstmt = null;

		// pstmt에 넣을 sql문 작성
		// 물음표는 왼쪽부터 인덱스가 1, 2, 3 순
		String sql = "INSERT INTO tbl_member (id, name, age) values (?, ?, ?)";

		// 꼭 try Catch 구조. 미리 2중 구조를 만들어 둔 다음 작업을 하자, 구조 안정화 작업 필요
		try {
			// Connection은 인터페이스이므로 DriverMager를 이용하여 커넥션을 만든다.
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결 성공");

			// pstmt에 sql문 삽입, 요청서가 1개 만들어짐

			pstmt = conn.prepareStatement(sql);
			// 요청서에 넣어줄 값을 세팅한다.
			// 1번 인덱스 = id, dto 객체에서 id를 가져온다.
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			// 요청서를 실제로 요청함
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("커넥션 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				// 먼저 요청을 제거하고 커넥션을 제거해야 한다. 커넥션부터 제거하면 요청이 붕 뜨게 된다.
				if (pstmt != null) {
					pstmt.close();
				}
				// 만약 연결이 되었다면 닫아줄 필요가 있다. 만약 연결이 되지 않았는데 닫는다면 NullPointerException이 발생할 것
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}

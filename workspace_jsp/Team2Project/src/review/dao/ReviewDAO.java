package review.dao;

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

import review.domain.PageTO;
import review.domain.ReviewDTO;
import review.domain.UploadDTO;

public class ReviewDAO {
	private DataSource dataFactory;

	public ReviewDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// close() 메소드
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

	// 전체 조회
	public List<ReviewDTO> list() {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM review ORDER BY num desc";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");
				list.add(new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	// 상세조회
	public ReviewDTO read(int num) {
		ReviewDTO list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM review WHERE num = ?";
		boolean isOk = false;

		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			increaseReadCnt(conn, num);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");
				list = new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint);
			}
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	// 조회수 증가
	private void increaseReadCnt(Connection conn, int num) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE review SET readcnt = readcnt + 1 WHERE num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}

	// 추가
	public void insert(ReviewDTO reviewDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into review (num, title, content, id, category, starpoint) values (?, ?, ?, ?, ?, ?)";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			int num = createNum(conn);

			pstmt.setInt(1, num);
			pstmt.setString(2, reviewDTO.getTitle());
			pstmt.setString(3, reviewDTO.getContent());
			pstmt.setString(4, reviewDTO.getId());
			pstmt.setString(5, reviewDTO.getCategory());
			pstmt.setInt(6, reviewDTO.getStarpoint());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	// insert에 필요한 num값 생성
	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(num) from review";
		ResultSet rs = null;
		Integer num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1);
				num += 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return num;
	}

	// 게시물 삭제
	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from review where num = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	public ReviewDTO updateUI(int num) {
		ReviewDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM review WHERE num=?";
		ResultSet rs = null;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				int starpoint = rs.getInt("starpoint");

				dto = new ReviewDTO(num, title, content, id, category, null, 0, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	// 게시물 수정
	public void update(ReviewDTO reviewDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE review SET title=?, category=?, starpoint=?, content=? WHERE num=?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reviewDTO.getTitle());
			pstmt.setString(2, reviewDTO.getCategory());
			pstmt.setInt(3, reviewDTO.getStarpoint());
			pstmt.setString(4, reviewDTO.getContent());
			pstmt.setInt(5, reviewDTO.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// 페이지네이션
	public PageTO page(int curPage) {
		PageTO to = new PageTO(curPage);
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ("
				+ "select rownum rnum, num, title, id, category, writeday, readcnt, starpoint from ("
				+ "select * from review order by num desc)) " + "where rnum>=? and rnum<=?";

		try {
			conn = dataFactory.getConnection();
			int amount = getAmount(conn);
			to.setAmount(amount);

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");

				ReviewDTO dto = new ReviewDTO(num, title, null, id, category, writeday, readcnt, starpoint);

				list.add(dto);
			}
			to.setList(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return to;
	}

	// 페이지 처리를 위한 게시글 총량
	private int getAmount(Connection conn) {
		int amount = 0;

		PreparedStatement pstmt = null;
		String sql = "select count(num) from review";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				amount = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}

		return amount;
	}

	// 제목 + 내용으로 검색
	public List<ReviewDTO> searchByTitleContent(String search) {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM review WHERE (title like '%'||?||'%') or (content like '%'||?||'%')";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");

				list.add(new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;

	}

	// 제목으로 검색
	public List<ReviewDTO> searchByTitle(String search) {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM review WHERE title like '%'||?||'%'";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");

				list.add(new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	// 작성자ID로 검색
	public List<ReviewDTO> searchById(String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from review where id = ?";
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");

				list.add(new ReviewDTO(num, title, content, search, category, writeday, readcnt, starpoint));
			}

			if (list == null) {
				System.out.println("해당 ID로 작성된 게시글이 존재하지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return list;
	}

	// id를 넣으면 id가 작성한 게시글 전부 삭제
	public void deleteById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from review where id = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// 공지글 뽑기
	public ReviewDTO notice() {
		ReviewDTO list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT * FROM review WHERE id = 'admin' ORDER BY num desc) WHERE ROWNUM = 1";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String category = rs.getString("category");
				String writeday = rs.getString("writeday");
				String id = rs.getString("id");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");

				list = new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	// 카테고리 셀렉트
	public List<ReviewDTO> cateSelect(String category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from review where category = ?";
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, category);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int starpoint = rs.getInt("starpoint");
				list.add(new ReviewDTO(num, title, content, id, category, writeday, readcnt, starpoint));

			}

			if (list == null) {
				System.out.println("해당 카테고리로 작성된 게시글이 존재하지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return list;
	}

	// 원래 insert에 파라미터값을 다르게 줌
	public void insert(ReviewDTO reviewDTO, UploadDTO uploadDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into review (num, title, content, id, category, starpoint) values (?, ?, ?, ?, ?, ?)";

		boolean isOk = false;

		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);

			int num = createNum(conn);

			upload(conn, new UploadDTO(uploadDTO.getFileName(), uploadDTO.getOrgFileName(), num));

			pstmt.setInt(1, num);
			pstmt.setString(2, reviewDTO.getTitle());
			pstmt.setString(3, reviewDTO.getContent());
			pstmt.setString(4, reviewDTO.getId());
			pstmt.setString(5, reviewDTO.getCategory());
			pstmt.setInt(6, reviewDTO.getStarpoint());

			pstmt.executeUpdate();

			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
	}

// 업로드테이블에 insert
	private void upload(Connection conn, UploadDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "insert into upload (num, fileName, orgFileName) values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getFileName());
			pstmt.setString(3, dto.getOrgFileName());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			closeAll(null, pstmt, null);
		}

	}

	// read에서 파일 이름 반환
	public UploadDTO imgSelect(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UploadDTO dto = null;
		String sql = "select fileName, orgFileName from upload where num = ?";

		String fileName;
		String orgFileName;

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			pstmt.executeUpdate();

			rs = pstmt.executeQuery();

			if (rs.next()) {
				fileName = rs.getString(1);
				orgFileName = rs.getString(2);

				dto = new UploadDTO(fileName, orgFileName, num);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeAll(rs, pstmt, conn);
		}

		return dto;
	}
}

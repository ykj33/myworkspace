package free.dao;

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

import free.domain.FreeDTO;
import review.domain.PageTO;
import review.domain.ReviewDTO;
import sun.font.CreatedFontTracker;

public class FreeDAO {
	private DataSource dataFactory;

	public FreeDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
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

	// 리스트 불러오기
	public List<FreeDTO> selectAll() {
		List<FreeDTO> list = new ArrayList<FreeDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM free ORDER BY fnum DESC";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fnum = rs.getInt("fnum");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String id = rs.getString("id");
				String fwriteday = rs.getString("fwriteday");
				int freadcnt = rs.getInt("freadcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				list.add(new FreeDTO(fnum, ftitle, fcontent, id, fwriteday, freadcnt, repRoot, repStep, repIndent));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	// 상세보기
	public FreeDTO read(int fnum) {
		FreeDTO list = new FreeDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM free WHERE fnum = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			increasecnt(fnum, conn);
			if (rs.next()) {

				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String id = rs.getString("id");
				String fwriteday = rs.getString("fwriteday");
				int freadcnt = rs.getInt("freadcnt");
				list = new FreeDTO(fnum, ftitle, fcontent, id, fwriteday, freadcnt + 1, 0, 0, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	// 조회수 증가
	private void increasecnt(int fnum, Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE free SET freadcnt = freadcnt + 1 WHERE fnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}

	// 추가
	public void insert(FreeDTO freeDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT into free (fnum, ftitle, fcontent, id, repRoot) VALUES (?, ?, ?, ?,?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, increaseFnum(conn));
			pstmt.setString(2, freeDTO.getFtitle());
			pstmt.setString(3, freeDTO.getFcontent());
			pstmt.setString(4, freeDTO.getId());
			pstmt.setInt(5, increaseFnum(conn));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	// fnum값 자동 증가
	private int increaseFnum(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT max(fnum) FROM free";
		int fnum = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fnum = rs.getInt(1);
				fnum += 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		return fnum;
	}

	// 수정을 위한 데이터 가져오기
	public FreeDTO selectByFnum(int fnum) {
		FreeDTO list = new FreeDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM free WHERE fnum = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String id = rs.getString("id");
				String fwriteday = rs.getString("fwriteday");
				int freadcnt = rs.getInt("freadcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				list = new FreeDTO(fnum, ftitle, fcontent, id, fwriteday, freadcnt, repRoot, repStep, repIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	public void update(FreeDTO freeDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE free SET ftitle = ?, fcontent = ? WHERE fnum = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeDTO.getFtitle());
			pstmt.setString(2, freeDTO.getFcontent());
			pstmt.setInt(3, freeDTO.getFnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}

	}

	// 삭제
	public void delete(int fnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM free WHERE fnum = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	public void reply(int orgFnum, FreeDTO freeDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT into free (fnum, ftitle, fcontent, id, repRoot, repStep, repIndent) VALUES (?, ?, ?, ?, ?, ?, ?)";
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);

			int num = increaseFnum(conn);
			FreeDTO orgDTO = selectByFnum(orgFnum);
			stepPlus(conn, freeDTO);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, freeDTO.getFtitle());
			pstmt.setString(3, freeDTO.getFcontent());
			pstmt.setString(4, freeDTO.getId());
			pstmt.setInt(5, orgDTO.getRepRoot());
			pstmt.setInt(6, orgDTO.getRepStep() + 1);
			pstmt.setInt(7, orgDTO.getRepIndent() + 1);

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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}

	}

	private void stepPlus(Connection conn, FreeDTO freeDTO) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE free SET repStep = repStep + 1 WHERE repRoot = ? and repStep >?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, freeDTO.getRepRoot());
			pstmt.setInt(2, freeDTO.getRepStep());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}

	}

	public PageTO page(int curPage) {
		PageTO to = new PageTO(curPage);
		List<FreeDTO> list = new ArrayList<FreeDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from (select rownum rnum, fnum, ftitle, id, fwriteday, freadcnt from (select * from free order by fnum desc))where rnum>=? and rnum<=?";
		try {
			conn = dataFactory.getConnection();
			int amount = getAmount(conn);
			to.setAmount(amount);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fnum = rs.getInt("fnum");
				String ftitle = rs.getString("ftitle");
				String id = rs.getString("id");
				String fwriteday = rs.getString("fwriteday");
				int freadcnt = rs.getInt("freadcnt");


				FreeDTO dto = new FreeDTO(fnum, ftitle, null, id, fwriteday, freadcnt, 0, 0, 0);
				list.add(dto);
			}
			to.setFreelist(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return to;
	}

	private int getAmount(Connection conn) {
		int amount = 0;
		PreparedStatement pstmt = null;
		String sql = "SELECT count(fnum) FROM free";
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

}

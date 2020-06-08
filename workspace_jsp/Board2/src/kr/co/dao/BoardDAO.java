package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.BoardDTO;

public class BoardDAO {
	private DataSource dataFactory;
	
	public BoardDAO() {
		
		try {
			Context	ctx = new InitialContext();
				
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public List<BoardDTO> list() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board order by repRoot desc, repStep asc ";
		ResultSet rs = null;
						
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
//				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");

				// 실제로는 보통 위에까지만...
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, repRoot, repStep, repIndent));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
	}



	public void insert(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num,writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
		// num 값을 여기서 만들어준다.
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// num 값 만들어주는...반드시 커낵션을 넣어주어야 한다...
			int num = createNum(conn);	// 같은 커낵션을 가지고 작업을해야하기때문에
			
			
			pstmt.setInt(1, num);
			pstmt.setString(2,boardDTO.getWriter() );
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);		// repRoot 는 처음이라 num 값을 받는다.
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}



	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		
		// 가장 큰 num 값 가져온다...
		String sql = "select max(num) from board";
		ResultSet rs = null;
		Integer num = null;
		
		try {
			// 커낵션은 이미 객체가 있다...
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 지금은 int 로 해도 되지만
				// ???
				num = rs.getInt(1);		// 컬럼명을 모르니 그냥 1로 받는다...

				// 없으면 null 이 아니라 0을 반환
				num +=1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 여기서 커낵션 닫아주면 insert 다음이 실행이 안된다...
			// 그래서 여기는 닫지말고 null로...
			closeAll(rs, pstmt, null);
		}
		
		
		return num;
	}

}

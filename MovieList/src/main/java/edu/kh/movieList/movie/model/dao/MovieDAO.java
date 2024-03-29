package edu.kh.movieList.movie.model.dao;

import java.sql.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.movieList.common.JDBCTemplate.*;

import edu.kh.movieList.movie.model.dto.CommonCode;
import edu.kh.movieList.movie.model.dto.Movie;

public class MovieDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MovieDAO() {
		try {
			
			prop = new Properties();
			
			String filePath = MovieDAO.class.getResource("/edu/kh/movieList/sql/movie-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 추천 영화 목록 조회 DAO
	 * @param conn
	 * @return
	 */
	public List<Movie> selectAll(Connection conn) throws Exception {
		
		List<Movie> movieList = new ArrayList<Movie>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Movie movie = new Movie(
						  rs.getInt("MOVIE_NO")
						, rs.getString("MOVIE_TITLE")
						, rs.getString("GENRE")
						, rs.getString("PRODUCE")
						, rs.getString("COUNTRY")
						, rs.getString("RELEASE_DATE")
						, rs.getInt("MOVIE_TIME")
						, rs.getString("INTRODUCE")
						, rs.getInt("RATING")
						, rs.getString("DIRECTOR")
						, rs.getString("MEMBER_ID")
						, rs.getString("MEMBER_NAME")
						, rs.getString("INS_DT")
						, rs.getString("MOVIE_REVIEW")
						);
				
				movieList.add(movie);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return movieList;
	}

	/** 콤보박스 목록 조회 DAO
	 * @param conn
	 * @param codeId
	 * @return
	 */
	public List<CommonCode> codeSel(Connection conn, String codeId) throws Exception {
		
		List<CommonCode> codeList = new ArrayList<CommonCode>();
		
		try {
			String sql = prop.getProperty("codeSel");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, codeId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				CommonCode code = new CommonCode();
				
				code.setCodeNo(rs.getString("CODE_NO"));
				code.setCodeNm(rs.getString("CODE_NAME"));
				
				
				codeList.add(code);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return codeList;
	}

	/** 영화 등록 DAO
	 * @param conn
	 * @param movieTitle
	 * @param genre
	 * @param produce
	 * @param country
	 * @param releaseDt
	 * @param movieTime
	 * @param introduce
	 * @param rating
	 * @param director
	 * @param movieReview
	 * @param memberId
	 * @return
	 */
	public int insert(Connection conn, String movieTitle, String genre, String produce, String country,
			String releaseDt, int movieTime, String introduce, int rating, String director, String movieReview,
			String memberId) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movieTitle);
			pstmt.setString(2, genre);
			pstmt.setString(3, produce);
			pstmt.setString(4, country);
			pstmt.setString(5, releaseDt);
			pstmt.setInt(6, movieTime);
			pstmt.setString(7, introduce);
			pstmt.setString(8, movieReview);
			pstmt.setInt(9, rating);
			pstmt.setString(10, director);
			pstmt.setString(11, memberId);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(conn);
		}
		
		return result;
	}

	/** 영화 삭제 DAO
	 * @param conn
	 * @param movieNo
	 * @return
	 */
	public int delete(Connection conn, String movieNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movieNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 영화 상세 DAO
	 * @param conn
	 * @param movieNo
	 * @return
	 */
	public Movie selectDeail(Connection conn, String movieNo) throws Exception {
		
		Movie movie = null;
		
		try {
			
			String sql = prop.getProperty("selectDeail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				movie =  new Movie(
						  rs.getInt("MOVIE_NO")
						, rs.getString("MOVIE_TITLE")
						, rs.getString("GENRE")
						, rs.getString("PRODUCE")
						, rs.getString("COUNTRY")
						, rs.getString("RELEASE_DATE")
						, rs.getInt("MOVIE_TIME")
						, rs.getString("INTRODUCE")
						, rs.getInt("RATING")
						, rs.getString("DIRECTOR")
						, rs.getString("MEMBER_ID")
						, rs.getString("MEMBER_NAME")
						, rs.getString("INS_DT")
						, rs.getString("MOVIE_REVIEW")
						);
			}
			
		} finally {
			close(rs);
			close(conn);
		}
		
		return movie;
	}

	/** 영화 수정 DAO
	 * @param conn
	 * @param movieTitle
	 * @param genre
	 * @param produce
	 * @param country
	 * @param releaseDt
	 * @param movieTime
	 * @param introduce
	 * @param rating
	 * @param director
	 * @param movieReview
	 * @param memberId
	 * @return
	 */
	public int update(Connection conn, String movieTitle, String genre, String produce, String country,
			String releaseDt, int movieTime, String introduce, int rating, String director, String movieReview,
			String memberId, String movieNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movieTitle);
			pstmt.setString(2, genre);
			pstmt.setString(3, produce);
			pstmt.setString(4, country);
			pstmt.setString(5, releaseDt);
			pstmt.setInt(6, movieTime);
			pstmt.setString(7, introduce);
			pstmt.setString(8, movieReview);
			pstmt.setInt(9, rating);
			pstmt.setString(10, director);
			pstmt.setString(11, movieNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}

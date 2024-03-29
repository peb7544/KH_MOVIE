package edu.kh.movieList.movie.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.movieList.common.JDBCTemplate.*;
import edu.kh.movieList.movie.model.dao.MovieDAO;
import edu.kh.movieList.movie.model.dto.CommonCode;
import edu.kh.movieList.movie.model.dto.Movie;

public class MovieService {
	
	private MovieDAO dao = new MovieDAO();
	
	public MovieService() {}

	/** 추천 영화 목록 조회 서비스
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> selectAll() throws Exception {
		
		Connection conn = getConnection();
		
		List<Movie> movieList = dao.selectAll(conn);
		
		close(conn);
		
		return movieList;
	}

	/** 콤보박스 목록 조회 서비스
	 * @param genreCode
	 * @return
	 */
	public List<CommonCode> codeSel(String codeId) throws Exception {
		
		Connection conn = getConnection();
		
		List<CommonCode> codeList = dao.codeSel(conn, codeId);
		
		close(conn);
		
		return codeList;
	}

	/** 영화 등록 서비스
	 * @param movieTitle
	 * @param genre
	 * @param produce
	 * @param country
	 * @param country2
	 * @param releaseDt
	 * @param movieTime
	 * @param introduce
	 * @param rating
	 * @param director
	 * @param movieReview
	 * @param memberId
	 * @return
	 */
	public int insert(String movieTitle, String genre, String produce, String country, 
			String releaseDt, int movieTime, String introduce, int rating, String director, String movieReview,
			String memberId) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insert(conn, movieTitle, genre, produce, country, releaseDt, movieTime,
								 introduce, rating, director, movieReview, memberId);
								
		if(result > 0) close(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 영화 삭제 서비스
	 * @param movieNo
	 * @return
	 */
	public int delete(String movieNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.delete(conn, movieNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
		
	}

	/** 영화 상세 서비스
	 * @param movieNo
	 * @return
	 */
	public Movie selectDeail(String movieNo) throws Exception {
		
		Connection conn = getConnection();
		
		Movie movie = dao.selectDeail(conn, movieNo);
		
		close(conn);
		
		return movie;
	}

	/** 영화 수정 서비스
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
	public int update(String movieTitle, String genre, String produce, String country, String releaseDt, int movieTime,
			String introduce, int rating, String director, String movieReview, String memberId, String movieNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.update(conn, movieTitle, genre, produce, country, releaseDt, movieTime,
				 introduce, rating, director, movieReview, memberId, movieNo);
		
		if(result > 0) close(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

}

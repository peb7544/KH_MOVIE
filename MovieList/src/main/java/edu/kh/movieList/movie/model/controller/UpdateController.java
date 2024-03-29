package edu.kh.movieList.movie.model.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.movieList.member.model.dto.Member;
import edu.kh.movieList.movie.model.dto.CommonCode;
import edu.kh.movieList.movie.model.dto.Movie;
import edu.kh.movieList.movie.model.service.MovieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	
	private MovieService service = new MovieService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 장르 조회
			String genreCode = "GENRE";
			List<CommonCode> genreList = service.codeSel(genreCode);
			
			req.setAttribute("genreList", genreList);
			
			// 나라 조회
			String countryCode = "COUNTRY";
			List<CommonCode> countryList = service.codeSel(countryCode);
			
			req.setAttribute("countryList", countryList);
			
			HttpSession session = req.getSession();
			
			Member member = (Member) session.getAttribute("loginMember");
			
			String movieNo = req.getParameter("movieNo");
			
			Movie movie = service.selectDeail(movieNo);
			
			session.setAttribute("movie", movie);
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			
		} catch(Exception e) {
			System.out.println("[조회상세 중 예외발생]");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			Member member = (Member) session.getAttribute("loginMember");
			
			String movieTitle = req.getParameter("movieTitle");
			String genre = req.getParameter("genre");
			String produce = req.getParameter("produce");
			String country = req.getParameter("country");
			String releaseDt = req.getParameter("releaseDt");
			int movieTime = Integer.parseInt(req.getParameter("movieTime"));
			String introduce = req.getParameter("introduce");
			int rating = Integer.parseInt(req.getParameter("rating"));
			String director = req.getParameter("director");
			String movieReview = req.getParameter("movieReview");
			String movieNo = req.getParameter("movieNo");
			
			int result = service.update(movieTitle, genre, produce, country, releaseDt
					, movieTime, introduce, rating, director, movieReview, member.getMemberId(), movieNo);
			
			if(result > 0) {
				session.setAttribute("msg", "수정되었습니다");
				
				List<Movie> movieList = service.selectAll();
				session.setAttribute("movieList", movieList);
						
				resp.sendRedirect("/");
			} else {
				session.setAttribute("msg", "수정 실패");
				
				resp.sendRedirect(req.getHeader("referer"));
			}
			
		} catch (Exception e) {
			System.out.println("[수정 중 예외발생]");
			e.printStackTrace();
		}
		
	}
}

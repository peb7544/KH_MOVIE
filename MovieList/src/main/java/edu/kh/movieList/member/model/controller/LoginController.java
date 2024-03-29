package edu.kh.movieList.member.model.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.movieList.member.model.dto.Member;
import edu.kh.movieList.member.model.service.MemberService;
import edu.kh.movieList.movie.model.dto.Movie;
import edu.kh.movieList.movie.model.service.MovieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			MemberService service = new MemberService();
			
			// 로그인
			Member loginMember = service.login(inputId, inputPw);
			HttpSession session = req.getSession();
			
			if(loginMember != null) {
				
				session.setAttribute("loginMember", loginMember);
				session.setMaxInactiveInterval(60 * 60); // 세션 1시간 
				
				// 추천 영화 목록 조회
				MovieService movieService = new MovieService();
				
				List<Movie> movieList = movieService.selectAll();
				
				session.setAttribute("movieList", movieList);
				
				resp.sendRedirect("/");
				
			} else {
				session.setAttribute("msg", "아이디 또는 비밀번호가 불일치합니다");
				
				String referer = req.getHeader("referer");
				resp.sendRedirect(referer);
			}
			
		} catch(Exception e) {
			System.out.println("로그인 중 예외 발생");
			e.printStackTrace();
		}
		
	}

}

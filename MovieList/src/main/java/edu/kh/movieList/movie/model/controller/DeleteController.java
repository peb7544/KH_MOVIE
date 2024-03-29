package edu.kh.movieList.movie.model.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.movieList.movie.model.dto.Movie;
import edu.kh.movieList.movie.model.service.MovieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String movieNo = req.getParameter("movieNo");
			
			MovieService service = new MovieService();
			
			int result = service.delete(movieNo);
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				session.setAttribute("msg", "삭제되었습니다");
				
				List<Movie> movieList = service.selectAll();
				
				session.setAttribute("movieList", movieList);
				
				resp.sendRedirect("/");
			} else {
				session.setAttribute("msg", "삭제 실패");
			}
			
		} catch (Exception e) {
			System.out.println("삭제 중 예외 발생");
			e.printStackTrace();
		}
	}
}

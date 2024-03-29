package edu.kh.movieList.member.model.controller;

import java.io.IOException;

import edu.kh.movieList.member.model.dto.Member;
import edu.kh.movieList.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			Member member = new Member();
			
			member.setMemberId(req.getParameter("inputId"));
			member.setMemberPw(req.getParameter("inputPw"));
			member.setMemberNm(req.getParameter("inputNm"));
			
			MemberService service = new MemberService();
			
			int result = service.signup(member);
			HttpSession session = req.getSession();
			
			if(result > 0) {
				session.setAttribute("msg", "회원가입 완료");
				resp.sendRedirect("/");
			} else {
				session.setAttribute("msg", "회원가입 실패");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
		} catch (Exception e) {
			System.out.println("회원가입 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
}

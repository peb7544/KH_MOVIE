package edu.kh.movieList.movie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie {
	
	private int movieNo; // 영화번호
	private String movieTitle; // 영화제목
	private String genre; // 영화장르
	private String produce; // 영화제작사
	private String country; // 나라
	private String releaseDate; //영화개봉일
	private int movieTime; // 영화시간
	private String introduce; // 영화소개
	private int rating; // 영화평점
	private String director; // 영화감독
	private String memberId; // 작성자
	private String memberNm; // 작성자명
	private String insDt; // 작성일자
	private String movieReview; // 후기
}

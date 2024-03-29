package edu.kh.movieList.member.model.dto;

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
public class Member {

	private String memberId;
	private String memberPw;
	private String memberNm;
	private String enrollDate;
	private String memberDelFl;
	
}
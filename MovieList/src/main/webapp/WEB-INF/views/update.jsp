<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/save.css">

<title>영화 수정</title>
</head>
<body>
	<main>
        <h1>영화 수정</h1>
        
        <form action="/update" method="post" class="detail">
            <table>
                <tr>
                    <td><span class="colRed">*</span>영화제목</td>
                    <td><input name="movieTitle" value="${movie.movieTitle }" required> </td>
                </tr>
                <tr>
                    <td>평점</td>
                    <td >
                        <div class="review">
                            <input type="radio" name="rating" value="5" id="star5" ${movie.rating eq '5' ? 'checked' : ''}><label for="star5">★</label> 
                            <input type="radio" name="rating" value="4" id="star4" ${movie.rating eq '4' ? 'checked' : ''}><label for="star4">★</label> 
                            <input type="radio" name="rating" value="3" id="star3" ${movie.rating eq '3' ? 'checked' : ''}><label for="star3">★</label> 
                            <input type="radio" name="rating" value="2" id="star2" ${movie.rating eq '2' ? 'checked' : ''}><label for="star2">★</label> 
                            <input type="radio" name="rating" value="1" id="star1" ${movie.rating eq '1' ? 'checked' : ''}><label for="star1">★</label>
                        </div> 
                    </td>
                </tr>
                <tr>
                    <td>장르</td>
                    <td>
                        <select class="cbSelect" name="genre">
                        		<option value="없음">선택하세요</option>
                        		
                        	<c:forEach var="genre" items="${genreList }">
                        		<option value="${genre.codeNo }" ${movie.genre eq genre.codeNo  ? 'selected' : ''}>${genre.codeNm }</option>
                        	</c:forEach>
                            <!-- 
                            <option>판타지</option>
                            <option>로맨스</option>
                            <option>공포</option> -->
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>감독</td>
                    <td><input name="director" value="${movie.director }"> </td>
                </tr>
                <tr>
                    <td>제작사</td>
                    <td><input name="produce" value="${movie.produce }"> </td>
                </tr>
                <tr>
                    <td>나라</td>
                    <td>
                        <select class="cbSelect" name="country">
                        		<option value="없음">선택하세요</option>
                        		
                        	<c:forEach var="country" items="${countryList }">
                        		<option value="${country.codeNo }" ${movie.country eq country.codeNo  ? 'selected' : ''}>${country.codeNm }</option>
                        	</c:forEach>
                            <!-- <option>미국</option>
                            <option>대한민국</option>
                            <option>러시아</option>
                            <option>영국</option> -->
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>개봉일</td>
                    <td><input id="releaseDt" value="${movie.releaseDate }" placeholder="YYYYMMDD 형식으로 입력해주세요"> </td>
                </tr>
                <tr>
                    <td>시간</td>
                    <td><input type="number" name="movieTime" value="${movie.movieTime }"><span>분</span> </td>
                </tr>
                <tr>
                    <td>소개</td>
                    <td><textarea name="introduce">${movie.introduce }</textarea></td>
                </tr>
                <tr>
                    <td>후기</td>
                    <td><textarea name="movieReview">${movie.movieReview }</textarea></td>
                </tr>
            </table>
            
            <input type="hidden" id="releaseDt2" name="releaseDt"  value="${movie.releaseDate }">
			<input type="hidden" name="movieNo"  value="${movie.movieNo }">
			
            <button>등록</button>
        </form>
    </main>
    
    <script src="resources/js/save.js"></script>
</body>
</html>
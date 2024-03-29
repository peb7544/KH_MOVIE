<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/save.css">

<title>영화 등록</title>
</head>
<body>
	<main>
        <h1>영화 등록</h1>
        
        <form action="/insert" method="post" class="detail">
            <table>
                <tr>
                    <td><span class="colRed">*</span>영화제목</td>
                    <td><input name="movieTitle" required> </td>
                </tr>
                <tr>
                    <td>평점</td>
                    <td >
                        <div class="review">
                            <input type="radio" name="rating" value="5" id="star5"><label for="star5">★</label> 
                            <input type="radio" name="rating" value="4" id="star4"><label for="star4">★</label> 
                            <input type="radio" name="rating" value="3" id="star3"><label for="star3">★</label> 
                            <input type="radio" name="rating" value="2" id="star2"><label for="star2">★</label> 
                            <input type="radio" name="rating" value="1" id="star1"><label for="star1">★</label>
                        </div> 
                    </td>
                </tr>
                <tr>
                    <td>장르</td>
                    <td>
                        <select class="cbSelect" name="genre">
                        		<option value="없음">선택하세요</option>
                        		
                        	<c:forEach var="genre" items="${genreList }">
                        		<option value="${genre.codeNo }">${genre.codeNm }</option>
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
                    <td><input name="director"> </td>
                </tr>
                <tr>
                    <td>제작사</td>
                    <td><input name="produce"> </td>
                </tr>
                <tr>
                    <td>나라</td>
                    <td>
                        <select class="cbSelect" name="country">
                        		<option value="없음">선택하세요</option>
                        		
                        	<c:forEach var="country" items="${countryList }">
                        		<option value="${country.codeNo }">${country.codeNm }</option>
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
                    <td><input id="releaseDt" placeholder="YYYYMMDD 형식으로 입력해주세요"> </td>
                </tr>
                <tr>
                    <td>시간</td>
                    <td><input type="number" name="movieTime"><span>분</span> </td>
                </tr>
                <tr>
                    <td>소개</td>
                    <td><textarea name="introduce">
                        
                    </textarea></td>
                </tr>
                <tr>
                    <td>후기</td>
                    <td><textarea name="movieReview"></textarea></td>
                </tr>
            </table>
            
            <input type="hidden" id="releaseDt2" name="releaseDt" >

            <button>등록</button>
        </form>
    </main>
    
    <script src="resources/js/save.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/main.css">

<title>추천 영화 목록</title>

</head>
<body>
    
        
		<c:choose>
        	
        	<%-- 로그인 X --%>
        	<c:when test="${empty sessionScope.loginMember }">
        	<main style="top:20%;">
        	<h1 >추천 영화 목록</h1>
	        <form action="/login" method="post" class="login">
	            <input name="inputId" placeholder="아이디" required>
	            
	            <br>
	
	            <input type="password" name="inputPw" placeholder="암호" required>
	
	            <br>
	
	            <button>로그인</button>
	
	        </form>
	
	        <form action="/signup" class="signup"><button>회원가입</button></form>
	        
	        </c:when>
	        
	        <%-- 로그인 O --%>
	        <c:otherwise>
	        	<main style="top:10%;">
	        	<h1>추천 영화 목록</h1>
	        	
	        	<div class="headBtn">
	        		<div>
	        			<input type="hidden" id="loginId"  value="${sessionScope.loginMember.memberId}">
	        			<span style="font-weight: bold;">${sessionScope.loginMember.memberNm}님 환영합니다.</span>
	        		</div>
	        		<div>
		        		<form action="/insert"><button>등록</button></form>
			           	<form action="/logout"><button>로그아웃</button></form>
	        		</div>
		        </div>
	        	
	        	<table id="movieList">
		            <thead>
		                <tr>
		                    <th>번호</th>
		                    <th width="250">영화 제목</th>
		                    <th>평점</th>
		                    <th>작성자</th>
		                    <th>작성일자</th>
		                </tr>
		            </thead>
		
				
		            <tbody>
		            
		            <c:choose>
		            
		            <c:when test="${not empty movieList }">
						
						<c:forEach var="movie" items="${movieList }" varStatus="vs">
		                <!-- <tr class="rowHover" onclick="listClickFn(${movie.movieNo})"> -->
		                <tr class="rowHover" onclick="listClickFn(this)">
		                    <td>${vs.count }</td>
		                    <td>${movie.movieTitle }</td>
		                    <td>
		                        <label class="star_y"><c:forEach begin="1" end="${movie.rating }" var="i">★</c:forEach></label><label class="star_n"><c:forEach begin="1" end="${5-movie.rating }" var="i">★</c:forEach></label>
		                    </td>
		                    <td>${movie.memberNm }</td>
		                    <td>${movie.insDt }</td>
		                </tr>
		                <tr class="detailTr" id="list_${movie.movieNo}"  style="display:none;"><td colspan="5">
		                    <div class="detail detailText">
		                    	<div class="headBtn crudBtn">
	                                <div></div>
	                                <div>
	                                	<c:if test="${sessionScope.loginMember.memberId == movie.memberId}">
		                                    <form action="/update">
		                                    	<input type="hidden" name="movieNo" value="${movie.movieNo}">
		                                    	<button>수정</button>
		                                    </form>
		                                    <form action="/delete">
		                                    	<input type="hidden" name="movieNo" value="${movie.movieNo}">
		                                    	<button onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
		                                    </form>
	                                    </c:if>
	                                </div>
                        		</div>
		                        <table>
		                            <tr>
		                                <td>장르</td>
		                                <td><input value="${movie.genre }" readonly> </td>
		                            </tr>
		                            <tr>
		                                <td>감독</td>
		                                <td><input value="${movie.director }" readonly> </td>
		                            </tr>
		                            <tr>
		                                <td>제작사</td>
		                                <td><input value="${movie.produce }" readonly> </td>
		                            </tr>
		                            <tr>
		                                <td>나라</td>
		                                <td><input value="${movie.country }" readonly> </td>
		                            </tr>
		                            <tr>
		                                <td>개봉일</td>
		                                <td><input value="${movie.releaseDate }" readonly> </td>
		                            </tr>
		                            <tr>
		                                <td>시간</td>
		                                <td><input value="${movie.movieTime }분" readonly> </td>
		                            </tr>
		                            <tr>
		                                <td>소개</td>
		                                <td>
		                                	<textarea readonly>${movie.introduce }</textarea></td>
		                            </tr>
		                            <tr>
		                                <td>후기</td>
		                                <td><textarea readonly>${movie.movieReview }</textarea></td>
		                            </tr>
		                        </table>
		                    </div>
		                </td></tr>
		                </c:forEach>
		                
		            </tbody>
		        </table>
		        
		        	</c:when>
		        	
			        <c:otherwise>
			        
			        </tbody>
		        </table>
		        
			        	<h3 style="color: #bbb;">작성된 글이 없습니다.</h3>
			        	
			        </c:otherwise>
						
		       		</c:choose>
	        	
	        </c:otherwise>
	        
        </c:choose>
        
        <c:if test ="${not empty sessionScope.msg }">
        	<script>alert('${msg}')</script>
        	<c:remove var="msg" scope="session"/>
        </c:if>
    </main>
    
    <script src="resources/js/main.js"></script>
</body>
</html>
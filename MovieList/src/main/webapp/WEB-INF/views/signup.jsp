<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/signup.css">

<title>회원가입</title>
</head>
<body>
	<main style="top:15%">
        <h1>회원가입</h1>
        
        <form action="/signup" method="post" class="detail signup" onsubmit="return validate()">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input name="inputId" id="inputId" autocomplete="off"> </td>
                </tr>
                <tr>
                	<td></td>
                	<td><span id="idMsg" class="msg">영어 대/소문자, 숫자, 특수문자 포함 6~14글자</span></td>
                <tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input name="inputPw" id="inputPw" type="password"> </td>
                </tr>
                <tr>
                	<td></td>
                	<td><span class="msg"></span></td>
                <tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input name="inputPw2" id="inputPw2" type="password"> </td>
                </tr>
                <tr>
                	<td></td>
                	<td><span id="pwMsg" class="msg"></span></td>
                <tr>
                <tr>
                    <td>이름</td>
                    <td><input name="inputNm" id="inputNm"> </td>
                </tr>
                <tr>
                	<td></td>
                	<td><span id="nmMsg" class="msg"></span></td>
                <tr>
            </table>
            
            <button>가입하기</button>
        </form>
    </main>
    
    <script src="resources/js/signup.js"></script>
</body>
</html>
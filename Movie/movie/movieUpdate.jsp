<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 영화 정보 수정 </title>
<link type="text/css" href="css/movie.css" rel="stylesheet">
<script type="text/javascript" src="script/movie.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1> 수정 페이지 </h1>
<form method="post" enctype="multipart/form-data" name="frm">
<input type="hidden" name="code" value="${movie.code}">
<input type="hidden" name="nonmakeImg" value="${movie.poster}">

<table>
	<tr>
		<td>
			<c:choose>
				<c:when test="${empty movie.poster}">
					<img src="upload/movie.jpg">
				</c:when>
				<c:otherwise>
					<img src="upload/${movie.poster}">
				</c:otherwise>
			</c:choose>
		</td>
		
		<td>
			<table>
				<tr>
					<th style="width: 80px"> 영화 제목 </th>
					<td>
						<input type="text" name="title" value="${movie.title}">
					</td>
				</tr>
				<tr>
					<th> 가 격 </th>
					<td>
						<input type="text" name="price" value="${movie.price}">원
					</td>
				</tr>
				<tr>
					<th> 감 독 </th>
					<td>
						<input type="text" name="director" value="${movie.director}">
					</td>
				</tr>
				<tr>
					<th> 배 우 </th>
					<td>
						<input type="text" name="actor" value="${movie.actor}">
					</td>
				</tr>
				<tr>
					<th> 설 명 </th>
					<td>
						<textarea rows="16" cols="80" name="synopsis"> ${movie.synopsis} </textarea>
					</td>	
				<tr>
					<th> 포스터 </th>
					<td>
						<input type="file" name="poster">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<input type="submit" value="수정완료" onclick="return movieCheck()">
<input type="reset" value="다시시도">
<input type="button" value="목록" onclick="location.href='movieList.do'">

</form>
</div>
</body>
</html>

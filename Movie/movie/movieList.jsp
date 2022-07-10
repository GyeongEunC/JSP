<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 영화 관리 프로그램 </title>
<link type="text/css" href="css/movie.css" rel="stylesheet">
</head>
<body>
<div id="wrap" align="center">
<h1> 영화 리스트 </h1>
<table class="list">
	<tr>
		<td colspan="6" style="border: white; text-align: right;">
		<a href="movieWrite.do"> 영화 정보 등록 </a>
		</td>
	</tr>
	<tr>
		<th> 제 목 </th>
		<th> 감 독 </th>
		<th> 배 우 </th>
		<th> 가 격 </th>
		<th> 수 정 </th>
		<th> 삭 제 </th>
	</tr>
	
	<c:forEach items="${mlist}" var="movie">
	<tr class="record">
		<td> ${movie.title} </td>
		<td> ${movie.director} </td>
		<td> ${movie.actor} </td>
		<td style="text-align: right;"> ${movie.price}원 </td>
		<td> <a href="movieUpdate.do?code=${movie.code}"> 정보 수정 </a> </td>
		<td> <a href="movieDelete.do?code=${movie.code}"> 정보 삭제 </a> </td>
	</tr>
	</c:forEach>

</table>
</div>
</body>
</html>

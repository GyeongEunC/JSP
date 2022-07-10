<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/movie.css" rel="stylesheet">
<script type="text/javascript" src="script/movie.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1> 영화 정보 등록 페이지 </h1>
<form method="post" enctype="multipart/form-data" name="frm">
<table class="list">
	<tr>
		<th> 제 목 </th>
		<td> <input type="text" name="title" size="80"> </td>
	</tr>
	<tr>
		<th> 가 격 </th>
		<td> <input type="text" name="price" size="80">원 </td>
	</tr>
	<tr>
		<th> 감 독 </th>
		<td> <input type="text" name="director" size="80"> </td>
	</tr>
	<tr>
		<th> 배 우 </th>
		<td> <input type="text" name="actor" size="80"> </td>
	</tr>
	<tr>
		<th> 설 명 </th>
		<td> <textarea rows="10" cols="80" name="synopsis"> </textarea> </td>
	</tr>
	<tr>
		<th> 포스터 </th>
		<td> <input type="file" name="poster"><br>
	</tr>
</table> <br>

<input type="submit" value="등록" onclick="return movieCheck()">
<input type="reset" value="다시작성">
<input type="button" value="목록" onclick="location.href='movieList.do'">

</form>
</div>
</body>
</html>

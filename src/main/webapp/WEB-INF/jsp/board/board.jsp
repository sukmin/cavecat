<%@ page session="true" %>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<title>파일저장</title>
</head>
<body>
	<h2>게시판</h2>
	<form action="/board" method="post" enctype="multipart/form-data">
		<div><input type="text" name="title" placeholder="제목"></div>
		<div><textarea rows="5" cols="30" name="text" placeholder="내용"></textarea></div>
		<br>
		<div>첨부파일</div>
		<input type="file" name="testFile"><br>
		<input type="submit"><br>
	</form>
	
	<a href="<c:url value="/login?logout" />">Logout</a>
</body>
</html>
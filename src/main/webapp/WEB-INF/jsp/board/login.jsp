<%@ page session="true" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<style type="text/css">
		label { width: 65px; display: inline-block; }
		input[type=text] { width: 100px; }
	</style>
	<title>login</title>
</head>
<body>
	<h2>Login View</h2>
	<div>로그인을 하시오.</div>
	<% if ((Boolean) request.getAttribute("loginFailed")){ %>
	<p>아이디와 패스워드를 입력하세요.</p>
	<% } %>
	<div>
		<form action="/login" method="post">
			<label for="id">아이디</label>
			<input type="text" name="id" placeholder="ID"><br>
			<label for="passwd">패스워드</label>
			<input type="text" name="passwd" placeholder="Password">
			<input type="submit">
		</form>
	</div>
</body>
</html>
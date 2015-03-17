<%@ page session="true" %>
<!doctype html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>login</title>
	</head>
    <body>
	    <h2>Login View</h2>
	    <div>로그인을 하시오.</div>
		<% if ((Boolean) request.getAttribute("loginFailed")){ %>
			<p>로그인 실패</p>
		<% } %>
	
		<form action="/board/login" method="post">
			아 이 디 : <input type="text" name="id"><br>
			패스워드 : <input type="text" name="passwd"><br>
			<input type="submit">
		</form>
    </body>
</html>
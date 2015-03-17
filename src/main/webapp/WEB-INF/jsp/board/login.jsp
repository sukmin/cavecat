<%@ page session="true" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>

<h2>Login View</h2>
로그인을 하시오.<br>
 

	<%if( (Boolean) request.getAttribute("loginFailed") ){%> 
		<p>로그인 실패 </p>
	<%} %>

<form action="/board/login" method="post">
	 아이디 : <input type="text" name="id"><br>
	패스워드 : <input type="text" name="passwd"><br>
	<input type="submit">
</form>

</body>
</html>
<%@ page session="true" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>파일저장</title>
</head>
<body>
	<div>파일 저장</div>
	<form action="/test" method="post" enctype="multipart/form-data">
		<input type="text" name="testText"><br>
		<input type="file" name="testFile"><br>
		<input type='submit'><br>
	</form>
	
	<a href="<c:url value="/login?logout" />">Logout</a>	
</body>
</html>
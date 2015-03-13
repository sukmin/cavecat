<%@ page session="false" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>오늘 저녁은?</title>
</head>
<body>
	<div>김밥은 노랑무가 커야 맛있고 바베큐 치킨은 닭이 작아야 맛있다.</div>
	<form action="/test" method="post" enctype="multipart/form-data">
		<input type="text" name="testText"><br>
		<input type="file" name="testFile"><br>
		<input type='submit'><br>
	</form>
</body>
</html>
<%@ page session="true" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>글쓰기</title>
	
	<!-- Bootstrap core CSS -->
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">body { padding-top: 70px; }</style>
</head>
<body>
	<h1>${testAttr }</h1>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">cavecat</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form action="/boardSave" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="title">제목</label>
						<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
					</div>
					<div class="form-group">
						<label for="text">내용</label>
						<textarea class="form-control" rows="5" cols="30" id="text" name="text" placeholder="내용을 입력하세요"></textarea>
					</div>
					<div class="form-group">
						<label for="testFile">파일 업로드</label>
						<input type="file" id="testFile" name="testFile">
					</div>
					<button type="submit" class="btn btn-default">제출</button>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<p class="text-right">
					<a class="btn btn-default" href="/list" role="button">글 목록</a> 
					<a class="btn btn-default" href="/logout" role="button">Logout</a>
				</p>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div> <!-- /container -->
	
	<script src="/resources/js/jquery-1.11.2.min.js"></script>
	<script src="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</body>
</html>
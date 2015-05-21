<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link href="/resources/img/favicon.gif" rel="icon" type="image/gif" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>CAVECAT::쓰기</title>
	
	<!-- Bootstrap core CSS -->
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/bootstrap-markdown-2.9.0/css/bootstrap-markdown.min.css" rel="stylesheet">
	<style type="text/css">body { padding-top: 70px; }</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">cavecat</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form action="/write" method="post" >
					<c:if test="${empty board }">
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" value="${board.title}">
						</div>
						<div class="form-group">
							<label for="text">내용</label>
							<textarea class="form-control" data-provide="markdown" rows="10" cols="30" id="text" name="text" placeholder="내용을 입력하세요">${board.text}</textarea>
						</div>
					</c:if>
					<s:hasBindErrors name="board" >
						<c:if test="${errors.hasFieldErrors('title') eq false}">
							<div class="form-group">
								<label for="title">제목</label>
								<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" value="${board.title}">
							</div>
						</c:if>
						<c:if test="${errors.hasFieldErrors('title')}">
							<div class="form-group has-success has-feedback">
								<label class="control-label" for="title">제목을 입력해주세요</label>
								<input type="text" class="form-control" id="title" name="title" aria-describedby="title" placeholder="제목을 입력하세요" value="${board.title}">
								<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
								<span id="title" class="sr-only">(success)</span>
							</div>
						</c:if>
						<c:if test="${errors.hasFieldErrors('text') eq false}">
							<div class="form-group">
								<label for="text">내용</label>
								<textarea class="form-control" data-provide="markdown" rows="10" cols="30" id="text" name="text" placeholder="내용을 입력하세요">${board.text}</textarea>
							</div>
						</c:if>
						<c:if test="${errors.hasFieldErrors('text')}">
							<div class="form-group has-success has-feedback">
								<label class="control-label" for="text">본문을 입력해주세요</label>
								<textarea class="form-control" data-provide="markdown" rows="10" cols="30" id="text" name="text" placeholder="내용을 입력하세요">${board.text}</textarea>
							</div>
						</c:if>
					</s:hasBindErrors>
					<button type="submit" class="btn btn-success pull-right">제출</button>
					<a class="btn btn-info pull-left" href="/list" role="button">글 목록</a>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div> <!-- /container -->
	
	<script src="/resources/js/jquery-1.11.2.min.js"></script>
	<script src="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
	<script src="/resources/bootstrap-markdown-2.9.0/js/markdown.js"></script>
	<script src="/resources/bootstrap-markdown-2.9.0/js/to-markdown.js"></script>
	<script src="/resources/bootstrap-markdown-2.9.0/js/bootstrap-markdown.js"></script>
	<script src="/resources/bootstrap-markdown-2.9.0/locale/bootstrap-markdown.kr.js"></script>
	<script type="text/javascript">
		$("#text").markdown({autofocus:true, language:'kr'})
	</script>
</body>
</html>
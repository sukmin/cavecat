<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link href="/resources/img/favicon.gif" rel="icon" type="image/gif" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>CAVECAT::읽기</title>
	
	<!-- Bootstrap core CSS -->
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
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
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">${board.title}</div>
					<div id="text" class="panel-body">${board.text}</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p class="text-right">
					<a class="btn btn-info" href="/" role="button">글 목록</a>
				</p>
			</div>
		</div>
	</div> <!-- /container -->
	
	<script src="/resources/js/jquery-1.11.2.min.js"></script>
	<script src="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
	<script src="/resources/bootstrap-markdown-2.9.0/js/markdown.js"></script>
	<script type="text/javascript">
		var mdHtml = markdown.toHTML($("#text").text());
		$("#text").html(mdHtml);
	</script>
</body>
</html>

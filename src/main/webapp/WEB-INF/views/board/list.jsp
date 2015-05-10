<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link href="/resources/img/favicon.gif" rel="icon" type="image/gif" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>CAVECAT::목록</title>
	
	<!-- Bootstrap core CSS -->
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body { padding-top: 70px; }
		table { text-align: center; }
		th { text-align: center; }
	</style>
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
				<table class="table table-striped table-bordered">
					<colgroup>
    					<col width="30">
    					<col width="*">
    					<col width="100">
    					<col width="150">
    					<col width="100">
  					</colgroup>
					<thead>
						<tr>
							<th>#</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<c:if test="${empty boards}">
						<tbody>
							<tr><td colspan="2" align="center">작성된 글이 없습니다.</td></tr>
						</tbody>
					</c:if>
					<c:if test="${not empty boards}">
						<tbody>
							<c:forEach items="${boards}" var="board">
							<tr>
								<td><c:out value="${board.sequence}"/></td>
								<td><a href="/${board.sequence}"><c:out value="${board.title}"/></a></td>
								<td><c:out value="${board.registor}"/></td>
								<td><fmt:formatDate value="${board.registeredDate}" pattern="yyyy-MM-dd"/>​</td>
								<td><c:out value="${board.readCount}"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p class="text-right">
					<a class="btn btn-success" href="/write" role="button">글쓰기</a>
				</p>
			</div>
		</div>
	</div> <!-- /container -->
	
	<script src="/resources/js/jquery-1.11.2.min.js"></script>
	<script src="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</body>
</html>

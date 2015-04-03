<%@ page session="true" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>글 목록</title>
	
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
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>제목</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lists }" var="item">
						<tr>
							<td><c:out value="${item['id']}"/></td>
							<td><a href="#"><c:out value="${item['title']}"/></a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p class="text-right">
					<a class="btn btn-default" href="/board" role="button">글쓰기</a>
					<a class="btn btn-default" href="/login?logout" role="button">Logout</a>
				</p>
			</div>
		</div>
	</div> <!-- /container -->
	
	<script src="/resources/js/jquery-1.11.2.min.js"></script>
	<script src="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</body>
</html>

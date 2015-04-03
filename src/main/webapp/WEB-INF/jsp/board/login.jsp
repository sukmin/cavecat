<%@ page session="true" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>로그인</title>
	
	<!-- Bootstrap core CSS -->
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="/resources/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body {
			padding-top: 40px;
			padding-bottom: 40px;
			background-color: #eee;
		}
		
		.form-signin {
			max-width: 350px;
			padding: 15px;
			margin: 0 auto;
		}
		.form-signin .form-signin-heading,
		.form-signin .checkbox {
			margin-bottom: 10px;
		}
		.form-signin .checkbox {
			font-weight: normal;
		}
		.form-signin .form-control {
			position: relative;
			height: auto;
			-webkit-box-sizing: border-box;
				 -moz-box-sizing: border-box;
							box-sizing: border-box;
			padding: 10px;
			font-size: 16px;
		}
		.form-signin .form-control:focus {
			z-index: 2;
		}
		.form-signin input[type="email"] {
			margin-bottom: -1px;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 0;
		}
		.form-signin input[type="password"] {
			margin-bottom: 10px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
		}
	</style>
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
		<form class="form-signin" action="/login" method="post">
			<h4 class="form-signin-heading">
				<c:if test="${not loginFailed}"><p>로그인이 필요합니다.</p></c:if>
				<c:if test="${loginFailed}"><p>로그인이 실패하였습니다.</p></c:if>
			</h4>
			<label for="inputID" class="sr-only">Email address</label>
			<input type="text" id="inputID" name="id" class="form-control" placeholder="ID" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="passwd" class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div> <!-- /container -->
	
	<script src="/resources/js/jquery-1.11.2.min.js"></script>
	<script src="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			margin-bottom: -1px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
		}
	</style>
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="/resources/bootstrap-3.3.4-dist/js/html5shiv.min.js"></script>
      <script src="/resources/bootstrap-3.3.4-dist/js/respond.min.js"></script>
    <![endif]-->
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
		<form class="form-signin" action="/signup" method="put" id="form_signup">
			<label for="inputID" class="sr-only">ID</label>
			<input type="text" id="inputID" name="id" class="form-control" placeholder="ID" required autofocus>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="text" id="inputEmail" name="email" class="form-control" placeholder="email" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="passwd" class="form-control" placeholder="Password" required>
			<label for="inputPassword2" class="sr-only">Password</label>
			<input type="password" id="inputPassword2" name="passwd2" class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-default btn-block" id="button_signup">Sign up</button>
		</form>
	</div> <!-- /container -->
	
	<script src="/resources/js/jquery-1.11.2.min.js"></script>
	<script src="/resources/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		jQuery("#button_signup").click(function(event){
			event.preventDefault();
			
			if(jQuery("#inputID").val() == ""){
				alert("ID는 필수입니다.");
				return false;
			}
			
			if(jQuery("#inputEmail").val() == ""){
				alert("email은 필수입니다.");
				return false;
			}
			
			if(jQuery("#inputPassword").val() == "" && jQuery("#inputPassword2").val() == ""){
				alert("password는 필수입니다.");
				return false;
			}
			
			if(jQuery("#inputPassword").val() != jQuery("#inputPassword2").val()){
				alert("password가 일치하지 않습니다.");
				return false;
			}
			
			jQuery("#form_signup").submit();
			
		});
	</script>
</body>
</html>

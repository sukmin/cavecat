<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<style type="text/css">
		a:link { text-decoration: none; }
		a:visited { text-decoration: none; }
		a:hover { text-decoration: underline; }
		a:active { text-decoration: underline; }
		
		table {
			width:100%;
			border-top:1px solid #e5eff8;
			border-right:1px solid #e5eff8;
			margin:1em auto;
			border-collapse:collapse;
		}
		thead th {
			background:#f4f9fe;
			text-align:center;
			font:bold 1.2em/2em;
			color:#66a3d3;
		}
		td {
			color:#678197;
			border-bottom:1px solid #e5eff8;
			border-left:1px solid #e5eff8;
			padding:.3em .2em;
			text-align:center;
		}
		.main { 
			width:100%;
			margin:1em auto;
			text-align: center; 
		}
		.board_main { 
			width:50%;
			margin:1em auto;
			text-align: right; 
		}
	</style>
	
	<title>글목록</title>
</head>
<body>
	<div class="main">
		<div class="board_main">
			<table>
				<thead>
					<tr>
						<th>글번호</th>
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
			<button type="button" onclick="(function(){location.href = '/board'; return false;})();" >글쓰기</button>
		</div>
	</div>
</body>
</html>
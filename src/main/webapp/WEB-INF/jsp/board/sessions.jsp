<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%!
	private static String toString(long timeInterval) {
		if (timeInterval < 1_000) {
			return "less than one second";
		}
		
		if (timeInterval < 60_000) {
			return (timeInterval / 1_000) + " seconds";
		}
		
		return "about " + (timeInterval / 60_000) + " minutes";
	}
%>

<%
	int numberOfSessions = (Integer) request.getAttribute("numberOfSessions");
	List<HttpSession> sessions = (List<HttpSession>) request.getAttribute("sessionList");
%>

<!doctype html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<title>sessions</title>
	</head>
	<body>
		<h2>Sessions</h2>
		<% 
			long timestamp = System.currentTimeMillis();
			for (HttpSession aSession : sessions ) {
				out.print(aSession.getId() + " - " + aSession.getAttribute("id"));
				
				if (aSession.getId().equals(session.getId())) {
					out.print(" (you)");
				}
				
				out.print(" - last active " + toString(timestamp - aSession.getLastAccessedTime()));
				out.println(" ago<br />");
			}
		%>
	
		<a href="<c:url value="/login?logout" />">Logout</a>
	</body>
</html>
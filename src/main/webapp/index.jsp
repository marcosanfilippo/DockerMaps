<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="java.util.Map.Entry"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="maps.interfaces.BusLine"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Docker :: Maps</title>
	<jsp:include page="partial/_headers.jsp" />
					
</head>
<body>

	<jsp:include page="partial/_navbar.jsp" />
	
	<%! @SuppressWarnings("unchecked") %>
	<%
		ConcurrentHashMap<String,BusLine> busLines = (ConcurrentHashMap<String,BusLine>) request.getServletContext().getAttribute("busLines");
	
		for(Entry<String,BusLine> e : busLines.entrySet())
		{
			%>
				<a href="maps.jsp?lineId=<%= e.getKey() %>"><%= e.getKey() %> : <%= e.getValue().getDescription() %></a><br>
			<%
		}
	%>
	
</body>
</html>

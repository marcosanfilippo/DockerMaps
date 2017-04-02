<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="maps.interfaces.BusLine"%>
<%@ page import="maps.interfaces.BusLineService"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<title>Docker :: Maps</title>
	<jsp:include page="partial/_headers.jsp" />
					
</head>
<body>

	<jsp:include page="partial/_navbar.jsp" />
	
	<%
		BusLineService busLineService = (BusLineService) request.getServletContext().getAttribute("busLineService");
		Map<String,BusLine> busLines = busLineService.getAll();
	
		for(Entry<String,BusLine> e : busLines.entrySet())
		{
			%>
				<a href="maps.jsp?lineId=<%= e.getKey() %>"><%= e.getKey() %> : <%= e.getValue().getDescription() %></a><br>
			<%
		}
	%>
	
</body>
</html>

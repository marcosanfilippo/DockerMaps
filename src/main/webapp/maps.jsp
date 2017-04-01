<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="maps.interfaces.BusStop"%>
<%@page import="maps.interfaces.BusLine"%>

<%
BusLine bl = null;
if ( request.getParameter("lineId") == null)
{
	response.sendRedirect("index.jsp");
}
else
{
	%>
	<%! @SuppressWarnings("unchecked") %>
	<%
	ConcurrentHashMap<String,BusLine> busLines = (ConcurrentHashMap<String,BusLine>) request.getServletContext().getAttribute("busLines");
	
	bl = busLines.get(request.getParameter("lineId"));
	if ( bl == null )
	{
		response.sendRedirect("index.jsp");
	}
	%>
	<% 
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
	<title>Docker :: Maps</title>
	<jsp:include page="partial/_headers.jsp" />
		
	<style type="text/css">
	html,body { height: 100%; }
	#mapid,.container { height: 100%; }
	
	</style>			
</head>
<body>

	<jsp:include page="partial/_navbar.jsp" />
	<div class="container">
		<div id="mapid"></div>
	</div>
	<script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
	<script type="text/javascript">
	var mymap = L.map('mapid').setView([51.505, -0.09], 13);

	//Layer OpenStreetMap
	L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
	}).addTo(mymap);

	//TODO: Fare in Query ajax 
	<%
	if ( bl != null )
	{
		%>
		latlngs=[];
		<%
		for(BusStop bs : bl.getBusStops())
		{
			String msg = "Fermata <b>"+bs.getName()+"</b><br>";
			for(BusLine bsl : bs.getBusLines())
			{
				msg += "Linea <b>"+bsl.getLine()+"</b> ("+bsl.getDescription()+")<br>";
			}
			%>
			L.marker([<%=bs.getLat()%> ,<%= bs.getLng()%> ]).addTo(mymap)
				.bindPopup('<%=msg%>');
			latlngs.push(L.latLng(<%=bs.getLat()%> ,<%= bs.getLng()%>));
			<%
		}
		%>
		var polyline = L.polyline(latlngs, {color: 'red'}).addTo(mymap);
		mymap.fitBounds(polyline.getBounds());
		<%
	}
	%>
	</script>
</body>
</html>

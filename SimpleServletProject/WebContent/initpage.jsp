<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%!
public void jspInit(){
	String defaultUser=getServletConfig().getInitParameter("defaultuser");
	ServletContext context=getServletContext();
	context.setAttribute("defaultuser", defaultUser);

}
%>
<body>

the default user fromthe servlet config is:<%=
getServletConfig().getInitParameter("defaultuser")
%>
the value in the servlet context is:
<%=getServletContext().getAttribute("defaultuser")
%>


</body>
</html>
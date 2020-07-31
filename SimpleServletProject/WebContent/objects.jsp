<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String userName=request.getParameter("name");

if(userName!=null){
	session.setAttribute("sessionUserName", userName);
	//application.setAttribute("ApplicationUserName", userName);
	pageContext.setAttribute("pageContexUserName", userName);
	pageContext.setAttribute("ApplicationUserName", userName, PageContext.APPLICATION_SCOPE);
	pageContext.findAttribute("name");
}

%>
<br>
the username in the request object is<%=userName %>
<br>
the username in the session object is<%=session.getAttribute("sessionUserName") %>
<br>
the username in the application object is<%=application.getAttribute("ApplicationUserName") %>
<br>
the username in the pagecontext object is<%=pageContext.getAttribute("pageContexUserName") %>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hiii jsp
<%!
public int add(int a,int b){
	return a+b;
}
%>
<%

int i=1;
int j=1;
int k;
k=i+j;

%>
value of k:<%=1+3 %>
<%
k=add(64646,687986);

%>
value of k:<%=k%>
<%
for(i=0;i<5;i++)
{
	%>the new value ofi=<%=i %>
<% }
%>
%>
</body>
</html>
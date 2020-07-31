<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

  pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> Home</title>

</head>

<body>



<center>

    <h1>Department Management</h1>

    <h3>

      <a href="/save">Add New Department</a>



    </h3>

  </center>

<div align="center" >

    <table border="1" cellpadding="5">

      <caption><h3>List of Department</h3></caption>

      <tr>

        <th>DeptId</th>

        <th>DeptName</th>
         <th>DeptEmail</th>

        <th> Action</th>



      </tr>

      <c:forEach var="dept" items="${departmentList}">

        <tr>

          <td><c:out value="${dept.deptId}" /></td>

          <td><c:out value="${dept.deptName}" /></td>
            <td><c:out value="${dept.deptEmail}" /></td>

          <td>

            <a href="/edit?id=<c:out value='${dept.deptId}' />">Edit</a>

            &nbsp;&nbsp;&nbsp;&nbsp;

            <a href="/delete?id=<c:out value='${dept.deptId}' />">Delete</a>

          </td>

        </tr>

      </c:forEach>

    </table>

  </div>

</body>

</html>
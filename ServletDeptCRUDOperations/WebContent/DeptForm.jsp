<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>Department Application</title>
</head>
<body>
    <center>
        <h1>Department Management</h1>
        <h2>
            <a href="/new">Add New Department</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All department</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${department != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${department == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${department != null}">
                        Edit department
                    </c:if>
                    <c:if test="${department == null}">
                        Add New department
                    </c:if>
                </h2>
            </caption>
                <c:if test="${department != null}">
                    <input type="hidden" name="id" value="<c:out value='${department.deptId}' />" />
                </c:if>       
                <tr>
                <th>Department Id :</th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${Department.deptId}' />"
                        />
                </td>
            </tr>    
            <tr>
                <th>Department Name :</th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${Department.deptName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Department Email: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${Department.deptEmail}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>

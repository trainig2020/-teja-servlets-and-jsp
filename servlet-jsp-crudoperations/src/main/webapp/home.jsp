<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>

<title>Department Application</title>
 
<style type="text/css">
    body{
        text-align: center;
    }
    table {
        margin-left: 15%;
        min-width: 70%;
        border: 1px solid #CCC;
        border-collapse: collapse;
    }
    table tr{line-height: 30px;}
    table tr th { background: #000033; color: #FFF;}
    table tr td { border:1px solid #CCC; margin: 5px;}
    input[type=text], input[type=email], input[type=tel]{
        min-width: 60%;
    }
    input[type=submit], a{
        background: green;
        padding: 5px;
        margin: 5px;
        color: #FFF;
    }
    a{
        text-decoration: none;
    }
</style>
</head>
<body>


     <h1>Department Application</h1>
    
   <c:url value="/department/register" var="registerUrl" />
    <form action="${registerUrl}" method="post">
	        <table>
			<c:if test="${department.id ne null}">
				<tr>
					<td>Dept ID:</td>
					<td><input type="text" name="id" value="${department.id}"
						readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
                <td>Dept Name:</td>
                <td><input type="text" name="deptName" value="${department.deptName}" required></td>
            </tr>
            <tr>
               
                <td>Dept Email:</td>
                <td><input type="email" name="deptEmail" value="${department.deptEmail}" required></td>
            </tr>
            
            
            <c:if test="${department.id ne null}">
                <tr>
                    <td colspan="2"><input type="submit" value="Update"></td>
                </tr>
            </c:if>
            <c:if test="${department.id eq null}">
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </c:if>
            
        </table>
    </form>
    <br>
    <h1>List of Departments</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Dept Name</th>
            
            <th>Dept Email</th>
            
            <th>Update</th>
            <th>Delete</th>
        </tr>
         <c:forEach items="${departmentList}" var="department">
            <tr>
                <td>${department.id}</td>
                <td>${department.deptName}</td>
                <td>${department.deptEmail}</td>
                
                <td>
                    <form action=${"http://localhost:8080/ServletDeptCRUDOperations/department/update"} method="post">
                        <input type="hidden" name="deptId" value="${department.id}">
                        <input type="submit" value="Update">
                    </form>
                <td>
                    <form action=${"http://localhost:8080/ServletDeptCRUDOperations/department/delete"} method="post">
                       <input type="hidden" name="deptId" value="${department.id}">
                        <input style="background: #F00;" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html> 
<%@page import="java.util.List"%>
<%@page import="dto.Students"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Students student=(Students)request.getAttribute("student"); 
List<Students>list=(List<Students>)request.getAttribute("list");%>

<%--<%student --%>
<%--<%list --%>

<br>
<div>
<table border=1>
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th>Email</th>
<th>Password</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<tr>
<th><%=student.getId() %></th>
<th><%=student.getName() %></th>
<th><%=student.getMobile() %></th>
<th><%=student.getEmail() %></th>
<th><%=student.getPassword() %></th>
<th><a href="Edit.jsp?id=<%=student.getId() %>"><button>Edit</button></a></th>
<th><a href="delete?id=<%=student.getId()%>"><button>Delete</button></a></th>
</table>
</div>
</body>
</html>
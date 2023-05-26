<%@page import="dto.Students"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("id")); %>


<% StudentDao dao=new StudentDao();
  Students student=dao.fetch(id);
%>
<form action="update" method="post">
id:<input type="text" name="id" value="<%=student.getId()%>">
Name:<input type="text" name="name" value="<%=student.getName()%>">
Mobile:<input type="number" name="mobile" value="<%=student.getMobile()%>">
Password:<input type="password" name="password" value="<%=student.getPassword()%>">
Email:<input type="text" name="id" value="<%=student.getId()%>">
<button type="reset">Cancel</button><button type="update">Update</button>
</form>
</body>
</html>
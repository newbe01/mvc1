<%@ page import="mvc1.servlet.basic.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
success
<ul>
<%--  <li> id = <%=((Member)request.getAttribute("member")).getId() %></li>--%>
<%--  <li> username = <%=((Member)request.getAttribute("member")).getUsername() %></li>--%>
<%--  <li> age = <%=((Member)request.getAttribute("member")).getAge() %></li>--%>
  <li> id = ${member.id}</li>
  <li> username = ${member.username} </li>
  <li> age = ${member.age}</li>
</ul>
<a href="/index.html"> main </a>
</body>
</html>

<%@ page import="mvc1.servlet.basic.domain.member.Member" %>
<%@ page import="mvc1.servlet.basic.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("save.jsp");

  //request, response 사용 가능
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
success
<ul>
  <li> id = <%=member.getId() %></li>
  <li> username = <%=member.getUsername() %></li>
  <li> age = <%=member.getAge() %></li>
</ul>
<a href="/index.html"> main </a>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="save" method="post"> <!-- 상대경로, 현재 url 계층경로 + /save-->
    username : <input type="text" name="username" />
    age : <input type="number" name="age">
    <button type="submit"> submit </button>
</form>
</body>
</html>

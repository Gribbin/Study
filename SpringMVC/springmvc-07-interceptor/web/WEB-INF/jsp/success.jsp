<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>登录成功页面</h1>
<hr>

${user}
<h1><a href="${pageContext.request.contextPath}/user/logout">注销</a></h1>
</body>
</html>

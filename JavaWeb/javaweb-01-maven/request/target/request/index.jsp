<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>登录</h1>

<div style="text-align: left ">
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名:<input type="username" name="username"><br>
        密码:<input type="password" name="password"><br>
        爱好:
        <input type="checkbox" name="hobbies" value="b">b
        <input type="checkbox" name="hobbies" value="c">c
        <input type="checkbox" name="hobbies" value="r">r
        <input type="checkbox" name="hobbies" value="z">z
        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>

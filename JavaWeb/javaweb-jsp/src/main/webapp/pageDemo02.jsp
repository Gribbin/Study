<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scope</title>
</head>
<body>
<%
    //这里注释必须用Java格式，代码语法与Java一致
    String name1 = (String) pageContext.getAttribute("name1");
    String name2 = (String) pageContext.getAttribute("name2");
    String name3 = (String) pageContext.getAttribute("name3");
    String name4 = (String) pageContext.getAttribute("name4");
    String name5 = (String) pageContext.getAttribute("name5");
%>
<%--el表达式取值--%>
<h1>取出的值：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<%--el表达式null不输出，=方式输出null--%>
<h3><%=name5%></h3>
</body>
</html>

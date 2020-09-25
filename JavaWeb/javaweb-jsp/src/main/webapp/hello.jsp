<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<%
    Date date = new Date();
    for (int i = 0; i < 5; i++) {
%>
<h2>现在时间：</h2>
<%
        out.println(date);
    }
%>
</body>
</html>

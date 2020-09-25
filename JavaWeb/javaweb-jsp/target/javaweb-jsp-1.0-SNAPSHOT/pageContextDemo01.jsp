<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext</title>
</head>
<body>
<%
    pageContext.setAttribute("name1", "大秦1");//保存的数据只在一个页面中有效
    request.setAttribute("name2", "大秦2");//保存的数据只在一次请求中有效，请求转发会携带这个数据
    session.setAttribute("name3", "大秦3");//保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4", "大秦4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>
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

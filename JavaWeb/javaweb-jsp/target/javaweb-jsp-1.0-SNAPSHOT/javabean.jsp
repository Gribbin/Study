<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="person" class="com.gribbin.pojo.Person" scope="page"/>

<jsp:setProperty name="person" property="id" value="1"/>
<jsp:setProperty name="person" property="name" value="daqin"/>
<jsp:setProperty name="person" property="age" value="20"/>
<jsp:setProperty name="person" property="address" value="caolu"/>

编号：<jsp:getProperty name="person" property="id"/>
姓名：<jsp:getProperty name="person" property="name"/>
年龄：<jsp:getProperty name="person" property="age"/>
地址：<jsp:getProperty name="person" property="address"/>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/17
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>$Title$</title>
</head>
<body>
<a href="findAll.do">查询组织的所有信息</a>
<a href="updata.jsp">更新组织信息</a>
<form action="insert.do"  method="post">
  请输入组织名字<input type="text" name="username"><br>
  请输入地址<input type="text" name="address"><br>
  请输入组织人员<input type="text" name="man"><br>
  请输入更新id<input type="text" name="id"><br>
  <input type="submit" value="增加">
</form>
</body>
</html>

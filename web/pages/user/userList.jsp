<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/23
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<button type="botton" onclick="addUser">添加</button>
<table>
    <tr>
        <td>序号</td>
        <td>用户ID</td>
        <td>姓名</td>
        <td>性别</td>
        <td>角色名称</td>
        <td>操作</td>
    </tr>
<c:forEach items="${userList}" var="l" varStatus="vs">
    <tr>
    <td>${vs.index+1}</td>
    <td>${l.userId}</td>
    <td>${l.userName}</td>
    <td>${l.gender ==1 ? '男':'女'}</td>
    <td>${l.roleName}</td>
    <td>
        <button type="button" onclick="editUser();">编辑</button>
        <button type="button" onclick="deleteUser();">删除</button>
    </td>

</tr>
</c:forEach>
</table>
</body>
</html>
<script>
    function addUser() {

    }

    function  editUser() {

    }

    function deleteUser() {

    }
</script>
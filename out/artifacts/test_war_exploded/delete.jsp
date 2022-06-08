<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/24
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>//这个C标签是需要导入c.tld文件的
<html>
<head>
    <title>国家级自贸网站</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">

        function delCop(id) {


            $.ajax({
                url: "/delInfo.do",
                data: {"id": id},
                dataType: "json",
                type: "POST",
                success: function (res) {
                    alert("删除成功")
                },
                error: function () {
                    alert("删除成功")
                }


            })
        }

    </script>
</head>
<body>
<table>
    <tr>
        <th>组织名称</th>
        <th>地址</th>
        <th>组织管理人员</th>
        <th>组织id</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="find">
        <tr>
            <td>${find.username}</td>
            <td>${find.address}</td>
            <td>${find.man}</td>
            <td>${find.id}</td>
            <td><input type="button" value="删除" onclick="delCop(${find.id})"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

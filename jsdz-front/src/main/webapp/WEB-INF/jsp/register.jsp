<%--
  User: Air
  Date: 2017-08-29
  Time: 13:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>
                ${buyer.password}
                <br/>
                ${buyer.username}
                ${sessionScope.buyer.username}
            </td>
        </tr>
    </table>
</body>
</html>

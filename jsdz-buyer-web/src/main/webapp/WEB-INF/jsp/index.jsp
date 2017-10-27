<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>This is Title</title>
</head>
<body>
    <form id="picForm" action="/buyer/findMyOrder" method="post" enctype="multipart/form-data">
        <%--typeId:<input type="text" name="typeId" value="10"/><br/>
        厚度:<input type="text" name="thickId" value="10"/><br/>
        省:<input type="text" name="province" value="10"/><br/>
        市:<input type="text" name="city" value="10"/><br/>
        区:<input type="text" name="district" value="10"/><br/>
        图片:<input type="file" name="file"/><br/>--%>
        手机号:<input type="text" name="phone" value="1"/><br/>
        N:<input type="text" name="pageNum" value="1"/><br/>
        S:<input type="text" name="pageSize" value="2"/><br/>
        <button id="cln" type="submit">提交</button>
    </form>
</body>
</html>

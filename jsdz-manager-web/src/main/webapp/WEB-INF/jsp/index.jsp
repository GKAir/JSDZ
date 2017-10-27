<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head lang="en">
  <meta charset="UTF-8">
  <title>登录界面</title>
  <script src="js/jquery-1.11.1.js"></script>
  <script type="text/javascript" src="js/login.js"></script>
  </head>
  <body>
    <div>
        <form action="/buyer/login" method="post">
            <div>
                <div>
                    <label>用户名:</label>
                    <input type="text" name="username" />
                </div>
            </div>
            <div>
                <label>密码：</label>
                <input type="password" name="password" value="${}"/>
            </div>
            <div>
                <label>认证：</label>
                <input type="text" name="isVip" />
            </div>
            <div>
                <span></span>
                <input type="submit" id="loginform_submit" value="登录" />
            </div>
        </form>
    </div>
    <div>
        <script type="application/javascript">
            $.post("/manager/findAll",function(result){
                console.log(result);
                var result = JSON.parse(result);
                alert(result);
            });
        </script>
    </div>
 </body>
 </html>
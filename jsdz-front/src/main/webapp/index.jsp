<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<body>
<h2>Hello World!</h2>

message:${requestScope}
<br/>
session:${sessionScope}
${paramValues}

<fieldset class="login">
    <legend>极速定制</legend>
    <p><span>用户注册</span></p>
    <input type="text" name="" placeholder="请输入手机号" id="name"><br>
    <input type="password" name="" placeholder="请输入密码，长度6-16位（请勿用空格）" id="password"><br>
    <input type="password" name="" placeholder="请再次输入密码" id="rePassword"><br>
    <input type="text" name="" placeholder="请输入验证码" class="check">
    <div class="random"></div> <img src="image/u200.png" class="flush">
    <input type="button" name="" class="button" value="注册"><br>
    <a href="login.html" class="foot-left">登录</a>
    <a href="/front/login/1" class="foot-right">返回首页</a>
    <a href="/front/register/1" class="foot-right">返回首页</a>
</fieldset>

<script type="text/javascript">
    $(document).ready(function(){
        // 界面随机数的获取
        var random = getRandom();
        $(".random").html(random);
        $(".flush").click(function(){
            random = getRandom();
            $(".random").html(random);
        })
        //登录的验证
        $("#name").change(function(){
            if(!(/^1[34578]\d{9}$/.test($("#name").val()))){
                alert("请用手机号码注册");
                return false;
            }
        })
        $("#password").change(function(){
            if ($("#password").val().length<6||$("#password").val().length>16) {
                alert("密码长度为6-16位字符");
                return;
            }
            if(/\s/.test($("#password").val())){
                alert("密码中存有空格，请删去");
            }
        })
        $("#rePassword").change(function(){
            if ($("#password").val() !== $("#rePassword").val()) {
                alert("两次输入的密码不一致");
            }

        })
        $(".check").change(function(){
            if (random !== $(".check").val()) {
                alert("验证码错误请重试");
            }
        })
        $(".button").click(function(){
            if ($("#name").val() =="") {
                alert("请输入您的用户名");
                // showMessageNote("请输入您的用户名");
                return;
            }else if ($("#name").val() !=""&&$("#password").val() =="") {
                alert("请输入您的密码");
                return;
            }else if ($("#password").val().length<6||$("#password").val().length>20) {
                alert("密码长度为6-16位字符");
                return;
            }else if ($("#password").val() !== $("#rePassword").val()) {
                alert("两次输入的密码不一致");
                return;
            }else if (random !== $(".check").val()) {
                alert("验证码错误请重试");
                return;
            }else if (/\s/.test($("#password").val())){
                alert("密码中存有空格，请删去");
                return;
            }else if(!(/^1[34578]\d{9}$/.test($("#name").val()))){
                alert("请用手机号码注册");
                return;
            }
            console.log($("#name").val());
            console.log($("#password").val());
             $.post("/front/login/1",function(result){
             	     console.log(result)
               	var result = JSON.parse(result);
               	if (result.code == 0) {
               		var bb = $("#name").val();
               		localStorage.currentName=$("#name").val();
               		setTimeout(function(){
               			window.location.href="liangcang.html"	;
               		}, 1000);
               		alert("用户登录成功");
               	}else if(result.code == 2003){
               		alert("用户名不存在");
               	}else if(result.code == 1000){
               		alert("输入的用户名错误");
               	}else if(result.code == 1001){
               		alert("输入的密码错误");
               	}
                });
        });
        function getRandom(){
            str = '';
            for (var i =0; i <5; i++) {
                str +=Math.floor(10*Math.random());
            }
            return str;
        }
    })
</script>

</body>
</html>

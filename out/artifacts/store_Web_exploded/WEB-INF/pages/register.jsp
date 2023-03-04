<%--
  Created by IntelliJ IDEA.
  User: DELL、
  Date: 2023/2/17
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
    <style>
        #d1 {
            margin-left: 25%;
            margin-right: 20%;
            margin-top: 100px;
            padding: 0px;
        }

        .layui-input {
            width: 350px;
        }

        .layui-form-label {
            width: 200px;
        }

        .layui-form {
            padding: 0px;
        }
        .layui-word-aux{
            color: red;
        }
    </style>
</head>
<div id="d1">
    <form id="form" class="layui-form" action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="_method" value="put">
        <div class="layui-form-item">
            <label class="layui-form-label" id="nameLabel">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" placeholder="请输入标题" autocomplete="off"
                       class="layui-input">
            </div>
            <span class="layui-form-mid layui-word-aux" id="name"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="0" title="男">
                <input type="radio" name="sex" value="1" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" id="usernameLabel">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" placeholder="请输入标题" autocomplete="off"
                       class="layui-input">
            </div>
            <span class="layui-form-mid layui-word-aux" id="username"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" id="userPassLabel">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="userPass" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
            <span class="layui-form-mid layui-word-aux" id="userPass"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" id="rePassLabel">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" name="rePass" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
            <span class="layui-form-mid layui-word-aux" id="rePass"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" id="phoneLabel">电子邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="phone" placeholder="请输入标题" autocomplete="off"
                       class="layui-input">
            </div>
            <span class="layui-form-mid layui-word-aux" id="phone"></span>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" id="codeLabel">验证码</label>
            <div class="layui-input-inline">
                <input type="text" name="code" placeholder="请输入标题" autocomplete="off"
                       class="layui-input">
            </div>
            <span class="layui-form-mid layui-word-aux" id="code"></span>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" style="margin-left: 30%">
                <button class="layui-btn" lay-submit lay-filter="formDemo">注册</button>
                <button type="reset" class="layui-btn layui-btn-primary" style="margin-left: 100px">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="../../static/layui/layui.all.js"></script>
<script>
    const layer = layui.layer;
    const form = layui.form;
    const $ = layui.$;

    window.onload = function () {
        document.getElementById("form").onsubmit = function () {
            return checkInputs();
        }
    }

    function checkInputs() {
        let name = $("[name='name']").val();
        let username = $("[name='username']").val();
        let userPass = $("[name='userPass']").val();
        let rePass = $("[name='rePass']").val();
        let phone = $("[name='phone']").val();
        let code = $("[name='code']").val();
        let flag = true;
        if (name === '') {
            $('#name').text($('#nameLabel').text() + "不能为空");
            flag = false;
        } else {
            $('#name').text('');
        }
        if (username === '') {
            $('#username').text($('#usernameLabel').text() + "不能为空");
            flag = false;
        } else {
            $('#username').text('');
        }
        if (userPass === '') {
            $('#userPass').text($('#userPassLabel').text() + "不能为空");
            flag = false;
        } else {
            $('#userPass').text('');
        }
        if (rePass != userPass) {
            $('#rePass').text('两次密码不一致');
            flag = false;
        } else {
            $('#rePass').text('');
        }
        if (phone === '') {
            $('#phone').text($('#phoneLabel').text() + "不能为空");
            flag = false;
        } else {
            $('#phone').text('');
        }
        if (code === '') {
            $('#code').text($('#codeLabel').text() + "不能为空");
            flag = false;
        } else {
            $('#code').text('');
        }
        return flag;
    }

</script>
</body>
</html>

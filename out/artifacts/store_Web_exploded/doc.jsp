<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>项目文档</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">用户接口</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" _url='doc/user/adduser.jsp'>新增用户</a></dd>
                            <dd><a href="javascript:;" _url='doc/user/deleteuser.jsp'>删除用户</a></dd>
                            <dd><a href="javascript:;" _url='doc/user/edituser.jsp'>修改用户</a></dd>
                            <dd><a href="javascript:;" _url='doc/user/getuser.jsp'>查询用户</a></dd>
                            <dd><a href="javascript:;" _url='doc/user/getuserlist.jsp'>模糊查询或获取全部用户</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">商品接口</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" _url='doc/product/addproduct.jsp'>新增产品</a></dd>
                            <dd><a href="javascript:;" _url='doc/product/deleteproduct.jsp'>删除商品</a></dd>
                            <dd><a href="javascript:;" _url='doc/product/editproduct.jsp'>修改商品</a></dd>
                            <dd><a href="javascript:;" _url='doc/product/getproduct.jsp'>查询商品</a></dd>
                            <dd><a href="javascript:;" _url='doc/product/getproductlist.jsp'>模糊查询或获取全部商品</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">商品分类接口</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" _url='doc/productkind/addproductkind.jsp'>新增产品分类</a></dd>
                            <dd><a href="javascript:;" _url='doc/productkind/deleteproductkind.jsp'>删除商品分类</a></dd>
                            <dd><a href="javascript:;" _url='doc/productkind/editproductkind.jsp'>修改商品分类</a></dd>
                            <dd><a href="javascript:;" _url='doc/productkind/getproductkind.jsp'>查询商品分类</a></dd>
                            <dd><a href="javascript:;" _url='doc/productkind/getproductlistkind.jsp'>模糊查询或获取全部商品分类</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">menu group 2</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;">list 1</a></dd>
                            <dd><a href="javascript:;">list 2</a></dd>
                            <dd><a href="">超链接</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="javascript:;">click menu item</a></li>
                    <li class="layui-nav-item"><a href="">the links</a></li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
            <iframe id="main" style="height:99%;width:100%;border:none"></iframe>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            底部固定区域
        </div>
    </div>
    <script src="static/layui/layui.js"></script>
    <script>
        //JS
        layui.use(['element', 'layer', 'util'], function () {
            var element = layui.element
                , layer = layui.layer
                , util = layui.util
                , $ = layui.$;

            $("[_url]").click(function () {
                var url = $(this).attr("_url");
                $("#main").attr("src", url);
            });

            //头部事件
            util.event('lay-header-event', {
                //左侧菜单事件
                menuLeft: function (othis) {
                    layer.msg('展开左侧菜单的操作', {icon: 0});
                }
                , menuRight: function () {
                    layer.open({
                        type: 1
                        , content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                        , area: ['260px', '100%']
                        , offset: 'rt' //右上角
                        , anim: 5
                        , shadeClose: true
                    });
                }
            });

        });
    </script>
</body>
</html>
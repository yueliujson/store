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
    <title>新增用户</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
</head>
<body>
<blockquote class="layui-elem-quote">新增用户</blockquote>
<div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
        <input type="text" name="url" readonly class="layui-input" value="<%=basePath%>productImg">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">请求方式</label>
    <div class="layui-input-block">
        <input type="text" name="method" readonly class="layui-input" value="post">
    </div>
</div>

<button type="button" class="layui-btn" id="test1" style="margin-left: 10%">
    <i class="layui-icon">&#xe67c;</i>上传图片
</button>
<%--<div class="layui-form-item">
    <label class="layui-form-label">相册</label>
    <div class="layui-form-mid layui-word-aux" style="padding-top:0px ">
        <button type="button" class="layui-btn layui-btn-small layui-btn-normal photosload" lay-data="{data:{type:'image'},accept:'images'}" data-name="photos">
            <i class="layui-icon"></i>上传相册
        </button>
    </div>
</div>
<div class="layui-form-item">
    <div name="photos" id="PhotosDom"></div>
    <textarea name="img_jietu" placeholder="请输入文章描述" autocomplete="off" class="layui-textarea" style="width:300px "></textarea>
</div>--%>
<div id="addForm" class="layui-form" lay-filter="addForm">
    <div class="layui-form-item">
        <label class="layui-form-label">参数</label>
        图片地址：<input name="imgUrl" style="height:20px;width: 500px" class="layui-input-block" readonly/><br/>
        <label style="margin-left: 20%">产品id</label><input name="product_id" style="height:20px" class="layui-input-block"/><br/>
        <label style="margin-left: 20%">排序序号</label><input name="sort" style="height:20px" class="layui-input-block"/>
    </div>
</div>
<div style='text-align:center; '>
    <button type="button" id='testbtn' class="layui-btn">测试</button>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">结果</label>
    <div class="layui-input-block">
      <textarea name="result" style="height:200px" class="layui-textarea" readonly>
            {"code":202,"message":"success",
          "data":{}
      </textarea>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">代码实例</label>
    <div class="layui-input-block">
      	<textarea name="testcode" style="height:200px" class="layui-textarea" readonly>
                 var $ = layui.$;
                var upload = layui.upload;
                var form=layui.form;
                layui.use('upload', function () {
                    //执行实例
                    var uploadInst = upload.render({
                        elem: '#test1' //绑定元素
                        , url: '/productImg/img'//上传接口
                        , accept: 'images'
                        , done: function (res) {
                            //上传完毕回调
                            $("[name='imgUrl']").val(res.data.data);
                        }
                        , error: function () {
                            //请求异常回调
                        }
                    });
                });
                $("#testbtn").click(function () {
                    var formData = form.val('addForm');
                    console.log(formData);
                    $.ajax({
                        type: 'post',
                        url: $("[name='url']").val(),
                        data: JSON.stringify(formData),
                        contentType: "application/json;charset=UTF-8",
                        success: function (result) {
                            result = JSON.stringify(result);
                            $("[name='result']").text(result);
                        }
                    });
                });

		</textarea>
    </div>
</div>
<script src="static/layui/layui.all.js"></script>
<script>
    var $ = layui.$;
    var upload = layui.upload;
    var form = layui.form;
    layui.use('upload', function () {
        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            , url: '/productImg/img'//上传接口
            , accept: 'images'
            , done: function (res) {
                //上传完毕回调
                $("[name='imgUrl']").val(res.data.data);
            }
            , error: function () {
                //请求异常回调
            }
        });
    });
    /*upload.render({
        elem: '.photosload' //绑定元素
        , url: "{:Url('/productImg/img',array('other'=>'newinfo'))}" //上传接口
        , multiple: true  //多文件上传
        , before: function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            //console.log(obj);
            layer.load(); //上传loading
        }
        , done: function (res, index) {
            layer.closeAll('loading');
            if (res.status == '1') {
                var item = this.item;
                $("textarea[name='img_jietu']").append(res.path + '\r\n');
                var html = '<img src="' + res.path + '" class="content-photos" />';
                $("#PhotosDom").append(html);
            } else {
                alert("上传失败,请重试！");
            }
        }
        , error: function () {
            layer.closeAll('loading');
            alert("上传失败,请重试！");
            //请求异常回调
        }
        , field: 'file' //字段名
    });*/
    $("#testbtn").click(function () {
        var formData = form.val('addForm');
        console.log(formData);
        $.ajax({
            type: 'post',
            url: $("[name='url']").val(),
            data: JSON.stringify(formData),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
                result = JSON.stringify(result);
                $("[name='result']").text(result);
            }
        });
    });


</script>
<script src="static/layui/layui.all.js"></script>
</body>
</html>
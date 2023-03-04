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
    <title>修改用户</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
</head>
<body>
<blockquote class="layui-elem-quote">模糊查询</blockquote>
<div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
        <input type="text" name="url" readonly class="layui-input" value="<%=basePath%>user">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">请求方式</label>
    <div class="layui-input-block">
        <input type="text" name="method" readonly class="layui-input" value="get">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">参数</label>
    <div class="layui-input-block">
      <textarea name="params" style="height:200px" class="layui-textarea">
      {
          "name":"王",
          "sex":0
      }
      </textarea>
    </div>
</div>

<div style='text-align:center;'>
    <button type="button" id='testbtn' class="layui-btn">测试</button>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">结果</label>
    <div class="layui-input-block">
      <textarea name="result" style="height:200px" class="layui-textarea" readonly>
            {"code":200,"message":"success",
          "data":{"data":[{"user_id":3,"name":"王老五","sex":0,"phone":"1231123","username":"wanglaowu","userpass":"a5f0bfc268b3c6266bf9e39e6958ed1a2","state":0,"isDel":1,"createTime":"2023-03-02T11:36:24.000+00:00","lastLoginTime":null},{"user_id":4,"name":"王老五","sex":0,"phone":"123123123","username":"wanglao","userpass":"a5f0bfc268b3c6266bf9e39e6958ed1a2","state":0,"isDel":1,"createTime":"2023-03-02T11:55:44.000+00:00","lastLoginTime":null}]}}
      </textarea>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">代码实例</label>
    <div class="layui-input-block">
      	<textarea name="testcode" style="height:200px" class="layui-textarea" readonly>
            var formdata={"name":zhangsan,"sex":0}
            $("#testbtn").click(function () {
                let user_id = JSON.parse(formdata).user_id;
                $.ajax({
                    url: $("[name='url']").val()+"/"+user_id,
                    data: {},
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

    $("#testbtn").click(function () {
        var formdata = $("[name='params']").val();
        formdata = JSON.parse(formdata);
        $.ajax({
            url: $("[name='url']").val(),
            data: formdata,
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
                result = JSON.stringify(result);
                $("[name='result']").text(result);
            }
        });
    });


</script>
</body>
</html>
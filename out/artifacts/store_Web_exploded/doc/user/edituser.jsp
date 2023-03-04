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
<blockquote class="layui-elem-quote">新增用户</blockquote>
<div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
        <input type="text" name="url" readonly class="layui-input" value="<%=basePath%>user">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">请求方式</label>
    <div class="layui-input-block">
        <input type="text" name="method" readonly class="layui-input" value="post">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">参数</label>
    <div class="layui-input-block">
      <textarea name="params" style="height:200px" class="layui-textarea">
      {
        "user_id":1,
      	"name":"王老五",
      	"sex":0,
      	"phone":"123123123"
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
{"code":200,"message":"success","data":{}}
      </textarea>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">代码实例</label>
    <div class="layui-input-block">
      	<textarea name="testcode" style="height:200px" class="layui-textarea" readonly>
		var formdata={username:'wanglaowu',userpass:'123',name:'王老五',sex:0,phone="123123123"};
		$.ajax({
			type:'post',
			url:'user?_method=put',
			data:JSON.stringify(formdata),
			contentType: "application/json;charset=UTF-8",
			success:function(result){
				result=JSON.stringify(result);
				$("#resultbox").text(result);
			}
		});
		</textarea>
    </div>
</div>

<script src="static/layui/layui.all.js"></script>
<script>
    var $ = layui.$;

    $("#testbtn").click(function () {
        var formdata = $("[name='params']").val();
        console.log(formdata);
        $.ajax({
            type: 'post',
            url: $("[name='url']").val()+"?_method=put",
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
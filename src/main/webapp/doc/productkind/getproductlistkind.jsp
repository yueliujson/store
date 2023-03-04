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
    <title>获取产品种类</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
</head>
<body>
<blockquote class="layui-elem-quote">模糊查询（产品名称）获取产品种类</blockquote>
<div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
        <input type="text" name="url" readonly class="layui-input" value="<%=basePath%>productKind">
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
          "name":"老"
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
           {"code":200,"message":"success","data":{"data":[{"product_id":null,"name":"老八秘制小汉堡","price":10,"old_price":20,"info":"好吃的","count":50,"type_id":1,"state":0,"isDel":1,"createTime":"2023-03-03T00:56:13.000+00:00","creator":"刘哲","lastEditTime":"2023-03-03T01:14:04.000+00:00","productImg":[]},{"product_id":null,"name":"老八秘制小汉堡","price":10,"old_price":20,"info":"好吃的苹果","count":500,"type_id":1,"state":0,"isDel":0,"createTime":"2023-03-03T00:58:06.000+00:00","creator":"刘哲","lastEditTime":"2023-03-03T00:58:06.000+00:00","productImg":[]},{"product_id":null,"name":"老八秘制小汉堡","price":99,"old_price":20,"info":"好吃的苹果","count":500,"type_id":1,"state":0,"isDel":0,"createTime":"2023-03-03T00:58:09.000+00:00","creator":"刘哲","lastEditTime":"2023-03-03T00:58:09.000+00:00","productImg":[]}]}}
      </textarea>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">代码实例</label>
    <div class="layui-input-block">
      	<textarea name="testcode" style="height:200px" class="layui-textarea" readonly>
            var formdata={"name":zhangsan}
            $("#testbtn").click(function () {
                let user_id = JSON.parse(formdata).product_id;
                $.ajax({
                    url: product,
                    data: formdata,
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
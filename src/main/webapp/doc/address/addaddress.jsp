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
<blockquote class="layui-elem-quote">新增收货地址</blockquote>
<div class="layui-form-item">
    <label class="layui-form-label">地址</label>
    <div class="layui-input-block">
        <input type="text" name="url" readonly class="layui-input" value="<%=basePath%>address">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">请求方式</label>
    <div class="layui-input-block">
        <input type="text" name="method" readonly class="layui-input" value="post">
    </div>
</div>
<div id="addForm" class="layui-form" lay-filter="addForm">
    <div class="layui-form-item">
        <label class="layui-form-label">参数</label>
        <div class="layui-input-inline">
            <label for="province">province</label><select class="layui-select" lay-verify="required" id="province" name="province" changedom="#city" style="width: 200px"></select>
        </div>
        <div class="layui-input-inline">
            <label for="city">city</label><select class="layui-select" id="city" lay-verify="required" name="city" changedom="#area" style="width: 200px"></select>
        </div>
        <div class="layui-input-block">
            <label for="area">area</label><select class="layui-select" id="area" lay-verify="required" name="area" style="width: 200px"></select>
        </div>
        <br>
        <div class="layui-input-inline">
            <label style="margin-left: 200px" for="address">address</label><input id="address" name="address" class="layui-input-block">
        </div>
        <div class="layui-input-inline">
            <label style="margin-left: 200px" for="phone">phone</label><input id="phone" name="phone" class="layui-input-block">
        </div>
        <div class="layui-input-inline">
            <label style="margin-left: 200px" for="receiver">receiver</label><input id="receiver" name="receiver" class="layui-input-block">
        </div>
    </div>
</div>
<div style='text-align:center;'>
    <button type="button" id='testbtn' class="layui-btn">测试</button>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">结果</label>
    <div class="layui-input-block">
      <textarea name="result" style="height:200px" class="layui-textarea" readonly>
            {"code":202,"message":"fail",
          "data":{"data":{"user_id":null,"name":"王老五","sex":0,"phone":"123123123","username":"wanglaowu","userpass":"123","state":null,"isDel":null,"createTime":null,"lastLoginTime":null}}}
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
			url:'user',
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
    const $ = layui.$;
    const upload = layui.upload;
    const form = layui.form;
    $("#testbtn").click(function () {
        let formData = form.val('addForm');
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
        form.render('select','addForm');
    });

</script>
<script src="static/jquery.js"></script>
<script>
    $("[changedom]").change(function(){
        const text=$(this).attr("changedom");
        const $dom=$(text);
        const code=$(this).val();
        getData(code,$dom);
    })

    const $option=$("<option></option>")
    let $clone_option;
    function showarea(data,$dom){
        data=data.districts[0].districts;
        $dom.empty();
        for(let i=0;i<data.length;i++){
            const item = data[i];
            $clone_option=$option.clone();
            $clone_option.val(item.adcode).text(item.name);
            if(item.name==="台湾省"){
                continue;
            }
            $dom.append($clone_option);
        }
        //主动触发change事件
        $dom.trigger("change")
    }
    // 显示省份信息
    getData('100000',$("#province"))
    function getData(code,$dom){
        $.ajax({
            url:'https://restapi.amap.com/v3/config/district',
            data:{
                key:'04047c53d75f14c1075c95ea839c49be',
                keywords:code,
            },
            success:function(result){
                showarea(result,$dom);
            }
        })
    }
</script>
</body>
</html>
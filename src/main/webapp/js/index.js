
$(function () {

    /**
     * 登录
     */
    $("#login-submit").click(function () {
        var userName=$("#login-useName").val();
        var userPwd=$("#login-usePwd").val()
        if(isEmpty(userName)){
            $("#login-msg").html("用户名为空");
            return;
        }
        if(isEmpty(userPwd)){
            $("#login-msg").html("密码为空");
            return;
        }
        $("#login-msg").html("");
        $.ajax({
            type:"post",
            url:ctx+"/login",
            data:{"userName":userName,"userPwd":userPwd},
            dataType:"JSON",
            success:function (data) {
                if(data.code==200){
                    /**
                     * 登录成功
                     * 存cookie
                     * 跳转主页面
                     */
                    alert("登录成功");
                    $.cookie("userIdStr",data.result.id);
                    $.cookie("userName",data.result.userName);
                    $.cookie("trueName",data.result.trueName);
                    window.location.href=ctx+"/main";
                    return;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(textStatus);
               /* // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);*/
                /*// 错误信息
                console.log(textStatus);*/
                $("#login-msg").html(XMLHttpRequest);
            }

        })
    })


})

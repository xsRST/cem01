
$(function () {

    /**
     * 创建验证码
     */
    createCode(4);

    /**
     * 点击验证框,刷新验证码
     */
    $("#verify").click(function () {
        createCode(4);
    })
    /**
     * 登录
     */
    $("#login-submit").click(function () {
        var userName=$("#login-useName").val();
        var userPwd=$("#login-usePwd").val()
        var verification=$("#login-verification").val();
        if(isEmpty(userName)){
            $("#login-msg").html("用户名为空");
            return;
        }
        if(isEmpty(userPwd)){
            $("#login-msg").html("密码为空");
            return;
        }
        if(isEmpty(verification) ||verification.toLowerCase() != $("#verify").html().trim().toLowerCase()){
            $("#login-msg").html("验证码错误");
            return
        }
        $("#login-msg").html("");
        $.ajax({
            type:"post",
            url:ctx+"/user/login",
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
                }else {
                    $("#login-msg").html(data.msg);
                }
            },
        })
    })
})

/**
 * 创建验证码
 */
function createCode(len){
    var code=" ";
    var codes=new Array('1','2','3','4','5','6','7','8','9','0',
        'a','b','c','d','e','f','g','h','i','j',
        'k','l','m','n','o','p','q','r','s','t',
        'u','v','w','x','y','z',
        'A','B','C','D','E','F','G','H','I','J',
        'K','L','M','N','O','P','Q','R','S','T',
        'U','V','W','X','Y','Z');
    for(var i=0;i<len;i++){
        var index= parseInt(Math.random()*codes.length);
        code +=codes[index];
    }

    $("#verify").html(code);
}



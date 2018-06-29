/**
 *  退出操作
 */
function logout() {
    $.messager.confirm("确认退出","是否退出",function (flag) {
        if(flag){
            /**
             * 确认退出
             * 清cookie,
             * 返回登录页面
             */
            $.removeCookie("userIdStr");
            $.removeCookie("userName");
            $.removeCookie("trueName");
            $.messager.alert("退出操作","3秒后退出","info")
            setTimeout(function () {
                window.location.href=ctx+"/index";
            },2000);
        }
    });
}

/**
 * 打开修改消息框
 */
function openPasswordModifyDialog() {
    $("#dlg").dialog("open").dialog("setTitle","密码修改");
}

/**
 * 关闭修改消息框
 */
function closePasswordModifyDialog() {
    $("#dlg").dialog("close")
}

/**
 *  修改密码
 */
function modifyPassword() {

    var oldPassword=$("#oldPassword").val();
    var newPassword=$("#newPassword").val();
    var newPassword2=$("#newPassword2").val();
    if(oldPassword==newPassword){
        $.messager.alert("修改失败","密码未改变","info");
        return;
    }
    if(newPassword!=newPassword2){
        $.messager.alert("修改失败","确认密码是否一致","info");
        return;
    }

    $("#fm").form("submit",{
        url:ctx+"/modifyPassword",
        onSubmit:function () {
            return $(this).form("validate");
        },
        success:function (data) {
            data=JSON.parse(data);
            console.log(data);
            if(data.code==200){
                /**
                 * 密码修改成功;
                 * 提示,清cookie,重新登录
                 */
                $.removeCookie("userIdStr");
                $.removeCookie("userName");
                $.removeCookie("trueName");
                $.messager.alert("修改成功","密码修改成功,系统2秒后自动退出!","success");
                setTimeout(function () {
                    window.location.href=ctx+"/index";
                },2000);
            }else {
                $.messager.alert("修改失败",data.msg);
            }
        }
    })


}

function openTab(text, url, iconCls){
    if($("#tabs").tabs("exists",text)){
        $("#tabs").tabs("close",text);
    }
        var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add",{
            title:text,
            iconCls:iconCls,
            closable:true,
            content:content
        });
}



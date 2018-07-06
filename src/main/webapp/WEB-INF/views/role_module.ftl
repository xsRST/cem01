<!DOCTYPE html>
<html>
<head>
    <TITLE>角色绑定资源</TITLE>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/ztree/css/demo.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${ctx}/ztree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${ctx}/ztree/js/jquery.ztree.excheck.js"></script>
    <script >
        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        var zNodes =[];

        <#if modules?has_content >
            <#list modules as module>
                var data={id: ${module.id?c} ,pId:${module.pId?default(0)} , name:'${module.name}' ,
                            open:${module.open?string("true","false")} ,checked:${module.checked?c} };
                zNodes.push(data);
            </#list>
        </#if>
        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
    </script>
</head>
<boby>
    <h1>角色[${role.roleName!}]绑定资源</h1>
    <div>
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</boby>
</html>
<!doctype html>
<html>
<head>
    <#include "common.ftl" >
    <title>角色管理</title>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/role.js"></script>
</head>
<body style="margin: 1px">

<#--数据列表-->
<table id="dg"  class="easyui-datagrid" title="角色管理"
       pagination="true" rownumbers="true"
       url="${ctx}/role/list" fit="true" toolbar="#tb" >
    <thead>
    <tr>
        <th field="cb" checkbox="true">编号</th>
        <th field="id" width="50" align="center">编号</th>
        <th field="roleName" width="200" align="center" >角色名称</th>
        <th field="roleRemark" width="200" align="center" >角色描述</th>
        <th field="createDate" width="200"  align="center" >创建时间</th>
        <th field="updateDate"  hidden="hidden"align="center" >修改时间</th>
    </tr>
    </thead>
</table>

<#--工具栏-->
<div id="tb">
    <a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:deleteRows()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    <a href="javascript:openRelate()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">关联权限</a>
</div>

<#--弹出框-->
<div id="dlg" class="easyui-dialog" style="width:600px;height:250px;"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <input type="hidden" id="id" name="id" />
            <tr>
                <td>角色名称：</td>
                <td colspan="4"><input type="text" id="roleName" name="roleName" style="width: 420px" class="easyui-validatebox" required="required" /></td>
            </tr>
            <tr>
            <td>角色描述：</td>
            <td colspan="4">
                <textarea rows="5" cols="50" id="roleRemark" name="roleRemark" style="margin: 0px;width: 421px;height: 75px;resize: none;"></textarea>
            </td>
        </tr>
        </table>
    </form>
</div>
<#--弹出框按钮-->
<div id="dlg-buttons">
    <a href="javascript:saveOrUpdate()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" href="javascript:closeDialog()">取消</a>
</div>


</body>

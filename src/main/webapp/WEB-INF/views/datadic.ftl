<!doctype html>
<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/datadic.js"></script>
    <title>数据字典管理</title>
</head>
<body style="margin: 1px">

    <#--数据列表-->
    <table id="dg"  class="easyui-datagrid" title="数据字典管理"
           pagination="true" rownumbers="true"
           url="${ctx}/datadic/list" fit="true" toolbar="#tb" >
        <thead>
        <tr>
            <th field="cb" checkbox="true">编号</th>
            <th field="id" width="50" align="center">编号</th>
            <th field="dataDicName" width="200" align="center" >字典名</th>
            <th field="dataDicValue" width="200" align="center">字典值</th>

        </tr>
        </thead>
    </table>

    <#--工具栏-->
    <div id="tb">
        <a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteRows()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <br/>
        字典名: <input id="name" class="easyui-combobox" editable="true"
                    valueField="dataDicName" textField="dataDicName" url="${ctx}/datadic/findAllName" panelHeight="auto" />

        字典值:<input type="text" id="value"/>
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" href="javascript:searchRows()" >搜索</a>
    </div>

    <#--弹出框-->
    <div id="dlg" class="easyui-dialog" style="width: 600px;height: 150px" buttons="#dlg-buttons" closed="true">
        <form method="post" id="fm">
            <table style="margin: 20px; 40px;">
                <tr>
                    <td>字典名：</td>
                    <td>
                        <input id="datadicName" name="dataDicName" class="easyui-combobox" editable="true" required="true"
                               valueField="dataDicName" textField="dataDicName" url="${ctx}/datadic/findAllName" panelHeight="auto" />
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>字典值：</td>
                    <td><input id="datadicValue" name="dataDicValue" class="easyui-validatebox" required="true" /></td>
                </tr>

            </table>
            <input  id="id" type="hidden" name="id"/>
        </form>
    </div>

    <#--弹出框按钮-->
    <div id="dlg-buttons">
        <a href="javascript:saveOrUpdate()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" href="javascript:closeDialog()">取消</a>
    </div>


</body>

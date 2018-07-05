<!doctype html>
<html>
<head>
    <#include "common.ftl" >
    <title>产品信息管理</title>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/product.js"></script>
</head>
<body style="margin: 1px">

    <#--数据列表-->
    <table id="dg"  class="easyui-datagrid" title="产品信息管理"
           pagination="true" rownumbers="true"
           url="${ctx}/product/list" fit="true" toolbar="#tb" >
        <thead>
        <tr>
            <th field="cb" checkbox="true">编号</th>
            <th field="id" width="50" align="center">编号</th>
            <th field="productName" width="200" align="center" >产品名称</th>
            <th field="model" width="200" align="center" >型号</th>
            <th field="unit" width="200" align="center" >单位</th>
            <th field="price" width="200" align="center" >价格</th>
            <th field="store" width="200" align="center">库存</th>
            <th field="remark" width="200" align="center">备注</th>
        </tr>
        </thead>
    </table>

    <#--工具栏-->
    <div id="tb">
        <a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteRows()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <br/>

        产品名称:<input type="text" id="name"/>
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" href="javascript:searchRows()" >搜索</a>
    </div>

    <#--弹出框-->
    <div id="dlg" class="easyui-dialog" style="width: 600px;height: 350px" buttons="#dlg-buttons" closed="true">
        <form method="post" id="fm">
            <table style="margin: 20px; 40px;">
                <tr>
                    <td>产品名称：</td>
                    <td><input id="productName" name="productName" class="easyui-validatebox" required="true" /></td>
                    <td>型号：</td>
                    <td><input id="model" name="model" class="easyui-validatebox" required="true" /></td>
                </tr>
                <tr>
                    <td>价格：</td>

                    <td><input id="price" name="price" class="easyui-validatebox" required="true" /></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                </tr>
                <tr>
                    <td>库存：</td>
                    <td><input id="store" name="store" class="easyui-validatebox" required="true" /></td>
                    <td>单位：</td>
                    <td><input id="unit" name="unit" class="easyui-validatebox" required="true" /></td>
                </tr>
                <tr>

                    <td>备注：</td>

                    <td><input id="remark" name="remark" class="easyui-validatebox" required="true" /></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
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

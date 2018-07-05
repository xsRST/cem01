<!doctype html>
<html>
<head>
    <#include "common.ftl" >
    <title>模块管理</title>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/js/module.js"></script>
</head>
<body style="margin: 1px">

    <#--数据列表-->
    <table id="dg"  class="easyui-datagrid" title="模板信息管理"
           pagination="true" rownumbers="true"
           url="${ctx}/module/list" fit="true" toolbar="#tb" >
        <thead>
        <tr>
            <th field="cb" checkbox="true">编号</th>
            <th field="id" width="50" align="center">编号</th>
            <th field="moduleName" width="200" align="center" >模块名称</th>
            <th field="moduleStyle" width="200" align="center" >模块样式</th>
            <th field="parentName" width="200"  align="center" >父级名称</th>
            <th field="parentId"  hidden="hidden"align="center" >父级ID</th>
            <th field="url" width="200" align="center" >路径/方法</th>
            <th field="optValue" width="200" align="center" >操作权限</th>
            <th field="grade" width="200" align="center" formatter="formatterLevel">层级</th>
            <th field="orders" width="200" align="center">排序</th>
            <th field="createDate" width="200" align="center">修改时间</th>
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
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>末班名称：</td>
                    <td><input id="moduleName" name="moduleName" class="easyui-validatebox" required="true" /></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>模板样式：</td>
                    <td><input id="moduleStyle" name="moduleStyle" class="easyui-validatebox" required="true" /></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>排序：</td>
                    <td><input id="orders" name="orders" class="easyui-validatebox" required="true" /></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>路径/方法：</td>
                    <td><input id="url" name="url" class="easyui-validatebox" required="true" /></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>操作权限：</td>
                    <td><input id="optValue" name="optValue" class="easyui-validatebox" required="true" /></td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>层级：</td>
                    <td>
                        <select  id="grade" name="grade" >
                            <option value="0" >根级</option>
                            <option value="1" >第一级</option>
                            <option value="2" >第二级</option>
                        </select>
                    </td>
                </tr>
                <tr  id="parentIdDiv" style="display: none;">
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td>父级菜单：</td>
                    <td>
                        <input id="parentId" name="parentId" value="">
                    </td>
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

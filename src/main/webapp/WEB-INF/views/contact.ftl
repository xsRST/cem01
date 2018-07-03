<!DOCTYPE html>
<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
</head>
    <body style="margin: 1px">
        <div id="p" class="easyui-panel" title="客户基本信息" style="width: 700px;height: 150px;padding: 10px">
            <table cellspacing="8px">
                <input type="hidden" id="customerId" name="customerId" value="${customer.id?c}"/>
                <tr>
                    <td>客户编号：</td>
                    <td><input type="text" id="customerNo" name="khno" readonly="readonly" value="${customer.khno?if_exists}"/></td>
                    <td>客户名称：</td>
                    <td><input type="text" id="customerName" name="customerName" readonly="readonly" value="${customer.name?default('')}" /></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    </tr>
            </table>
        </div>
        <br>

        <#--使用Edatagrid展示数据-->
        <table id="tt" style="width:700px;height:350px" title="交往记录" singleSelect="true" rownumbers="true"
               toolbar="#toolbar" idField="id" fitColumns="true" singleSelect="true" pagination="true">
            <thead>
            <tr>
                <th field="id" width="100">编号</th>
                <th field="contactTime" width="100" editor="{type:'datebox',options:{required:true,editable:false}}">交往时间</th>
                <th field="address" width="100" align="right" editor="{type:'validatebox',options:{required:true}}">交往地址</th>
                <th field="overview" width="100" align="right" editor="{type:'validatebox',options:{required:true}}">概要</th>
            </tr>
            </thead>
        </table>

        <div id="toolbar" style="display: none;">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRow();">添加</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteRow();">删除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save();">保存</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="cancelRow();">撤销行</a>
        </div>

        <script src="${ctx}/js/contact.js"></script>
    </body>

</html>
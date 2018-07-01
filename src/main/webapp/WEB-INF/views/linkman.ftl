<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/linkman.js"></script>
</head>
<body style="margin: 1px">
<#--客户基本信息-->
<div id="p" class="easyui-panel" title="客户基本信息" style="width:700px;height: 100px;padding: 10px">
    <table cellspacing="8px">
        <input type="hidden" id="customerId" name="saleChanceId" value="${customer.id?if_exists}"/>
        <tr>
            <td>客户编号：</td>
            <td><input type="text" id="customerName" name="khno" readonly="readonly" value="${customer.khno?default('')}" /></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>客户名称</td>
            <td><input type="text" id="chanceSource" name="name" readonly="readonly" value="${customer.name?if_exists}"/></td>
        </tr>
    </table>
</div>
<br/>
<#--联系人信息管理-->
<table id="dg" title="联系人信息管理" style="width:700px;height:250px"
       toolbar="#toolbar" idField="id" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="100">编号</th>
        <th field="linkName" width="100" editor="{type:'validatebox',options:{required:true}}">联系人姓名</th>
        <th field="sex" width="50" editor="{type:'combobox',
		   			options:{
		   				valueField:'id',
		   				textField:'name',
		   				data:[{id:'男',name:'男'},{id:'女',name:'女'}],
		   				required:true,
		   				editable:false,
		   				panelHeight:'auto'
		   		    }}">性别</th>
        <th field="zhiwei" width="100" align="right" editor="{type:'validatebox',options:{required:true}}">职位</th>
        <th field="officePhone" width="100" align="right" editor="{type:'validatebox',options:{required:true}}">办公电话</th>
        <th field="phone" width="100" align="right" editor="{type:'validatebox',options:{required:true}}">手机</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:addPlan()" class="easyui-linkbutton" iconCls="icon-add" plain="true" >添加</a>
    <a href="javascript:deletePlan()" class="easyui-linkbutton"iconCls="icon-remove" plain="true" >删除</a>
    <a href="javascript:savePlan()" class="easyui-linkbutton" iconCls="icon-save" plain="true" >保存</a>
    <a href="javascript:cancelPlan()" class="easyui-linkbutton" iconCls="icon-undo" plain="true" >撤销行</a>
</div>
</body>


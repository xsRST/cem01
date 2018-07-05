<!doctype html>
<html>
<head>
<#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/customer.serve.archive.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="客服服务归档管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/customer_serve/list?state=4" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="customer" width="100" align="center">客户</th>
        <th field="overview" width="200" align="center">概要</th>
        <th field="serveType" width="100" align="center">服务类型</th>
        <th field="serviceRequest" width="100" align="center" hidden="true">请求</th>
        <th field="createPeople" width="100" align="center">创建人</th>
        <th field="createDate" width="100" align="center">创建日期</th>
        <th field="state" width="50" align="center" hidden="true">客服服务状态</th>
        <th field="assigner" width="50" align="center" hidden="true">分配人</th>
        <th field="assignTime" width="100" align="center" hidden="true">分配日期</th>
        <th field="serviceProce" width="100" align="center" hidden="true">服务处理</th>
        <th field="serviceProcePeople" width="100" align="center" hidden="true">服务处理人</th>
        <th field="serviceProceTime" width="100" align="center" hidden="true">服务处理日期</th>
        <th field="serviceProceResult" width="50" align="center" hidden="true">服务处理结果</th>
        <th field="myd" width="50" align="center" hidden="true">客户满意度</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        &nbsp;客户名称：&nbsp;<input type="text" id="s_customer" size="20" onkeydown="if(event.keyCode==13) searchCustomerService()"/>
        &nbsp;概要：&nbsp;<input type="text" id="s_overview" size="20" onkeydown="if(event.keyCode==13) searchCustomerService()"/>
        &nbsp;服务类型：&nbsp;
        <input class="easyui-combobox" id="s_serveType"
               data-options="panelHeight:'auto',editable:true,
        valueField:'datadicValue',textField:'datadicValue',
        url:'${ctx}/datadic/findValues.do?dataDicName=服务类型'"/>
        &nbsp;创建日期：&nbsp;<input type="text" id="s_createDateFrom" class="easyui-datebox" editable="true"/>&nbsp;-&nbsp;<input type="text" id="s_createDateTo" class="easyui-datebox" editable="true"/>&nbsp;
        <a href="javascript:searchCustomerService()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>
</body>
</html>
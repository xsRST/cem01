<html>
<head>
<#include "common.ftl">
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/customer.loss.js"></script>
</head>
<body>
	<table id="dg" class="easyui-datagrid"  pagination=true 
	     rownumbers=true toolbar="#tb"  singeSelect="true"  fit=true url="${ctx}/customer_loss/queryCustomerLossesByParams">   
    <thead>   
        <tr>
            <th field='id' hidden="hidden">id</th>
            <th field='cusName'>客户名称</th>   
            <th field='cusManager'>客户经理</th>   
            <th field='lastOrderTime'>上次下单时间</th>
            <th field='confirmLossTime'>确认流失时间</th>
            <th field='state'  formatter="formatterState">流失状态</th>
            <th field='lossReason'>流失原因</th>
            <th field='op'  formatter="formatterOp">操作</th>
        </tr>   
    </thead>   
</table>



<div id="tb">
    客户名称:<input name="createMan" id="s_cusName" type="text"/>
   客户经理:<input  id="s_cusManager" name="cusManager" />
   客户状态:<select class="easyui-combobox" id="s_state" editable="false" panelHeight="auto" >
    <option value="">请选择...</option>
    <option value="0">暂缓流失</option>
    <option value="1">确认流失</option>
</select>

 <a href="javascript:searchCustomerLosses()" class="easyui-linkbutton" iconCls="icon-search" plain=true>查询</a>
</div>









  
</body>
</html>
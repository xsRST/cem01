<html>
<head>
<#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/plan.index.js"></script>
</head>
<body style="margin: 1px">
<#--营销机会详情展示-->
    <table id="dg1"  class="easyui-datagrid"
           pagination="true" rownumbers="true"
           url="${ctx}/saleChance/querySaleChancesByParams?state=1" fit="true" toolbar="#tb" >
        <thead>
        <tr>
            <th field="id" width="50" align="center">编号</th>
            <th field="chanceSource" width="100" align="center" >机会来源</th>
            <th field="customerName" width="50" align="center">客户名称</th>
            <th field="overview" width="130" align="center">概要</th>
            <th field="linkMan" width="100" align="center">联系人</th>
            <th field="linkPhone" width="130" align="center">联系电话</th>
            <th field="cgjl" width="50" align="center" >成功几率</th>
            <th field="assignMan" width="100" align="center" >指派人</th>
            <th field="assignTime" width="100" align="center" >指派时间</th>
        <th field="devResult" width="100" align="center" formatter="formatterDevResult" >客户开发状态</th>
        <th field="1" width="120" align="center" formatter="formatterControl">操作</th>
        </tr>
        </thead>
    </table>
    <div id="tb">
        <br/>
        客户名称:<input type="text" id="customerName" />
        概要:<input type="text" id="overview"/>
        开发状态:
        <select id="devResult" class="easyui-combobox" name="devResult" style="width:200px;" panelHeight="auto">
            <option value="">全部</option>
            <option value="0">未开发</option>
            <option value="1">开发中</option>
            <option value="2">开发成功</option>
            <option value="0">开发失败</option>
        </select>
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" href="javascript:querySaleChancesByParams()" >搜索</a>
    </div>
<br/>
</body>
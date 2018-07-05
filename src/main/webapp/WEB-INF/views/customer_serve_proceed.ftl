<html>
<head>
<#include "common.ftl">
<script type="text/javascript" src="${ctx}/js/customer.serve.proceed.js"></script>
</head>
<body>
	<table id="dg" class="easyui-datagrid"  pagination=true 
	     rownumbers=true    toolbar="#tb" fit=true url="${ctx}/customer_serve/list?state=2">
    <thead>   
        <tr>
            <th field="cb" checkbox="true" align="center"></th>
            <th field="id" width="50" align="center">编号</th>
            <th field="customer" width="100" align="center">客户</th>
            <th field="overview" width="200" align="center">概要</th>
            <th field="serveType" width="100" align="center">服务类型</th>
            <th field="createPeople" width="100" align="center">创建人</th>
            <th field="createDate" width="100" align="center">创建日期</th>
            <th field="assigner" width="50" align="center" >分配人</th>
            <th field="assignTime" width="100" align="center" >分配日期</th>
            <th field="serviceProce" width="100" align="center" hidden="true">服务处理</th>
            <th field="serviceProcePeople" width="100" align="center" hidden="true">服务处理人</th>
            <th field="serviceProceTime" width="100" align="center" hidden="true">服务处理日期</th>
            <th field="serviceProceResult" width="50" align="center" hidden="true">服务处理结果</th>
            <th field="myd" width="50" align="center" hidden="true">客户满意度</th>
        </tr>   
    </thead>   
</table>


<div id="tb">
   <a  href="javascript:openProceedDlg()" class="easyui-linkbutton" iconCLs="icon-save"  plain=true>处理</a>
</div>


<!--分配信息 对话框-->
	<div id="dlg" class="easyui-dialog" title="服务分配" closed="true"
		style="width:700px;height:400px;padding: 10px 20px"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<input type="hidden" id="id" name="id" />
			<table cellspacing="15px">
				<tr>
					<td>服务类型：</td>
					<td><input type="text" id="serveType" readonly="readonly" name="serveType" /></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>客户：</td>
					<td><input type="text" id="customer" readonly="readonly" name="customer" />
				</tr>
				<tr>
					<td>概要：</td>
					<td colspan="4"><input type="text" readonly="readonly" id="overview"
						name="overview" style="width: 419px" /></td>
				</tr>
				<tr>
					<td>服务请求：</td>
					<td colspan="4"><textarea readonly="readonly" id="serviceRequest"
							name="serviceRequest" rows="5" cols="49"></textarea>&nbsp;<font
						color="red">*</font></td>
				</tr>
				<tr>
					<td>创建人：</td>
					<td colspan="4"><input id="createPeople" readonly="readonly" name="createPeople"/>
					</td>
				</tr>
				<tr>
				  <td>创建时间：</td>
					<td colspan="4"><input id="createDate" readonly="readonly" name="createDate"/>
					</td>
				</tr>
                <tr>
                    <td>分配给：</td>
                    <td>
                        <input  id="assigner" name="assigner" readonly="readonly"/>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>分配时间：</td>
                    <td>
                        <input type="text" id="assignTime" name="assignTime" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td>服务处理：</td>
                    <td colspan="4">
                        <textarea id="serviceProce" name="serviceProce" rows="5" cols="49" class="easyui-validatebox" required="true"></textarea>&nbsp;<font color="red">*</font>
                    </td>
                </tr>
                <tr>
                    <td>处理人：</td>
                    <td>
                        <input  id="serviceProcePeople" name="serviceProcePeople" readonly="readonly"/>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                </tr>
            </table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:addCustomerServeServiceProceed()"
			class="easyui-linkbutton" iconCls="icon-ok">保存</a> <a
			href="javascript:closeCustomerServeDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>






</body>
</html>
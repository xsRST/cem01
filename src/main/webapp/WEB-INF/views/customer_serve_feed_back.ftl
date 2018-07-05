<html>
<head>
<#include "common.ftl">
<script type="text/javascript" src="${ctx}/js/customer.serve.feed.back.js"></script>
</head>
<body>
	<table id="dg" class="easyui-datagrid"  pagination=true 
	     rownumbers=true    toolbar="#tb" fit=true url="${ctx}/customer_serve/list?state=3">
    <thead>   
        <tr>
            <th field='cb' checkbox=true >id</th>    
            <th field='serveType'>服务类型</th>   
            <th field='overview'>概要</th>   
            <th field='customer'  >客户名称</th>
            <th field='overview'>概要</th>
            <th field='serviceRequest'>请求内容</th>
            <th field='createPeople'>创建人</th>
            <th field='createMan'>创建人</th>
            <th field='assigner'>分配人</th>
            <th field='assignTime'>分配时间</th>
            <th field='serviceProcePeople'>处理人</th>
            <th field='serviceProceTime'>处理时间</th>
            <th field='createDate'>创建时间</th>
            <th field='updateDate'>更新时间</th>
        </tr>   
    </thead>   
</table>


<div id="tb">
   <a  href="javascript:openFeedBackDlg()" class="easyui-linkbutton" iconCLs="icon-save"  plain=true>反馈</a>
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
					<td colspan="4"><input id="createPeople" readonly="readonly" name="createPeople"></input>
					</td>
				</tr>
				<tr>
				  <td>创建时间：</td>
					<td colspan="4"><input id="createDate" readonly="readonly" name="createDate"></input>
					</td>
				</tr>
				<tr>
					<td>分配人：</td>
					<td colspan="4"><input id="assigner" readonly="readonly" name="assigner"></input>
					</td>
				</tr>
				<tr>
					<td>分配时间：</td>
					<td colspan="4"><input id="assignTime" readonly="readonly" name="assignTime"></input>
					</td>
				</tr>
				<tr>
					<td>处理内容：</td>
					<td colspan="4"><textarea  readonly="readonly"
							name="serviceProce" rows="5" cols="49"></textarea>&nbsp;<font
				    color="red">*</font></td>
				</tr>
				<tr>
					<td>处理人：</td>
					<td colspan="4">
					  <input id="serviceProcePeople" readonly="readonly" name="serviceProcePeople"></input>
					</td>
				</tr>
				<tr>
					<td>处理时间：</td>
					<td colspan="4">
					<input id="serviceProceTime" readonly="readonly" name="serviceProceTime"></input>
					</td>
				</tr>
				
				<tr>
					<td>处理结果：</td>
					<td colspan="4">
					<input id="serviceProceResult"  name="serviceProceResult"></input>
					</td>
				</tr>
				
				<tr>
				<td>满意度：</td>
				<td><select class="easyui-combobox" style="width: 154px"
						id="myd" name="myd" editable="false" panelHeight="auto">
							<option value="">请选择...</option>
							<option value="☆">☆</option>
							<option value="☆☆">☆☆</option>
							<option value="☆☆☆">☆☆☆</option>
							<option value="☆☆☆☆">☆☆☆☆</option>
							<option value="☆☆☆☆☆">☆☆☆☆☆</option>
					</select>&nbsp;<font color="red">*</font></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:addCustomerServeServiceFeedBack()"
			class="easyui-linkbutton" iconCls="icon-ok">保存</a> <a
			href="javascript:closeCustomerServeDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>






</body>
</html>
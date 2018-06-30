<!doctype html>
<html>
<head>
<#include "common.ftl" >
<script type="text/javascript" src="${ctx}/js/customer.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid" pagination="true" rownumbers="true"
       url="${ctx}/customer/queryByParams" fit="true" toolbar="#tb" >
    <#--固定-->
    <thead data-options="frozen:true">
        <tr>
            <th checkbox="true">编号</th>
            <th field="id" hidden="hidden">ID</th>
            <th field="khno" width="100" align="center">客户编号</th>
            <th field="name" width="50" align="center" >客户名称</th>
            <th field="cusManager" width="50" align="center">客户经理</th>
            <th field="level" width="50" align="center" >客户等级</th>
            <th field="phone" width="200" align="center">联系电话</th>
        </tr>
    </thead>
    <thead>
        <tr>
            <th field="area" width="100" align="center">客户地区</th>
            <th field="myd" width="100" align="center">客户满意度</th>
            <th field="xyd" width="100" align="center" >客户信用度</th>
            <th field="address" width="100" align="center">详细地址</th>
            <th field="postCode" width="80" align="center">邮政编码</th>
            <th field="fax" width="80" align="center">传真</th>
            <th field="webSite" width="100" align="center" >网址</th>
            <th field="yyzzzch" width="150" align="center" >营业执照注册号</th>
            <th field="fr" width="50" align="center" >法人</th>
            <th field="nyye" width="100" align="center" >年营业额</th>
            <th field="khyh" width="100" align="center" >开户银行</th>
            <th field="khzh" width="100" align="center">开户账号</th>
            <th field="dsdjh" width="100" align="center">地税登记号</th>
            <th field="gsdjh" width="100" align="center">国税登记号</th>
        </tr>
    </thead>
</table>
<div id="tb">
    <a href="javascript:openAddCustomer()" class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a>
    <a href="javascript:openUpdateCustomer()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:deleteCustomer()"  class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    <br/>
    客户编号:<input type="text" id="khno" />
    客户名称:<input type="text" id="name"/>
    <a class="easyui-linkbutton" iconCls="icon-search" plain="true" href="javascript:queryCustomerByParams()" >搜索</a>
</div>

<#--添加/修改弹出框-->
<div id="dlg" class="easyui-dialog" title="添加客户" style="width: 600px;height: 300px" buttons="#bt" closed="true">
    <form id="fm" method="post">
        <input type="hidden" id="id" name="id" />
        <table cellspacing="8px">
            <tr>
                <td>客户名称：</td>
                <td><input type="text" id="name" name="name" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>地区</td>
                <td>
                    <select class="easyui-combobox" style="width: 154px" id="area" name="area" editable="false" panelHeight="auto" >
                        <option value="">请选择地区...</option>
                        <option value="北京">北京</option>
                        <option value="南京">南京</option>
                        <option value="上海">上海</option>
                        <option value="广州">广州</option>
                        <option value="天津">天津</option>
                    </select>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>客户经理：</td>
                <td>
                <input class="easyui-combobox" id="cusManager" name="cusManager" data-options="panelHeight:'auto',editable:false,valueField:'trueName',textField:'trueName',url:'${ctx}/user/querySaleCustomerManager'"/>&nbsp;<font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>客户等级：</td>
                <td>
                <input class="easyui-combobox" id="level" name="level" data-options="panelHeight:'auto',editable:false,valueField:'dataDicValue',textField:'dataDicValue',url:'${ctx}/datadic/findValues?dataDicName=客户等级'"/>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>客户满意度：</td>
                <td>
                    <select class="easyui-combobox" style="width: 154px" id="myd" name="myd" editable="false" panelHeight="auto" >
                        <option value="">请选择...</option>
                        <option value="☆">☆</option>
                        <option value="☆☆">☆☆</option>
                        <option value="☆☆☆">☆☆☆</option>
                        <option value="☆☆☆☆">☆☆☆☆</option>
                        <option value="☆☆☆☆☆">☆☆☆☆☆</option>
                    </select>&nbsp;<font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>客户信用度</td>
                <td>
                    <select class="easyui-combobox" id="xyd" name="xyd" style="width: 154px" editable="false" panelHeight="auto">
                        <option value="">请选择...</option>
                        <option value="☆">☆</option>
                        <option value="☆☆">☆☆</option>
                        <option value="☆☆☆">☆☆☆</option>
                        <option value="☆☆☆☆">☆☆☆☆</option>
                        <option value="☆☆☆☆☆">☆☆☆☆☆</option>
                    </select>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>邮政编码：</td>
                <td><input type="text" id="postCode" name="postCode" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>联系电话：</td>
                <td><input type="text" id="phone" name="phone" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
            </tr>
            <tr>
                <td>传真：</td>
                <td><input type="text" id="fax" name="fax" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>网址：</td>
                <td><input type="text" id="webSite" name="webSite" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
            </tr>
            <tr>
                <td>客户地址</td>
                <td colspan="4">
                    <input type="text" id="address" name="address" style="width: 400px" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>营业执照注册号：</td>
                <td><input type="text" id="yyzzzch" name="yyzzzch" /></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>法人：</td>
                <td><input type="text" id="fr" name="fr" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
            </tr>
            <tr>
                <td>注册资金(万元)：</td>
                <td><input type="text" id="zczj" name="zczj" /></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>年营业额(万元)：</td>
                <td><input type="text" id="nyye" name="nyye" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
            </tr>
            <tr>
                <td>开户银行：</td>
                <td><input type="text" id="khyh" name="khyh" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>开户帐号：</td>
                <td><input type="text" id="khzh" name="khzh" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
            </tr>
            <tr>
                <td>地税登记号：</td>
                <td><input type="text" id="dsdjh" name="dsdjh" /></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>国税登记号：</td>
                <td><input type="text" id="gsdjh" name="gsdjh" /></td>
            </tr>
        </table>
    </form>
</div>

<div id="bt">
    <a href="javascript:saveOrUpdateCustomer()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" href="javascript:closeDialog()">取消</a>
</div>
</body>

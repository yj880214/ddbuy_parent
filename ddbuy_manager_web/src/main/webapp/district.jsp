<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/12/9
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>区域管理页面</title>
    <%--导入文件--%>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <%--第一步，导入js--%>
    <script  src="js/jquery-1.8.3.js"></script>
    <%--第二步，导入easyui--%>
    <script  src="js/jquery.easyui.min.js" ></script>

    <script type="text/javascript" src="js/district.js">

    </script>
</head>

<body>
  <table id="dg"></table>


  <%--工具栏--%>
  <div id="ToolBar">
      <div style="height: 40px;">
          <a href="javascript:Add()" class="easyui-linkbutton"
             iconCls="icon-add" plain="true">添加</a>
          <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
              iconCls="icon-edit" plain="true">修改</a>
          <a href="javascript:DeleteMore()" class="easyui-linkbutton"
              iconCls="icon-remove" plain="true">删除选中项</a>
      </div>
  </div>
<%--添加的对话框--%>
  <div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
       style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
      <form id="addDialogForm" method="post">
          <table>
              <tr>
                  <td>名称:</td>
                  <td><input type="text" name="name" id="author" /></td>
              </tr>
          </table>
      </form>
  </div>
<%--添加的对话框中设置：“保存”、“取消”按钮--%>
  <div id="AddDialogButtons">
      <a href="javascript:SaveDialog()" class="easyui-linkbutton"
         iconCls="icon-ok">保存</a> 
      <a href="javascript:CloseDialog()" class="easyui-linkbutton" 
         iconCls="icon-cancel">取消</a>
  </div>

<%--修改的对话框：可以参考“添加”功能的对话框设置--%>
  <div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
       style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
      <form id="upDialogForm" method="post">
          <table>
              <tr>
                  <td>编号:</td>
                  <td><input type="text" readonly="readonly" name="id"  /></td>
              </tr>
              <%--修改时注意id的传递和设置只读--%>
              <tr>
                   <td>名称:</td>
                  <td><input type="text" name="name" id="author2" /></td>
              </tr>
          </table>
      </form>
  </div>

<%--修改对话框中设置“保存”、“取消”按钮--%>
  <div id="upDialogButtons">
      <a href="javascript:upSaveDialog()" class="easyui-linkbutton"
         iconCls="icon-ok">保存</a>
      <a href="javascript:upCloseDialog()" class="easyui-linkbutton"
         iconCls="icon-cancel">取消</a>
  </div>
<%--街道对话框--注意删掉：buttons="#AddDialogButtons"--%>
  <div id="streetDialog" class="easyui-dialog"
       style="width: 600px; height: 400px; padding: 10px 20px;" closed="true">

      <table id="streetDg">  </table>

      <br/>
      <form action="/admin/addStreet">
          区域编号：<input type="text" name="districtId"  id="district">
          街道：<input type="text" name="name" />
          <input type="submit" name="name" value="添加" />
      </form>
  </div>
</body>
</html>

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
    <title>类型管理页面</title>
    <%--导入文件--%>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <%--第一步，导入js--%>
    <script  src="js/jquery-1.8.3.js"></script>
    <%--第二步，导入easyui--%>
    <script  src="js/jquery.easyui.min.js" ></script>

    <script type="text/javascript">
        $(function () {
            //*********************************查询类型：显示并自动分页************************************
            $("#dg").datagrid({
                url:"/admin/getType", //服务器请求（后台控制器的实现请求）
                pagination:true,     //开启分页
                pageList:[3,5,8,10], //分页设置
                pageSize:8,          //每页大小（行数）
                toolbar:"#ToolBar",  //工具栏,toorbar 注意全部小写
                fitColumns:true,    //表格和页面自适应（列/宽度）
                // singleSelect:true,
                columns:[[
                    {field:'ck',checkbox:true},  //设置复选框
                    {field:'id',title:'类型编号',width:100,align:"center"},
                    {field:'name',title:'名称',width:100,align:"center"},
                    {field:'opt',title:'操作',width:100,align:"center",
                        formatter: function(value,row,index){  // 字段的值，此行数据，行索引
                            // return "<a href='delType?id="+row.id+"'>删除</a>";
                            return "<a href='javascript:delSingle("+row.id+")'>删除</a>";
                        }
                    }
                ]]
            })
        })
        //*********************************添加************************************
        //点击"添加"弹出添加对话框
        function Add() {
           $("#AddDialog").dialog("open").dialog("setTitle","添加类型");
        }
        //点击“取消”关闭添加的对话框
        function CloseDialog() {
            $("#AddDialog").dialog("close");
        }
        //实现添加
        function SaveDialog() {
            // alert("我要添加数据！");
            $('#addDialogForm').form('submit', {
                    url:"/admin/addType",
            success:function(data){
                // alert(data)
                var obj=$.parseJSON(data);          //json字符串-->json对象
                if (obj.result>0){
                    $("#AddDialog").dialog("close"); //关闭对话框
                    $('#dg').datagrid('reload');    //刷新
                    $.messager.alert("提示框","添加成功！");
                } else {
                    $.messager.alert("提示框","系统维护中...");
                }
            }
        });
        }
        //*********************************修改***************************************
        //修改：点击工具栏的"修改"按钮，弹出对话框
        function ModifyBySelect() {        //注意和工具栏中的“修改”的js方法名要对应
            //获取选中项，判断是否选择多行或者未选择。执行需要：只能选择1行
            var selectRows=$("#dg").datagrid("getSelections");
            if (selectRows.length!=1){  //获取数据（数组）长度
                //弹框：修改时只能选择一行
                $.messager.alert("提示框","您未选择或选择了多行，请重新操作。");
            }else {   //选中一行就执行：修改
                var selectRow=selectRows[0]  //获取选中的那一项数据
                $("#upDialog").dialog("open").dialog("setTitle","修改类型"); //打开修改对话框
                $("#upDialogForm").form("load",selectRow);  //将选中项的数据加载到修改对话框中，显示
            }
        }
        //实现修改
        function upSaveDialog() {        //注意和”保存“按钮对应的js方法名要对应
            // alert("我要修改数据！");
            $('#upDialogForm').form('submit', {
                url:"/admin/upType",
                success:function(data){
                    // alert(data)
                    var obj=$.parseJSON(data);   //json字符串-->json对象
                    if (obj.result>0){
                        $("#upDialog").dialog("close"); //关闭对话框
                        $('#dg').datagrid('reload');    //刷新
                        $.messager.alert("提示框","修改成功！");
                    } else {
                        $.messager.alert("提示框","系统维护中...");
                    }
                }
            });
        }
        //修改对话框中点击“取消”，关闭对话框
        function upCloseDialog() {
            $("#upDialog").dialog("close");
        }
        //删除单条
        function delSingle(id) {
            $.messager.confirm('确认消息框', '您确认要删除吗？', function(r){
                if (r){
                    //异步操作 ： $.post(请求路径,参数,回调函数,"json");
                    $.post("delType",{"id":id},function (data) {
                        if (data.result>0){
                            $('#dg').datagrid('reload');    //刷新
                            $.messager.alert("提示框","恭喜您！删除成功！")
                        } else {
                            $.messager.alert("提示框","抱歉,系统维护中...")
                        }
                    },"json")
                }
            });
        }
        //删除多条
        function DeleteMore() {   //返回字符串 例如如 1,3,7...
            // alert("我要删除多条");
            var selectRows=$("#dg").datagrid("getSelections");
            var delData="";
            if (selectRows.length!=0){
                  for (var i=0;i<selectRows.length;i++){
                      delData=delData+selectRows[i].id+","
                  }
                // 第一次循环 delData=1,  第二次delData=1,3, 第三次 delData=1,3,7,
                  // alert(delData);
                  //带参数到后台执行删除：异步操作
                $.post("delTypeMore",{"ids":delData},function (data) {
                    if (data.result>0){
                        $('#dg').datagrid('reload');      //刷新
                        $.messager.alert("提示框","恭喜您！成功删除了"+data.result+"条数据！");
                    } else {
                        $.messager.alert("提示框","抱歉,系统维护中...")
                    }
                },"json")
            }else {
                $.messager.alert("提示框","请至少选择一项。");
            }
        }
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
</body>
</html>

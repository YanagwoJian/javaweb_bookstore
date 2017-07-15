<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String admin = (String) request.getParameter("admin");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addbook.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/addbook.css">
	
	<script language="javascript">
	function add() {
		if(document.form.name.value =="") {
			alert("书名不能为空");
			return false;
		}
		else {
			return true;
		}
	}
	</script>

  </head>
  
  <body>
  	<div class="content">
    <div class="add">
    		<form action="/onlinebookstore/addbook?admin=<%= admin %>" method="post" name="form" onsubmit="return add()">
    			<div><h3>书名：&nbsp;&nbsp;</h3><input type="text" name="name" id="name"></div>
    			<div><h3>作者：&nbsp;&nbsp;</h3><input type="text" name="author" id="author"></div>
    			<div><h3>出版社：&nbsp;</h3><input type="text" name="press" id="press"></div>
    			<div><h3>出版日期：</h3><input type="text" name="date" id="date"></div>
    			<div><h3>价格：&nbsp;&nbsp;</h3><input type="text" name="price" id="price"></div>
    			<input type="submit" value="添加" id="submit">
    		</form>
    </div>
    </div>
  </body>
</html>

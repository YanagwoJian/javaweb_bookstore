<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String id = (String) request.getParameter("id");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改信息</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/onlinebookstore/css/changeinfo.css">
	<script type="text/javascript" src="js/book.js" charset="UTF-8"></script>
	
  </head>
  
  <body>
    <form action = "/onlinebookstore/changeinfo?id=<%= id %>"
  			method="post" name="myform" onsubmit="return changeinfo()">
  	<div class="info">	
  		<h1>账号信息</h1>
  		<div>&nbsp;&nbsp;账号：<input type="text" name="id" value="<%= id %>" disabled="disabled">
  		</div>
  		<div>&nbsp;&nbsp;姓名：<input type="text" name="name" >
  			<font>姓名不能为空</font>
  		</div>
  		<div>&nbsp;&nbsp;性别：<input type="radio" name="sex" value="man" checked="checked" id="man">
  							  <label for="man">男</label>
  							  <input type="radio" name="sex" value="womman" id="woman">
  							  <label for="woman">女</label>
  		</div>
  		<div>&nbsp;&nbsp;电话：<input type="text" name="phone">		
  		</div>
  		<input type="submit" value="保存" id="save">	
  	</div>			
  	</form>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'iderror.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script language="javascript">
	function message() {
		alert("账号已存在，请重新注册");
		window.open("/onlinebookstore/user/register/register.jsp", "_top");
	}
	</script>
	
  </head>
  
  <body onload="message()">
    <h3>账号已存在，请重新注册</h3>
  </body>
</html>
